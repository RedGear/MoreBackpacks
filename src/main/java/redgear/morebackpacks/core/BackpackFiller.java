package redgear.morebackpacks.core;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import redgear.core.compat.ModConfigHelper;
import redgear.core.compat.Mods;
import redgear.core.mod.FileHelper;
import redgear.core.util.StringHelper;
import cpw.mods.fml.common.Loader;
import forestry.api.storage.BackpackManager;
import forestry.api.storage.IBackpackDefinition;

public class BackpackFiller {
	private final File scriptDir;

	public BackpackFiller(File minecraftDir) {
		scriptDir = new File(minecraftDir, StringHelper.concat("RedGear", StringHelper.slash, "morebackpacks scripts"));
	}

	public void fillBackpacks() {
		fillDictionary();
		fillScripts();

		if (Mods.Thaum.isIn())
			fillThaumcraft();

		if (Mods.MetallurgyBase.isIn())
			fillMetallurgyUtility();
	}

	private void fillScripts() {
		if (!scriptDir.exists()) //If the script directory doesn't exist ...
		{
			scriptDir.mkdir(); //create the directory ...
			return; //then finish since there can't possibly be any scripts
		}

		Stack<File> subFiles = new Stack<File>();
		subFiles.addAll(Arrays.asList(scriptDir.listFiles()));

		if (subFiles == null || subFiles.size() == 0)
			return;    // nothing to do here

		String packName = "";
		String itemName = "";
		int start = -1;
		int end = -1;
		boolean skip;
		boolean special = false;
		boolean ignore = false;
		String buffer = "";
		File file;

		while (!subFiles.empty()) {
			file = subFiles.pop();

			try {
				if (file.isDirectory()) {
					File[] addFiles = file.listFiles();

					for (File addFile : addFiles)
						subFiles.push(addFile);
				} else if (file.getName().endsWith(".txt")) {
					MoreBackpacks.inst.myLogger.info("Reading script file: " + file.getName());
					//List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.US_ASCII);
					List<String> lines = FileHelper.readLines(file);

					for (String line : lines) {
						line.trim();
						skip = false;

						for (char working : line.toCharArray()) {
							if (special) {
								buffer += working;
								buffer.trim();
								special = false;
								continue;
							}

							if (ignore && working != '}')
								continue;

							switch (working) {
							case '\\': //ignore the following char
								special = true;
								break;

							case '#': //comment: ignore everything after this char on this line
								skip = true;
								break;

							case '!': //print out the rest of this line to the debug log
								MoreBackpacks.inst.logDebug(line.substring(line.indexOf(working) + 1));
								skip = true;
								break;

							case '{'://only do the rest if modId is found
								if (!Loader.isModLoaded(buffer))
									ignore = true;
								buffer = "";
								break;

							case '}': //end of mod
								ignore = false;
								break;

							case '$': //clears all saved data, not needed but might be useful
								packName = "";
								itemName = "";
								start = -1;
								end = -1;
								buffer = "";
								ignore = false;
								break;

							case '@': //denotes end of backpack name
								packName = buffer;
								buffer = "";
								break;

							case ':': //denotes end of item name
								itemName = buffer;
								buffer = "";
								break;

							case '-': //denotes end of first number
								try {
									start = Integer.parseInt(buffer);
									buffer = "";
								} catch (NumberFormatException e) {
									start = -1;   //if the parse doesn't work, just ignore it and put -1
								}

								break;

							case ';': //denotes end of second number/end of set
								try {
									end = Integer.parseInt(buffer);
								} catch (NumberFormatException e) {
									end = -1;   //if the parse doesn't work, just ignore it and put -1
								}

								if (start == -1 && end == -1)
									addItem(packName, itemName);

								if (start != -1 && end == -1)
									addItem(packName, itemName, start);

								if (end != -1)
									addItem(packName, itemName, start == -1 ? 0 : start, end);

								start = -1;
								end = -1;
								buffer = "";
								break;

							default:
								buffer += working;
								buffer.trim(); //Whitespace is never ever used, best to get rid of it.
							}

							if (skip)
								break;    //break out of the for and stop possessing this line.
						}
					}
				} else
					MoreBackpacks.inst.myLogger.warning("Invalid file in script folder: " + file.getName());

				//reset everything between files
				packName = "";
				itemName = "";
				start = -1;
				end = -1;
				buffer = "";
			} catch (Exception e) {
				MoreBackpacks.inst.myLogger.warning("Error reading script file: " + file.getName());
				MoreBackpacks.inst.logDebug("", e);
			}
		}
	}

	private void fillDictionary() {
		String[] dict = OreDictionary.getOreNames();

		for (String oreName : dict)
			if (oreName != null && oreName.startsWith("ore"))
				addItem("miner", OreDictionary.getOres(oreName).toArray(new ItemStack[0]));
	}

	private void fillThaumcraft() {
		addItem("miner", "tile.blockCustomOre");
		addItem("miner", "item.ItemShard");
		addItem("miner", "item.ItemResource", 3); //quick silver
		addItem("miner", "item.ItemResource", 6); //amber
		addItem("forester", "tile.blockCustomPlant");
		addItem("forester", "tile.blockMagicalLog");
		addItem("forester", "tile.blockMagicalLeaves");
		addItem("hunter", "item.ItemResource", 5); // zombie brain
	}

	private void fillMetallurgyUtility() {
		String names[] = {"Phosphorus", "Sulfur", "Saltpeter", "Magnesium", "Potash", "Bitumen" };

		for (String item : names)
			addItem("miner", "item.Metallurgy:Utility/" + item);
	}

	/*
	 * miner
	 * builder
	 * forester
	 * digger
	 * hunter
	 * adventurer
	 */

	public void addItem(String backpackKey, ItemStack item) {
		if (item == null)
			return;

		IBackpackDefinition backpack = BackpackManager.definitions.get(backpackKey);

		if (backpack == null) {
			MoreBackpacks.inst.logDebug("BackpackFiller Can't Find Backpack: " + backpackKey);
			return;
		}

		backpack.addValidItem(item);
	}

	public void addItem(String backpackKey, String itemName) {
		addItem(backpackKey, ModConfigHelper.get(itemName));
	}

	public void addItem(String backpackKey, String itemName, int meta) {
		addItem(backpackKey, ModConfigHelper.get(itemName, meta));
	}

	public void addItem(String backpackKey, String itemName, int startMeta, int endMeta) {
		ItemStack test = ModConfigHelper.get(itemName);

		if (test == null)
			return;

		addItem(backpackKey, test.itemID, startMeta, endMeta);
	}

	public void addItem(String backpackKey, int itemID, int startMeta, int endMeta) {
		for (int i = startMeta; i <= endMeta; i++)
			addItem(backpackKey, new ItemStack(itemID, 1, i));
	}

	private void addItem(String backpackKey, ItemStack[] array) {
		for (ItemStack stack : array)
			addItem(backpackKey, stack);
	}
}
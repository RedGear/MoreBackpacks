package redgear.morebackpacks.core;

import java.util.Collection;
import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import redgear.core.compat.ModConfigHelper;
import redgear.core.util.SimpleItem;
import cpw.mods.fml.common.registry.LanguageRegistry;
import forestry.api.storage.IBackpackDefinition;

public abstract class BasicBackpack implements IBackpackDefinition {
	protected HashSet<SimpleItem> itemsList = new HashSet<SimpleItem>(20);
	public SimpleItem backpackT1;
	public SimpleItem backpackT2;
	private final String unlocalname;

	protected BasicBackpack(String unlocalname) {
		this.unlocalname = unlocalname;
	}

	public abstract void fill();

	/**
	 * Returns true if all mods needed for this backpack are installed.
	 * Defaults to true
	 * 
	 * @return true if mods are installed, false if not
	 */
	public boolean modsLoaded() {
		return true;
	}

	public abstract ItemStack getCraftingItem();

	@Override
	public void addValidItem(ItemStack validItem) {
		if (validItem == null)
			return;    //Item can't be null

		addItem(validItem.itemID, validItem.getItemDamage());
	}

	public void addItem(int id, int meta) {
		if (id <= 0 || id >= Item.itemsList.length)
			return;    //Id must be valid

		if (Item.itemsList[id] == null)
			return;    //Item must really exist

		SimpleItem temp = new SimpleItem(id, meta);

		if (itemsList.contains(temp))
			return;    //No sense in holding the same item twice

		itemsList.add(temp);
	}

	public void addItem(Item validItem) {
		if (validItem != null)
			addItem(validItem.itemID, OreDictionary.WILDCARD_VALUE);
	}

	public void addItem(Block validItem) {
		if (validItem != null)
			addItem(validItem.blockID, OreDictionary.WILDCARD_VALUE);
	}

	@Override
	public Collection<ItemStack> getValidItems(EntityPlayer player) {
		HashSet<ItemStack> stack = new HashSet<ItemStack>(itemsList.size() - 1);

		for (SimpleItem item : itemsList)
			stack.add(item.getStack());

		return stack;
	}

	@Override
	public boolean isValidItem(EntityPlayer player, ItemStack check) {
		return itemsList.contains(new SimpleItem(check));
	}

	@Override
	public int getSecondaryColour() {
		return 16777215;
	}

	public void addItem(String itemName) {
		addValidItem(ModConfigHelper.get(itemName));
	}

	public void addItem(String itemName, int meta) {
		addValidItem(ModConfigHelper.get(itemName, meta));
	}

	public void addItems(ItemStack[] items) {
		for (ItemStack each : items)
			addValidItem(each);
	}

	public void addItems(String[] itemNames) {
		for (String name : itemNames)
			addItem(name);
	}

	public void addItemsFromMeta(int Id, int startMeta, int endMeta) {
		for (int i = startMeta; i <= endMeta; i++)
			addItem(Id, i);
	}

	public void addItemsFromMeta(int Id, int endMeta) {
		addItemsFromMeta(Id, 0, endMeta);
	}

	public void addItemsFromMeta(String itemName, int startMeta, int endMeta) {
		ItemStack test = ModConfigHelper.get(itemName);

		if (test != null)
			addItemsFromMeta(test.itemID, startMeta, endMeta);
	}

	public void addItemsFromMeta(String itemName, int endMeta) {
		addItemsFromMeta(itemName, 0, endMeta);
	}

	@Override
	public final String getKey() {
		return unlocalname.toLowerCase();
	}

	@Override
	public final String getName() {
		return LanguageRegistry.instance().getStringLocalization(
				"item.RedGear.MoreBackpacks.Backpack." + unlocalname + ".name");
	}

}

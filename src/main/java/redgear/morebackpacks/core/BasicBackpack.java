package redgear.morebackpacks.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import redgear.core.util.SimpleItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import forestry.api.storage.IBackpackDefinition;

public abstract class BasicBackpack implements IBackpackDefinition {
	protected Set<SimpleItem> itemsList = new HashSet<SimpleItem>(20);
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

	public void addItem(SimpleItem item) {
		itemsList.add(item);
	}

	public void addItem(ItemStack validItem) {
		if (validItem == null)
			return;    //Item can't be null

		addItem(new SimpleItem(validItem));
	}

	@Override
	public void addValidItem(ItemStack validItem) {
		addItem(validItem);
	}

	public void addItem(Item validItem) {
		if (validItem != null)
			addItem(new SimpleItem(validItem));
	}

	public void addItem(Block validItem) {
		if (validItem != null)
			addItem(new SimpleItem(validItem));
	}

	public void addItem(Item validItem, int meta) {
		if (validItem != null)
			addItem(new SimpleItem(validItem, meta));
	}

	public void addItem(Block validItem, int meta) {
		if (validItem != null)
			addItem(new SimpleItem(validItem, meta));
	}

	@Override
	public Collection<ItemStack> getValidItems(EntityPlayer player) {
		Set<ItemStack> stack = new HashSet<ItemStack>(itemsList.size() - 1);

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

	public void addItem(String modName, String itemName) {
		addItem(GameRegistry.findItem(modName, itemName));
	}

	public void addItem(String modName, String itemName, int meta) {
		addItem(GameRegistry.findItem(modName, itemName), meta);
	}

	public void addItems(ItemStack[] items) {
		for (ItemStack each : items)
			addValidItem(each);
	}

	public void addItems(String modName, String[] itemNames) {
		for (String name : itemNames)
			addItem(modName, name);
	}

	public void addItemsFromMeta(Item item, int startMeta, int endMeta) {
		for (int i = startMeta; i <= endMeta; i++)
			addItem(item, i);
	}

	public void addItemsFromMeta(Item item, int endMeta) {
		addItemsFromMeta(item, 0, endMeta);
	}

	public void addItemsFromMeta(String modName, String itemName, int startMeta, int endMeta) {
		Item test = GameRegistry.findItem(modName, itemName);

		if (test != null)
			addItemsFromMeta(test, startMeta, endMeta);
	}

	public void addItemsFromMeta(String modName, String itemName, int endMeta) {
		addItemsFromMeta(modName, itemName, 0, endMeta);
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

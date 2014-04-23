package redgear.morebackpacks.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import redgear.core.util.SimpleItem;
import forestry.api.storage.IBackpackDefinition;

public abstract class BasicBackpack implements IBackpackDefinition {
	public Collection<SimpleItem> itemsList = new LinkedList<SimpleItem>();
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
		if(!itemsList.contains(item))
			itemsList.add(item);
	}

	public void addItem(ItemStack validItem) {
		addItem(new SimpleItem(validItem));
	}

	@Override
	public void addValidItem(ItemStack validItem) {
		addItem(validItem);
	}

	public void addItem(Item validItem) {
		if (validItem != null)
			addItem(new SimpleItem(validItem, OreDictionary.WILDCARD_VALUE));
	}

	public void addItem(Block validItem) {
		if (validItem != null)
			addItem(new SimpleItem(validItem, OreDictionary.WILDCARD_VALUE));
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
	public final Collection<ItemStack> getValidItems(EntityPlayer player) {
		Collection<ItemStack> stack = new ArrayList<ItemStack>(itemsList.size());

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

	public void addItemsFromMeta(Item item, int startMeta, int endMeta) {
		for (int i = startMeta; i <= endMeta; i++)
			addItem(item, i);
	}

	public void addItemsFromMeta(Item item, int endMeta) {
		addItemsFromMeta(item, 0, endMeta);
	}

	@Override
	public final String getKey() {
		return unlocalname.toLowerCase();
	}

	@Override
	public final String getName() {
		return StatCollector.translateToLocal("item.RedGear.MoreBackpacks.Backpack." + unlocalname + ".name");
	}

}

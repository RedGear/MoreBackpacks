package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackMagician extends BasicBackpack {

	public BackpackMagician() {
		super("Magician");
	}

	@Override
	public boolean modsLoaded() {
		return Mods.Thaum.isIn();
	}

	@Override
	public int getPrimaryColour() {
		return 10040217;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.book); //ModConfigHelper.get("item.ItemShard");
	}
}

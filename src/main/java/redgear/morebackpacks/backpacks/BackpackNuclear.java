package redgear.morebackpacks.backpacks;

import net.minecraft.item.ItemStack;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackNuclear extends BasicBackpack {
	public BackpackNuclear() {
		super("Ic2nuclear");
	}

	@Override
	public boolean modsLoaded() {
		return false; //Mods.IC2.isIn();
	}

	@Override
	public int getPrimaryColour() {
		return 1506326;
	}

	@Override
	public ItemStack getCraftingItem() {
		return null; //ModConfigHelper.get("reactorCoolantSimple");
	}
}

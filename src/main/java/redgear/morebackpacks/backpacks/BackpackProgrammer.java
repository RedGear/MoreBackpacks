package redgear.morebackpacks.backpacks;

import net.minecraft.item.ItemStack;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackProgrammer extends BasicBackpack {
	public BackpackProgrammer() {
		super("Programmer");
	}

	@Override
	public boolean modsLoaded() {
		return false; //Mods.ComputerCraft.isIn();
	}

	@Override
	public int getPrimaryColour() {
		return 6750003;
	}

	@Override
	public ItemStack getCraftingItem() {
		return null; //ModConfigHelper.get("tile.cccable", 0);
	}
}

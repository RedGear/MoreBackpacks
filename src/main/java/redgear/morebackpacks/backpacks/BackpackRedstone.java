package redgear.morebackpacks.backpacks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackRedstone extends BasicBackpack {
	public BackpackRedstone() {
		super("Redstone");
	}

	@Override
	public int getPrimaryColour() {
		return 16711680;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Blocks.redstone_torch);
	}
}

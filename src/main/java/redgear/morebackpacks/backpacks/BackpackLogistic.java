package redgear.morebackpacks.backpacks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackLogistic extends BasicBackpack {

	public BackpackLogistic() {
		super("Logistic");
	}

	@Override
	public int getPrimaryColour() {
		return 5013682;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Blocks.rail);
	}
}

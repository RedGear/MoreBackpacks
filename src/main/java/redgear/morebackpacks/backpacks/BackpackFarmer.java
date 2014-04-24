package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackFarmer extends BasicBackpack {

	public BackpackFarmer() {
		super("Farmer");
	}

	@Override
	public int getPrimaryColour() {
		return 3381606;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.wheat_seeds);
	}
}

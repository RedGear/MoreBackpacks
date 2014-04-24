package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackSurvival extends BasicBackpack {
	public BackpackSurvival() {
		super("Survival");
	}

	@Override
	public int getPrimaryColour() {
		return 6697728;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.cooked_porkchop);
	}
}

package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackElectrician extends BasicBackpack {
	public BackpackElectrician() {
		super("Electric");
	}

	@Override
	public int getPrimaryColour() {
		return 14474460;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.redstone);
	}
}

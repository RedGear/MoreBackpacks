package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackHydraulic extends BasicBackpack {

	public BackpackHydraulic() {
		super("Hydraulic");
	}

	@Override
	public void fill() {
		FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();

		for (FluidContainerData each : data) {
			addValidItem(each.emptyContainer); // These will try to put the same ones multiple times, but that's ok
			addValidItem(each.filledContainer);
		}
	}

	@Override
	public int getPrimaryColour() {
		return 255;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.bucket);
	}
}

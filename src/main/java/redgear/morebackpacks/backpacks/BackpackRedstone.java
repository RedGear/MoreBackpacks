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
	public void fill() {
		addItem(Items.redstone);
		addItem(Items.repeater);
		addItem(Items.comparator);
		addItem(Blocks.redstone_torch);
		addItem(Blocks.wooden_pressure_plate);
		addItem(Blocks.stone_pressure_plate);
		addItem(Blocks.lever);
		addItem(Blocks.command_block);
		addItem(Blocks.stone_button);
		addItem(Blocks.wooden_button);
		addItem(Blocks.tripwire_hook);
		addItem(Blocks.piston);
		addItem(Blocks.sticky_piston);

		if (Mods.BCCore.isIn()) {
			/*addItem("item.pipeGate");

			addItem("item.greenPipeWire");
			addItem("item.redPipeWire");
			addItem("item.bluePipeWire");
			addItem("item.yellowPipeWire");

			addItem("item.pipeGateAutarchic");*/
		}
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

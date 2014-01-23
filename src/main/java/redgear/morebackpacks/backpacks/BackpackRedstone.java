package redgear.morebackpacks.backpacks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackRedstone extends BasicBackpack {
	public BackpackRedstone() {
		super("Redstone");
	}

	@Override
	public void fill() {
		addItem(Item.redstone);
		addItem(Item.redstoneRepeater);
		addItem(Item.comparator);
		addItem(Block.torchRedstoneActive);
		addItem(Block.pressurePlatePlanks);
		addItem(Block.pressurePlateStone);
		addItem(Block.lever);
		addItem(Block.commandBlock);
		addItem(Block.stoneButton);
		addItem(Block.woodenButton);
		addItem(Block.tripWireSource);
		addItem(Block.pistonBase);
		addItem(Block.pistonStickyBase);

		if (Mods.BuildcraftCore.isIn()) {
			addItem("item.pipeGate");

			addItem("item.greenPipeWire");
			addItem("item.redPipeWire");
			addItem("item.bluePipeWire");
			addItem("item.yellowPipeWire");

			addItem("item.pipeGateAutarchic");
		}
	}

	@Override
	public int getPrimaryColour() {
		return 16711680;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Block.blockRedstone);
	}
}

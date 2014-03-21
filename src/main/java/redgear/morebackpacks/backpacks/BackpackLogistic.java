package redgear.morebackpacks.backpacks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackLogistic extends BasicBackpack {

	public BackpackLogistic() {
		super("Logistic");
	}

	@Override
	public void fill() {
		addItem(Blocks.rail);
		addItem(Blocks.activator_rail);
		addItem(Blocks.detector_rail);
		addItem(Blocks.golden_rail);
		addItem(Blocks.hopper);
		addItem(Items.minecart);
		addItem(Items.chest_minecart);
		addItem(Items.furnace_minecart);
		addItem(Items.hopper_minecart);
		addItem(Items.tnt_minecart);
		//addItem("item.PipeItemsPropolis");

		if (Mods.StevesCarts.isIn()) {
			/*addItem("tile.SC2BlockCargoManager");
			addItem("tile.SC2BlockJunction");
			addItem("tile.SC2BlockAdvDetector");
			addItem("tile.SC2BlockCartAssembler");
			addItem("tile.SC2BlockActivator");
			addItem("tile.SC2BlockDistributor");
			addItem("tile.SC2BlockDetector");
			addItem("tile.SC2BlockLiquidManager");
			addItem("tile.BlockUpgrade");
			addItem("item.SC2ModularCart");
			addItem("item.SC2unknowncomponent");
			addItem("item.SC2unknownmodule");*/
		}

		if (Mods.Railcraft.isIn()) {
			/*String cart = "item.railcraft.cart.";
			String[] cartTypes = {"basic", "chest", "furnace", "tnt", "anchor", "anchor.admin", "anchor.personal",
					"bore", "energy.batbox", "energy.mfe", "energy.mfsu", "gift", "loco.steam", "pumpkin", "tank",
					"tnt.wood", "track.relayer", "undercutter", "work" };

			for (String name : cartTypes)
				addItem(cart + name);

			String tile = "tile.railcraft.";
			addItem(tile + "track.elevator");
			addItem(tile + "track");
			addItem(tile + "detector");
			addItem(tile + "machine.gamma");
			addItem(tile + "signal");*/
		}

		if (Mods.BCCore.isIn()) {
			/*addItem("item.pipeFacade");
			addItem("item.pipePlug");
			addItem("item.PipeStructureCobblestone");
			String materials[] = {"Wood", "Emerald", "Stone", "Cobblestone", "Iron", "Gold", "Diamond", "Obsidian",
					"Void", "Sandstone", "Quartz", "Lapis", "Daizuli" };

			for (String i : materials)
				addItem("item.PipeItems" + i);*/
		}
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

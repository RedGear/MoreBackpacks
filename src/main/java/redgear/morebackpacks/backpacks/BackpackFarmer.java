package redgear.morebackpacks.backpacks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackFarmer extends BasicBackpack {

	public BackpackFarmer() {
		super("Farmer");
	}

	@Override
	public void fill() {
		addItem(Items.wheat_seeds);
		addItem(Items.wheat);
		addItem(Items.carrot);
		addItem(Items.potato);
		addItem(Items.poisonous_potato);
		addItem(Items.reeds);
		addItem(Items.nether_wart);
		addItem(Items.melon);
		addItem(Items.melon_seeds);
		addItem(Items.pumpkin_seeds);
		addItem(Blocks.cactus);
		addItem(Blocks.pumpkin);
		addItem(Blocks.brown_mushroom_block);
		addItem(Blocks.red_mushroom_block);
		addItem(Blocks.cocoa);

		if (Mods.IC2.isIn()) {
			/*
			 * addItem("itemCropSeed");
			 * addItem("itemCropnalyzer");
			 * addItem("itemFertilizer");
			 * addItem("itemCellHydrant");
			 * addItem("itemWeedEx");
			 * addItem("itemTerraWart");
			 * addItem("itemCofeeBeans");
			 * addItem("itemHops");
			 */
		}
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

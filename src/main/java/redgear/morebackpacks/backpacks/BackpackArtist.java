package redgear.morebackpacks.backpacks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackArtist extends BasicBackpack {

	public BackpackArtist() {
		super("Artist");
	}

	@Override
	public void fill()   //Cloud? Yep, IC2 called LightBlue "Cloud". IDK
	{
		String colors[] = {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGrey", "Grey",
				"LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White", "Cloud",
				"DarkGrey" };

		for (String colorName : colors)
			for (ItemStack items : OreDictionary.getOres("dye" + colorName))
				addValidItem(items);

		addItem(Blocks.wool);
		addItem(Blocks.stonebrick);
		addItem(Blocks.sandstone);
		addItem(Blocks.quartz_block);
		addItem(Blocks.stone_slab);
		addItem(Blocks.double_stone_slab);
		addItem(Blocks.wooden_slab);
		addItem(Blocks.double_wooden_slab);
		addItem(Blocks.brick_block);
		addItem(Blocks.mossy_cobblestone);
		addItem(Blocks.jukebox);
		addItem(Blocks.noteblock);
		addItem(Blocks.bookshelf);
		addItem(Blocks.brick_stairs);
		addItem(Blocks.stone_brick_stairs);
		addItem(Blocks.nether_brick_stairs);
		addItem(Blocks.quartz_stairs);
		addItem(Blocks.sandstone_stairs);
		addItem(Blocks.stone_brick_stairs);
		addItem(Blocks.oak_stairs);
		addItem(Blocks.birch_stairs);
		addItem(Blocks.jungle_stairs);
		addItem(Blocks.spruce_stairs);
		addItem(Blocks.nether_brick);
		addItem(Blocks.nether_brick_fence);
		addItem(Blocks.fence);
		addItem(Blocks.fence_gate);
		addItem(Blocks.iron_bars);
		addItem(Blocks.cobblestone_wall);
		addItem(Blocks.torch);
		addItem(Blocks.redstone_lamp);
		addItem(Blocks.glowstone);
		addItem(Blocks.glass);
		addItem(Blocks.glass_pane);
		addItem(Blocks.pumpkin);

		//Forestry
		/*
		 * addItem("tile.candle");
		 * addItem("tile.stump"); //unlit candle
		 * addItem("tile.stained");
		 * addItem("tile.for.planks");
		 * addItem("tile.for.planks2");
		 * addItem("tile.for.slabs1");
		 * addItem("tile.for.slabs2");
		 * addItem("tile.for.slabs3");
		 * addItem("tile.for.fences");
		 * addItem("tile.for.fences2");
		 * addItem("tile.for.stairs");
		 */

		if (Mods.IC2.isIn()) {/*
							 * String tool = "itemToolPainter";
							 * addValidItem(ModConfigHelper.get(tool));
							 * 
							 * for (String colorName : colors)
							 * addItem(tool + colorName);
							 * 
							 * addItem("blockIronScaffold");
							 * addItem("blockScaffold");
							 * addItem("blockFenceIron");
							 * addItem("blockWall");
							 * addItem("blockFoam");
							 * addItem("blockLuminatorDark");
							 * addItem("blockAlloyGlass");
							 * addItem("blockAlloy");
							 */
		}

		if (Mods.ThermalExpansion.isIn()) {
			/*
			 * addItem("tile.blockTable");
			 * addItem("tile.blockCandle");
			 * addItem("tile.blockSecure");
			 * addItem("tile.blockCosmeticOpaque");
			 * addItem("tile.blockCosmeticSolid");
			 */
		}

		if (Mods.Railcraft.isIn())  //Not working right now
		{
			/*
			 * String tile = "tile.railcraft.";
			 * addItem(tile + "machine.alpha");
			 * addItem(tile + "cube", 1); // Skip 2
			 * addItemsFromMeta(tile + "cube", 3, 5);
			 * addItem(tile + "post");
			 * addItem(tile + "post.metal");
			 * addItem(tile + "wall.alpha");
			 * addItem(tile + "wall.beta");
			 * addItem(tile + "stair");
			 */
		}
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.dye, 1, 11);
	}

	@Override
	public int getPrimaryColour() {
		return 16184887;
	}
}

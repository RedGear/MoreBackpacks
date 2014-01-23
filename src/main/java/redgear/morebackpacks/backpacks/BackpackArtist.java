package redgear.morebackpacks.backpacks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import redgear.core.compat.ModConfigHelper;
import redgear.core.compat.Mods;
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

		addItem(Block.cloth);
		addItem(Block.stoneBrick);
		addItem(Block.sandStone);
		addItem(Block.blockNetherQuartz);
		addItem(Block.stoneDoubleSlab);
		addItem(Block.stoneSingleSlab);
		addItem(Block.woodDoubleSlab);
		addItem(Block.woodSingleSlab);
		addItem(Block.brick);
		addItem(Block.cobblestoneMossy);
		addItem(Block.jukebox);
		addItem(Block.music);
		addItem(Block.bookShelf);
		addItem(Block.stairsBrick);
		addItem(Block.stairsCobblestone);
		addItem(Block.stairsNetherBrick);
		addItem(Block.stairsNetherQuartz);
		addItem(Block.stairsSandStone);
		addItem(Block.stairsStoneBrick);
		addItem(Block.stairsWoodBirch);
		addItem(Block.stairsWoodJungle);
		addItem(Block.stairsWoodOak);
		addItem(Block.stairsWoodSpruce);
		addItem(Block.netherBrick);
		addItem(Block.netherFence);
		addItem(Block.fence);
		addItem(Block.fenceGate);
		addItem(Block.fenceIron);
		addItem(Block.cobblestoneWall);
		addItem(Block.torchWood);
		addItem(Block.redstoneLampIdle);
		addItem(Block.glowStone);
		addItem(Block.glass);
		addItem(Block.thinGlass);
		addItem(Block.pumpkinLantern);
		addItem("tile.candle");
		addItem("tile.stump"); //unlit candle
		addItem("tile.stained");
		addItem("tile.for.planks");
		addItem("tile.for.planks2");
		addItem("tile.for.slabs1");
		addItem("tile.for.slabs2");
		addItem("tile.for.slabs3");
		addItem("tile.for.fences");
		addItem("tile.for.fences2");
		addItem("tile.for.stairs");

		if (Mods.IC2.isIn()) {
			String tool = "itemToolPainter";
			addValidItem(ModConfigHelper.get(tool));

			for (String colorName : colors)
				addItem(tool + colorName);

			addItem("blockIronScaffold");
			addItem("blockScaffold");
			addItem("blockFenceIron");
			addItem("blockWall");
			addItem("blockFoam");
			addItem("blockLuminatorDark");
			addItem("blockAlloyGlass");
			addItem("blockAlloy");
		}

		if (Mods.ThermalExpansion.isIn()) {
			addItem("tile.blockTable");
			addItem("tile.blockCandle");
			addItem("tile.blockSecure");
			addItem("tile.blockCosmeticOpaque");
			addItem("tile.blockCosmeticSolid");
		}

		if (Mods.Railcraft.isIn())  //Not working right now
		{
			String tile = "tile.railcraft.";
			addItem(tile + "machine.alpha");
			addItem(tile + "cube", 1); // Skip 2
			addItemsFromMeta(tile + "cube", 3, 5);
			addItem(tile + "post");
			addItem(tile + "post.metal");
			addItem(tile + "wall.alpha");
			addItem(tile + "wall.beta");
			addItem(tile + "stair");
		}
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Item.dyePowder, 1, 11);
	}

	@Override
	public int getPrimaryColour() {
		return 16184887;
	}
}

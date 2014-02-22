package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackMagician extends BasicBackpack {

	public BackpackMagician() {
		super("Magician");
	}

	@Override
	public void fill() {
		addItem(Items.enchanted_book);
		addItem(Items.experience_bottle);

		if (Mods.Thaum.isIn()) {
			/*addItem("item.WandCastingApprentice");
			addItem("item.WandCastingAdept");
			addItem("item.WandCastingMage");
			addItem("item.WandFire");
			addItem("item.WandLightning");
			addItem("item.Hellrod");
			addItem("item.WandFrost");
			addItem("item.WandTrade");
			addItem("item.WandExcavation");
			addItem("tile.blockJar");
			addItem("tile.blockTable");
			addItem("tile.blockLifter");
			addItem("item.ItemInkwell");
			addItem("item.ItemThaumonomicon");
			addItem("item.ItemPortableHole");
			addItem("item.ItemThaumometer");
			addItem("item.ItemGoggles");
			addItem("item.ArcaneDoorKey");
			addItem("tile.blockMirror");
			addItem("item.HandMirror");
			addItem("item.ItemResource");
			addItem("item.ItemShard");
			addItem("item.ItemResearchNotes");
			addItem("tile.blockMarker");
			addItem("tile.blockCandle");
			addItem("tile.blockSecure");
			addItem("tile.blockWoodenDevice");
			addItem("tile.blockCrystal");
			addItem("tile.blockCrucible");
			addItem("tile.blockCustomPlant");
			addItem("tile.blockMagicalLog");
			addItem("tile.blockMagicalLeaves");
			addItem("item.ItemEssence");
			addItem("item.ItemWispEssence");
			addItem("item.BlockJarFilledItem");
			addItem("item.ItemGolemPlacer");
			addItem("item.ItemGolemCore");
			addItem("item.ItemGolemDecoration");*/
		}
	}

	@Override
	public boolean modsLoaded() {
		return Mods.Thaum.isIn();
	}

	@Override
	public int getPrimaryColour() {
		return 10040217;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.book); //ModConfigHelper.get("item.ItemShard");
	}
}

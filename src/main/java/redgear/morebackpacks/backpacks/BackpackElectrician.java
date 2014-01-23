package redgear.morebackpacks.backpacks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import redgear.core.compat.ModConfigHelper;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackElectrician extends BasicBackpack {
	public BackpackElectrician() {
		super("Electric");
	}

	@Override
	public void fill() {
		addItem("tile.for.engine"); //forestry engines

		if (Mods.IC2.isIn()) {
			addItem("itemCable");
			addItem("blockElectric");
			addItem("itemBatSU");
			addItem("itemBatREDischarged");
			addItem("itemBatLamaCrystal");
			addItem("itemBatCrystal");
			addItem("itemBatRE");
			addItem("itemToolMEter");
			addItem("blockGenerator");
		}

		if (Mods.BuildcraftCore.isIn()) {
			addItem("tile.engineBlock");

			if (Mods.BuildcraftCore.isIn()) {
				String materials[] = {"Wood", "Stone", "Cobblestone", "Gold", "Diamond", "Quartz" };

				for (String i : materials)
					addItem("item.PipePower" + i);

			}
		}

		if (Mods.Railcraft.isIn())
			addItemsFromMeta("tile.railcraft.machine.beta", 7, 9); //Steam engines
	}

	@Override
	public int getPrimaryColour() {
		return 14474460;
	}

	@Override
	public ItemStack getCraftingItem() {
		if (Mods.IC2.isIn())
			return ModConfigHelper.get("itemCable", 0);

		if (Mods.BuildcraftCore.isIn())
			return ModConfigHelper.get("item.PipePowerGold");

		return new ItemStack(Item.redstone);
	}
}

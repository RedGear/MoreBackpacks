package redgear.morebackpacks.backpacks;

import net.minecraft.item.ItemStack;
import redgear.core.compat.ModConfigHelper;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackNuclear extends BasicBackpack {
	public BackpackNuclear() {
		super("Ic2nuclear");
	}

	@Override
	public void fill() {
		addItem("reactorUraniumSimple");
		addItem("reactorUraniumDual");
		addItem("reactorUraniumQuad");
		addItem("reactorCoolantSimple");
		addItem("reactorCoolantTriple");
		addItem("reactorCoolantSix");
		addItem("reactorPlating");
		addItem("reactorPlatingHeat");
		addItem("reactorPlatingExplosive");
		addItem("reactorHeatSwitch");
		addItem("reactorHeatSwitchCore");
		addItem("reactorHeatSwitchSpread");
		addItem("reactorHeatSwitchDiamond");
		addItem("reactorVent");
		addItem("reactorVentCore");
		addItem("reactorVentGold");
		addItem("reactorVentSpread");
		addItem("reactorVentDiamond");
		addItem("itemRTGPellet");
		addItem("itemFuelrod");
		addItem("itemUran248");
		addItem("itemUran235small");
		addItem("itemUran235");
		addItem("itemPlutoniumSmall");
		addItem("itemPlutonium");
		addItem("itemMOX");
		addItem("reactorUraniumSimpledepleted");
		addItem("reactorUraniumQuaddepleted");
		addItem("reactorUraniumDualdepleted");
		addItem("reactorMOXSimpledepleted");
		addItem("reactorMOXQuaddepleted");
		addItem("reactorMOXDualdepleted");
		addItem("reactorMOXSimple");
		addItem("reactorMOXQuad");
		addItem("reactorMOXDual");
		addItem("reactorReflector");
		addItem("reactorReflectorThick");
		addItem("reactorCondensator");
		addItem("reactorCondensatorLap");
		addItem("blockReactorChamber");
		addItem("blockGenerator", 5);

		if (Mods.Greg.isIn()) {
			addItem("item.60k_Helium_Coolantcell");
			addItem("item.180k_Helium_Coolantcell");
			addItem("item.360k_Helium_Coolantcell");
			addItem("item.Iridium_Neutronreflector");
			addItem("item.Thoriumcell");
			addItem("item.Double_Thoriumcell");
			addItem("item.Quad_Thoriumcell");
			addItem("item.Plutoniumcell");
			addItem("item.Double_Plutoniumcell");
			addItem("item.Quad_Plutoniumcell");
			addItem("item.60k_NaK_Coolantcell");
			addItem("item.180k_NaK_Coolantcell");
			addItem("item.360k_NaK_Coolantcell");
		}
	}

	@Override
	public boolean modsLoaded() {
		return Mods.IC2.isIn();
	}

	@Override
	public int getPrimaryColour() {
		return 1506326;
	}

	@Override
	public ItemStack getCraftingItem() {
		return ModConfigHelper.get("reactorCoolantSimple");
	}
}

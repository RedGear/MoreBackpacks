package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redgear.core.mod.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackSurvival extends BasicBackpack {
	public BackpackSurvival() {
		super("Survival");
	}

	@Override
	public void fill() {
		addItem(Items.porkchop);
		addItem(Items.beef);
		addItem(Items.chicken);
		addItem(Items.baked_potato);
		addItem(Items.carrot);
		addItem(Items.cake);
		addItem(Items.bread);
		addItem(Items.apple);
		addItem(Items.golden_apple);
		addItem(Items.mushroom_stew);
		addItem(Items.bowl);
		addItem(Items.fish);
		addItem(Items.golden_carrot);
		addItem(Items.melon);
		addItem(Items.pumpkin_pie);
		addItem(Items.rotten_flesh);
		addItem(Items.speckled_melon);
		addItem(Items.cookie);
		/*addItem("item.honeyedSlice");
		addItem("item.ambrosia");
		addItem("item.honeyPot");*/

		if (Mods.IC2.isIn()) {
			/*addItem("itemTinCan");
			addItem("itemTinCanFilled");*/
		}

		if (Mods.Thaum.isIn()) {
			/*addItem("item.ItemNuggetChicken");
			addItem("item.ItemNuggetBeef");
			addItem("item.ItemNuggetPork");
			addItem("item.TripleMeatTreat");*/
		}

		if (Mods.Natura.isIn()) {
			/*addItem("item.berry.nether");
			addItem("item.berry");
			addItem("item.Natura.netherfood");
			addItem("item.natura.stewbowl");
			addItem("item.berryMedley");
			addItem("item.saguaro.fruit");*/
		}

		/*if (Mods.BiomesOPlenty.isIn())
			addItem("item.bop.food");*/
	}

	@Override
	public int getPrimaryColour() {
		return 6697728;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.porkchop);
	}
}

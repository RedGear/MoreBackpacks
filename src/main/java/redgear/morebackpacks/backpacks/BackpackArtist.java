package redgear.morebackpacks.backpacks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackArtist extends BasicBackpack {

	public BackpackArtist() {
		super("Artist");
	}

	@Override
	public void fill() {
		String[] dyes = {"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan",
				"dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta",
				"dyeOrange", "dyeWhite" };

		for (String colorName : dyes)
			for (ItemStack items : OreDictionary.getOres("dye" + colorName))
				addValidItem(items);
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

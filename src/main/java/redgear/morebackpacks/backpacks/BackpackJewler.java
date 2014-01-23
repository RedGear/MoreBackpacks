package redgear.morebackpacks.backpacks;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackJewler extends BasicBackpack {
	public BackpackJewler() {
		super("Jewler");
	}

	@Override
	public void fill() {
		String[] ores = OreDictionary.getOreNames();

		for (String ore : ores)
			if (ore != null && ore.startsWith("gem")) {
				ArrayList<ItemStack> temp = OreDictionary.getOres(ore);
				addItems(temp.toArray(new ItemStack[temp.size()]));
			}
	}

	@Override
	public int getPrimaryColour() {
		return 65535;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Item.emerald);
	}
}

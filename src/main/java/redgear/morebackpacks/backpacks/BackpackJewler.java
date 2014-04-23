package redgear.morebackpacks.backpacks;

import java.util.List;

import net.minecraft.init.Items;
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
				List<ItemStack> list = OreDictionary.getOres(ore);
				for(ItemStack stack : list)
					addItem(stack);
			}
	}

	@Override
	public int getPrimaryColour() {
		return 65535;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Items.emerald);
	}
}

package redgear.morebackpacks.backpacks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackFarmer extends BasicBackpack
{
    public void fill()
    {
        addItem(Item.seeds);
        addItem(Item.wheat);
        addItem(Item.carrot);
        addItem(Item.potato);
        addItem(Item.poisonousPotato);
        addItem(Item.reed);
        addItem(Item.netherStalkSeeds);
        addItem(Item.melon);
        addItem(Item.melonSeeds);
        addItem(Item.pumpkinSeeds);
        addItem(Block.cactus);
        addItem(Block.pumpkin);
        addItem(Block.mushroomBrown);
        addItem(Block.mushroomRed);
        addItem(Block.cocoaPlant);

        if (Mods.IC2.isIn())
        {
            addItem("itemCropSeed");
            addItem("itemCropnalyzer");
            addItem("itemFertilizer");
            addItem("itemCellHydrant");
            addItem("itemWeedEx");
            addItem("itemTerraWart");
            addItem("itemCofeeBeans");
            addItem("itemHops");
        }
    }

    public String getKey()
    {
        return "farmer";
    }

    public String getName()
    {
        return "Farmer's Backpack";
    }
    public int getPrimaryColour()
    {
        return 3381606;
    }

    @Override
    public ItemStack getCraftingItem()
    {
        return new ItemStack(Item.seeds);
    }
}

package redgear.morebackpacks.backpacks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackMagician extends BasicBackpack
{
    public void fill()
    {
        addItem(Item.enchantedBook);
        addItem(Item.expBottle);

        if (Mods.Thaum.isIn())
        {
            addItem("item.WandCastingApprentice");
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
            addItem("item.ItemGolemDecoration");
        }
    }

    public boolean modsLoaded()
    {
        return Mods.Thaum.isIn();
    }

    public String getKey()
    {
        return "magician";
    }

    public String getName()
    {
        return "Magician's Backpack";
    }

    public int getPrimaryColour()
    {
        return 10040217;
    }

    @Override
    public ItemStack getCraftingItem()
    {
        return new ItemStack(Item.enchantedBook); //ModConfigHelper.get("item.ItemShard");
    }
}

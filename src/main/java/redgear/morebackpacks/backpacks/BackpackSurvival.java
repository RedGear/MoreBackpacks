package redgear.morebackpacks.backpacks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackSurvival extends BasicBackpack
{
    public void fill()
    {
        addItem(Item.porkCooked);
        addItem(Item.beefCooked);
        addItem(Item.chickenCooked);
        addItem(Item.bakedPotato);
        addItem(Item.carrot);
        addItem(Item.cake);
        addItem(Item.bread);
        addItem(Item.appleRed);
        addItem(Item.appleGold);
        addItem(Item.bowlSoup);
        addItem(Item.bowlEmpty);
        addItem(Item.fishCooked);
        addItem(Item.goldenCarrot);
        addItem(Item.melon);
        addItem(Item.pumpkinPie);
        addItem(Item.rottenFlesh);
        addItem(Item.speckledMelon);
        addItem(Item.cookie);
        addItem("item.honeyedSlice");
        addItem("item.ambrosia");
        addItem("item.honeyPot");

        if (Mods.IC2.isIn())
        {
            addItem("itemTinCan");
            addItem("itemTinCanFilled");
        }

        if (Mods.Thaum.isIn())
        {
            addItem("item.ItemNuggetChicken");
            addItem("item.ItemNuggetBeef");
            addItem("item.ItemNuggetPork");
            addItem("item.TripleMeatTreat");
        }
        
        if(Mods.Natura.isIn()){
        	addItem("item.berry.nether");
        	addItem("item.berry");
        	addItem("item.Natura.netherfood");
        	addItem("item.natura.stewbowl");
        	addItem("item.berryMedley");
        	addItem("item.saguaro.fruit");
        }
        
        if(Mods.BiomesOPlenty.isIn()){
        	addItem("item.bop.food");
        }
    }

    public String getKey()
    {
        return "survival";
    }

    public String getName()
    {
        return "Survialist's Backpack";
    }

    public int getPrimaryColour()
    {
        return 6697728;
    }

    @Override
    public ItemStack getCraftingItem()
    {
        return new ItemStack(Item.porkCooked);
    }
}

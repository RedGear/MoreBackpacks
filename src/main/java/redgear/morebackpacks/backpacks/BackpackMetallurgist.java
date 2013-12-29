package redgear.morebackpacks.backpacks;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import redgear.morebackpacks.MoreBackpacks;
import redgear.morebackpacks.core.BasicBackpack;
import forestry.api.storage.BackpackStowEvent;

public class BackpackMetallurgist extends BasicBackpack{
	
	public BackpackMetallurgist(){
		 MinecraftForge.EVENT_BUS.register(this);
	}
	
    @Override
	public void fill()
    {
        String metals[] = {"Iron", "Gold", "Copper", "Tin", "Silver", "Lead", "Zinc", "Platinum", "Electrum", "Brass", "Inolashite",
                           "Plutonium", "TungstenSteel", "Astral Silver", "Uranium", "Ignatius", "Thorium", "Celenegil", "Amordrine", "Nickel",
                           "Tartarite", "Sanguinite", "Aluminum", "Haderoth", "Chrome", "Steel", "Damascus Steel", "Shadow Iron", "Aredrite",
                           "Lemurite", "Angmallen", "Desichalkos", "Quicksilver", "Atlarus", "Ceruclase", "Vyroxeres", "Eximite", "Manganese",
                           "Rubracium", "Mithril", "Titanium", "Iridium", "Bronze", "Invar", "Deep Iron", "Aluminium", "Adluorite", "Meutoite",
                           "Prometheum", "Hepatizon", "Kalendrite", "Orichalcum", "Adamantine", "Infuscolium", "RefinedIron", "Black Steel",
                           "Vulcanite", "Tungsten", "Magnesium", "Midasium", "Oureclase", "Carmot", "Shadow Steel", "Ardite", "Cobalt", "Osmium",
                           "Alumite", "AluminumBrass", "NaturalAluminum", "Manyullyn", "Alduorite"
                          };
        ArrayList<ItemStack> stacks;
        String prefixs [] = {"nugget", "ingot", "block", "plate", "dust", "dustSmall"};

        for (String metal : metals)
            for (String pre : prefixs)
            {
                stacks = OreDictionary.getOres(pre + metal);

                if (!stacks.isEmpty())
                    for (ItemStack item : stacks)
                    {
                        addValidItem(item);
                    }
            }
    }

    @ForgeSubscribe
    public void transmute(BackpackStowEvent event){
    	if(!event.backpackDefinition.getKey().equals(getKey()))
    		return;
    	
    	
        MoreBackpacks.inst.logDebug("Checking for transmutation");
        int inputOreId = OreDictionary.getOreID(event.stackToStow);
        ItemStack slot;

        if (inputOreId != -1)
            for (int i = 0; i < event.backpackInventory.getSizeInventory(); i++)
            {
                slot = event.backpackInventory.getStackInSlot(i);

                if (slot != null && OreDictionary.getOreID(slot) == inputOreId)
                {
                    MoreBackpacks.inst.logDebug("Transmuting metal");
                    event.stackToStow.itemID = slot.itemID;
                    event.stackToStow.setItemDamage(slot.getItemDamage());
                }
            }
    }

    @Override
    public String getKey()
    {
        return "metallurgist";
    }

    @Override
    public String getName()
    {
        return "Metallurgist's Backpack";
    }

    @Override
    public int getPrimaryColour()
    {
        return 10263741;
    }

    @Override
    public ItemStack getCraftingItem()
    {
        return new ItemStack(Item.ingotGold);
    }
}

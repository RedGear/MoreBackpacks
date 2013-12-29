package redgear.morebackpacks.backpacks;

import net.minecraft.item.ItemStack;
import redgear.core.compat.ModConfigHelper;
import redgear.core.compat.Mods;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackProgrammer extends BasicBackpack
{
    public void fill()
    {
        /*if (ModChecker.isRedpowerMechanicalIn())
        {
            
            	addValidItem(ModConfigHelper.get("com.eloraam.redpower.RedPowerBase", "blockMicro", 3072)); //Ribbon cable

            	String rpControl = "com.eloraam.redpower.RedPowerControl";

            	addValidItem(ModConfigHelper.get(rpControl, "blockBackplane", 0));
            	addValidItem(ModConfigHelper.get(rpControl, "blockBackplane", 1));

            	addValidItem(ModConfigHelper.get(rpControl, "blockPeripheral", 0));
            	addValidItem(ModConfigHelper.get(rpControl, "blockPeripheral", 1));
            	addValidItem(ModConfigHelper.get(rpControl, "blockPeripheral", 2));

            	addValidItem(ModConfigHelper.get(rpControl, "blockFlatPeripheral", 0));

            	addValidItem(ModConfigHelper.get(rpControl, "itemDisk", 0));
            	addValidItem(ModConfigHelper.get(rpControl, "itemDisk", 1)); //Forth boot disk
        }*/

        if (Mods.ComputerCraft.isIn())
        {
            addItem("tile.cccomputer"); // Computer
            addItem("tile.ccdiskdrive"); //Peripherals
            addItem("tile.cccable");
            addItem("item.ccdisk");
            addItem("item.ccprintout"); // Printed pages
            addItem("tile.ccturtle"); // Turtles
            addItem("tile.ccturtle");
        }
    }

    public boolean modsLoaded()
    {
        return Mods.ComputerCraft.isIn();
    }

    public String getKey()
    {
        return "programmer";
    }

    public String getName()
    {
        return "Programmer's Backpack";
    }

    public int getPrimaryColour()
    {
        return 6750003;
    }

    @Override
    public ItemStack getCraftingItem()
    {
        return ModConfigHelper.get("tile.cccable", 0);
    }
}

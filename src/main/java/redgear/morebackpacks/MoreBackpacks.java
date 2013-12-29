package redgear.morebackpacks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import redgear.core.mod.ModUtils;
import redgear.core.mod.RedGear;
import redgear.core.util.SimpleItem;
import redgear.morebackpacks.backpacks.BackpackArtist;
import redgear.morebackpacks.backpacks.BackpackElectrician;
import redgear.morebackpacks.backpacks.BackpackFarmer;
import redgear.morebackpacks.backpacks.BackpackHydraulic;
import redgear.morebackpacks.backpacks.BackpackJewler;
import redgear.morebackpacks.backpacks.BackpackLogistic;
import redgear.morebackpacks.backpacks.BackpackMagician;
import redgear.morebackpacks.backpacks.BackpackMetallurgist;
import redgear.morebackpacks.backpacks.BackpackNuclear;
import redgear.morebackpacks.backpacks.BackpackProgrammer;
import redgear.morebackpacks.backpacks.BackpackRedstone;
import redgear.morebackpacks.backpacks.BackpackSurvival;
import redgear.morebackpacks.core.BackpackFiller;
import redgear.morebackpacks.core.BasicBackpack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.core.ItemInterface;
import forestry.api.recipes.RecipeManagers;
import forestry.api.storage.BackpackManager;
import forestry.api.storage.EnumBackpackType;

@Mod(modid = RedGear.MoreBackpacksID, name= RedGear.MoreBackpacksName, version= RedGear.MoreBackpacksVersion, dependencies= RedGear.MoreBackpacksDepend)
public class MoreBackpacks extends ModUtils {
    
	@Instance(RedGear.MoreBackpacksID)
    public static ModUtils inst;
    
    private ItemStack wovenSilk;
    private static BackpackFiller filler;
    
    public MoreBackpacks() {
		super(0, 23500);
	}
    
    private ArrayList<BasicBackpack> backpacks = new ArrayList<BasicBackpack>();

    @Override
    public void PreInit(FMLPreInitializationEvent event){
        filler = new BackpackFiller(event.getModConfigurationDirectory());
       
        createBackpack(new BackpackRedstone()); //redstone stuff
        createBackpack(new BackpackFarmer()); //farmable plants, animals
        createBackpack(new BackpackSurvival()); //food
        createBackpack(new BackpackArtist()); //decorative blocks
        createBackpack(new BackpackMagician()); //anything magical
        createBackpack(new BackpackMetallurgist()); //metals
        createBackpack(new BackpackHydraulic()); //anything related to liquids
        createBackpack(new BackpackJewler()); //gems
        createBackpack(new BackpackLogistic()); //anything related to transport, from pipes to tubes to rails to hoppers
        createBackpack(new BackpackElectrician()); //anything related to any electricity system
        createBackpack(new BackpackNuclear()); //still only ic2
        createBackpack(new BackpackProgrammer()); //only computercraft or redpower computer stuff
    }

	@Override
	protected void Init(FMLInitializationEvent event) {
		
	}

    @Override
    public void PostInit(FMLPostInitializationEvent event){
    	wovenSilk = ItemInterface.getItem("craftingMaterial");
        wovenSilk.setItemDamage(3);
    	
        for(BasicBackpack def : backpacks)
        	fillBackpack(def);
        
        filler.fillBackpacks();
    }

    /**
    	Creates regular and woven backpack items
    	@param def The backpack definition
    */
    private void createBackpack(BasicBackpack def){
        int id = getId(def, EnumBackpackType.T1);
        def.backpackT1 = new SimpleItem(BackpackManager.backpackInterface.addBackpack(id, def, EnumBackpackType.T1));
        id = getId(def, EnumBackpackType.T2);
        def.backpackT2 = new SimpleItem(BackpackManager.backpackInterface.addBackpack(id, def, EnumBackpackType.T2)); 
        
        backpacks.add(def);
    }
    
    /**
     * Fills the backpack with items and creates recipe.
     * @param def
     */
    private void fillBackpack(BasicBackpack def){
    	ItemStack craftingItem = def.getCraftingItem();

        if (getEnabled(def.getKey()) && def.modsLoaded())
            if (craftingItem == null)
                logDebug("Can't find special item for " + def.getName() + "!");
            else{
                GameRegistry.addRecipe(def.backpackT1.getStack(), new Object[] {"SWS", "XCX", "SWS", 'S', Item.silk, 'W', Block.cloth, 'X', craftingItem, 'C', Block.chest});
                RecipeManagers.carpenterManager.addRecipe(200, FluidRegistry.getFluidStack("water", 1000), null, def.backpackT2.getStack(), new Object[] { "WXW", "WTW", "WWW", 'X', Item.diamond, 'W', wovenSilk, 'T', def.backpackT1.getStack()});
            }
    }

    private int getId(BasicBackpack def, EnumBackpackType type){
        return getItemId(def.getKey() + (type == EnumBackpackType.T1 ? "T1" : "T2"));
    }

    private boolean getEnabled(String key){
        return getBoolean(key, true);
    }
    
    @EventHandler public void PreInitialization(FMLPreInitializationEvent event){super.PreInitialization(event);}
	@EventHandler public void Initialization(FMLInitializationEvent event){super.Initialization(event);}
	@EventHandler public void PostInitialization(FMLPostInitializationEvent event){super.PostInitialization(event);}
}

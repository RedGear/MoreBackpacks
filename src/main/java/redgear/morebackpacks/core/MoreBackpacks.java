package redgear.morebackpacks.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import redgear.core.mod.ModUtils;
import redgear.core.util.SimpleItem;
import redgear.core.util.StringHelper;
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
import redgear.morebackpacks.config.BackpackDataBuilder;
import redgear.morebackpacks.config.ConfigReader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.recipes.RecipeManagers;
import forestry.api.storage.BackpackManager;
import forestry.api.storage.EnumBackpackType;

@Mod(modid = "redgear_morebackpacks", name = "More Backpacks", version = "@ModVersion@", dependencies = "required-after:redgear_core;required-after:Forestry;")
public class MoreBackpacks extends ModUtils {

	@Instance("redgear_morebackpacks")
	public static ModUtils inst;

	private SimpleItem wovenSilk;
	private File scriptDir;
	//private static BackpackFiller filler;

	private final List<BasicBackpack> backpacks = new ArrayList<BasicBackpack>();

	@Override
	public void PreInit(FMLPreInitializationEvent event) {
		//TODO: Backpack filler needs a full rewrite thanks to new GameRegistry.
		//filler = new BackpackFiller(event.getModConfigurationDirectory());

		scriptDir = new File(event.getModConfigurationDirectory(), StringHelper.concat("RedGear", StringHelper.slash,
				"morebackpacks"));

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
	public void PostInit(FMLPostInitializationEvent event) {
		wovenSilk = new SimpleItem(GameRegistry.findItem("Forestry", "craftingMaterial"), 3);

		if (!scriptDir.exists())//If the script directory doesn't exist ...
			scriptDir.mkdir(); //create the directory ...

		for (BasicBackpack def : backpacks)
			fillBackpack(def);
	}

	/**
	 * Creates regular and woven backpack items
	 *
	 * @param def The backpack definition
	 */
	private void createBackpack(BasicBackpack def) {
		def.backpackT1 = new SimpleItem(BackpackManager.backpackInterface.addBackpack(def, EnumBackpackType.T1));
		def.backpackT2 = new SimpleItem(BackpackManager.backpackInterface.addBackpack(def, EnumBackpackType.T2));

		GameRegistry.registerItem(def.backpackT1.getItem(), def.getKey() + "T1");
		GameRegistry.registerItem(def.backpackT2.getItem(), def.getKey() + "T2");

		backpacks.add(def);
	}

	/**
	 * Fills the backpack with items and creates recipe.
	 *
	 * @param def
	 */
	private void fillBackpack(BasicBackpack def) {
		logDebug("Creating backpack: ", def.getKey());
		def.fill();
		ItemStack craftingItem = def.getCraftingItem();

		if (getBoolean(def.getKey()) && def.modsLoaded())
			if (craftingItem == null)
				logDebug("Can't find special item for " + def.getName() + "!");
			else {
				GameRegistry.addRecipe(def.backpackT1.getStack(), new Object[] {"SWS", "XCX", "SWS", 'S', Items.string,
					'W', Blocks.wool, 'X', craftingItem, 'C', Blocks.chest });
				RecipeManagers.carpenterManager.addRecipe(200, FluidRegistry.getFluidStack("water", 1000), null,
						def.backpackT2.getStack(), new Object[] {"WXW", "WTW", "WWW", 'X', Items.diamond, 'W',
					wovenSilk.getStack(), 'T', def.backpackT1.getStack() });
			}

		File config = new File(scriptDir, def.getKey() + "Default.json");
		BackpackDataBuilder builder = new BackpackDataBuilder(def);
		ConfigReader.write(config, builder.build());
	}

	@Override
	@EventHandler
	public void PreInitialization(FMLPreInitializationEvent event) {
		super.PreInitialization(event);
	}

	@Override
	@EventHandler
	public void Initialization(FMLInitializationEvent event) {
		super.Initialization(event);
	}

	@Override
	@EventHandler
	public void PostInitialization(FMLPostInitializationEvent event) {
		super.PostInitialization(event);
	}
}

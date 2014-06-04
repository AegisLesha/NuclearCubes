package main.bigreactors.util;

import main.bigreactors.ConfigHandler;
import main.bigreactors.blocks.BlockRegistry;
import main.bigreactors.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	public static String oreYellorite = "oreYellorite";

	public static String ingotYellorium;
	public static String ingotIronOrSteel;
	public static String ingotCyanite = "ingotCyanite";
	public static String ingotBlutonium = "ingotBlutonium";
	public static String ingotGraphite = "ingotGraphite";

	public static String dustYellorium = "dustYellorium";
	public static String dustCyanite = "dustCyanite";
	public static String dustBlutonium = "dustBlutonium";
	public static String dustGraphite = "dustGraphite";

	private static void registerOreDict() {

		OreDictionary.registerOre(oreYellorite, new ItemStack(BlockRegistry.blockOres, 1, 0));

		//This is currently broken while I figure out how to work with the OreDict...
		if(ConfigHandler.registerYelloriteSmeltToUranium && OreDictionary.getOres("ingotUranium").size() > 0) {
			ingotYellorium = "ingotUranium";
			System.err.println("[DEBUG] ingotUranium");
		} else {
			ingotYellorium = "ingotYellorium";
			System.err.println("[DEBUG] ingotYellorium");
		}

		if(ConfigHandler.useSteelForIron && OreDictionary.getOres("ingotSteel").size() > 0) {
			ingotIronOrSteel = "ingotSteel";
			System.err.println("[DEBUG] ingotSteel");
		} else {
			ingotIronOrSteel = "ingotIron";
			System.err.println("[DEBUG] ingotIron");
		}

		OreDictionary.registerOre(ingotYellorium, new ItemStack(ItemRegistry.ingots, 1, 0));
		OreDictionary.registerOre(ingotCyanite, new ItemStack(ItemRegistry.ingots, 1, 1));
		OreDictionary.registerOre(ingotBlutonium, new ItemStack(ItemRegistry.ingots, 1, 2));
		OreDictionary.registerOre(ingotGraphite, new ItemStack(ItemRegistry.ingots, 1, 3));

		OreDictionary.registerOre(dustYellorium, new ItemStack(ItemRegistry.dusts, 1, 0));
		OreDictionary.registerOre(dustCyanite, new ItemStack(ItemRegistry.dusts, 1, 1));
		OreDictionary.registerOre(dustBlutonium, new ItemStack(ItemRegistry.dusts, 1, 2));
		OreDictionary.registerOre(dustGraphite, new ItemStack(ItemRegistry.dusts, 1, 3));
	}

	public static void registerFullOreDict() {
		registerOreDict();
		OreDictionary.initVanillaEntries();
	}
}

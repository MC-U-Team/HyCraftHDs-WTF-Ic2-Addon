package info.u_team.hycrafthds_wtf_ic2_addon.init;

import static info.u_team.hycrafthds_wtf_ic2_addon.init.WTFIC2AddonTes.*;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import ic2.core.block.*;
import ic2.core.uu.UuIndex;
import info.u_team.hycrafthds_wtf_ic2_addon.config.CommonConfig;
import info.u_team.hycrafthds_wtf_ic2_addon.util.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@SuppressWarnings("deprecation")
public class WTFIC2AddonRecipes {
	
	private static BlockTileEntity teBlock;
	
	public static void init() {
		teBlock = TeBlockRegistry.get(IDENTITY);
		
		ItemStack re_battery = ItemStackUtil.copyStackWithNewMetadata(IC2Items.getItem("re_battery"), OreDictionary.WILDCARD_VALUE);
		ItemStack advanced_re_battery = ItemStackUtil.copyStackWithNewMetadata(IC2Items.getItem("advanced_re_battery"), OreDictionary.WILDCARD_VALUE);
		ItemStack energy_crystal = ItemStackUtil.copyStackWithNewMetadata(IC2Items.getItem("energy_crystal"), OreDictionary.WILDCARD_VALUE);
		ItemStack lapotron_crystal = ItemStackUtil.copyStackWithNewMetadata(IC2Items.getItem("lapotron_crystal"), OreDictionary.WILDCARD_VALUE);
		ItemStack charging_lapotron_crystal = ItemStackUtil.copyStackWithNewMetadata(IC2Items.getItem("charging_lapotron_crystal"), OreDictionary.WILDCARD_VALUE);
		
		// Items
		if (CommonConfig.recipes.crafting.enableExtremeCondensatorReflector) {
			Recipes.advRecipes.addRecipe(new ItemStack(WTFIC2AddonItems.advanced_condensator_reflector), new Object[] { "ABA", "BXB", "ABA", 'A', IC2Items.getItem("lzh_condensator"), 'B', IC2Items.getItem("iridium_reflector"), 'X', WTFIC2AddonItems.dense_iridium_reinforce_plate });
		}
		
		if (CommonConfig.recipes.crafting.enableDenseIridiumReinforcePlate) {
			Recipes.advRecipes.addRecipe(new ItemStack(WTFIC2AddonItems.dense_iridium_reinforce_plate), new Object[] { "AAA", "AAA", "AAA", 'A', IC2Items.getItem("crafting", "iridium") });
		}
		
		// Solarpanel
		if (CommonConfig.recipes.crafting.enableLowSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_low), new Object[] { "XXX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "circuit"), '*', IC2Items.getItem("te", "solar_generator"), 'X', Blocks.GLASS });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateLowSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_intermediatelow), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_low), 'X', Blocks.GLASS, 'S', re_battery.copy() });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateMediumSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_intermediatemedium), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_intermediatelow), 'X', Blocks.GLASS, 'S', re_battery.copy() });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateHighSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_intermediatehigh), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_intermediatemedium), 'X', Blocks.GLASS, 'S', advanced_re_battery.copy() });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedLowSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_advancedlow), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_intermediatehigh), 'X', Blocks.GLASS, 'S', energy_crystal.copy() });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedMediumSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_advancedmedium), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_advancedlow), 'X', Blocks.GLASS, 'S', energy_crystal.copy() });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedHighSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_advancedhigh), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_advancedmedium), 'X', Blocks.GLASS, 'S', lapotron_crystal.copy() });
		}
		
		if (CommonConfig.recipes.crafting.enableSuperiorSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_superior), new Object[] { "XSX", "E*E", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_advancedhigh), 'X', IC2Items.getItem("glass", "reinforced"), 'S', lapotron_crystal.copy(), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateWTFSolarpanel) {
			UuIndex.instance.add(teBlock.getItemStack(solar_panel_intermediatewtf), CommonConfig.recipes.uumatterindex.intermediateWTFSolarPanel);
			
			ItemStack output = CrystalMemoryUtil.create(teBlock.getItemStack(solar_panel_intermediatewtf));
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "***", "*C*", "*E*", '*', teBlock.getItemStack(solar_panel_superior), 'C', IC2Items.getItem("crafting", "raw_crystal_memory"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedWTFSolarpanel) {
			UuIndex.instance.add(teBlock.getItemStack(solar_panel_advancedwtf), CommonConfig.recipes.uumatterindex.advancedWTFSolarPanel);
			
			ItemStack output = CrystalMemoryUtil.create(teBlock.getItemStack(solar_panel_advancedwtf));
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "*N*", "*C*", "E*E", '*', teBlock.getItemStack(solar_panel_intermediatewtf), 'C', charging_lapotron_crystal.copy(), 'N', IC2Items.getItem("nuclear", "rtg_pellet"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableExtremeWTFSolarpanel) {
			UuIndex.instance.add(teBlock.getItemStack(solar_panel_extremewtf), CommonConfig.recipes.uumatterindex.extremeWTFSolarPanel);
			
			ItemStack output = CrystalMemoryUtil.create(teBlock.getItemStack(solar_panel_extremewtf));
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "E*E", "*C*", "E*E", '*', teBlock.getItemStack(solar_panel_advancedwtf), 'C', charging_lapotron_crystal.copy(), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		// MFSU
		if (CommonConfig.recipes.crafting.enableCompressedMFSU) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_compressed), new Object[] { "***", "***", "***", '*', IC2Items.getItem("te", "mfsu") });
		}
		
		if (CommonConfig.recipes.crafting.enableDoubleCompressedMFSU) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_doublecompressed), new Object[] { "***", "***", "***", '*', teBlock.getItemStack(mfsu_compressed) });
		}
		
		if (CommonConfig.recipes.crafting.enableTrippleCompressedMFSU) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_triplecompressed), new Object[] { "***", "***", "***", '*', teBlock.getItemStack(mfsu_doublecompressed) });
		}
		
		if (CommonConfig.recipes.crafting.enableQuadrupleCompressedMFSU) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_quadruplecompressed), new Object[] { "***", "***", "***", '*', teBlock.getItemStack(mfsu_triplecompressed) });
		}
		
		if (CommonConfig.recipes.crafting.enableExtremeMFSU) {
			UuIndex.instance.add(teBlock.getItemStack(mfsu_extreme), CommonConfig.recipes.uumatterindex.extremeMFSU);
			
			ItemStack output = CrystalMemoryUtil.create(teBlock.getItemStack(mfsu_extreme));
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "***", "*C*", "*E*", '*', teBlock.getItemStack(mfsu_quadruplecompressed), 'C', IC2Items.getItem("crafting", "raw_crystal_memory"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableConvertableMFSU) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_convertable), new Object[] { "*#*", "#C#", "*#*", '*', teBlock.getItemStack(mfsu_doublecompressed), '#', lapotron_crystal.copy(), 'C', IC2Items.getItem("crafting", "raw_crystal_memory") });
		}
		
	}
	
}

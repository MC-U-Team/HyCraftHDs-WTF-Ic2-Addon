package info.u_team.hycrafthds_wtf_ic2_addon.init;

import static info.u_team.hycrafthds_wtf_ic2_addon.init.WTFIC2AddonTes.*;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import ic2.core.block.*;
import ic2.core.util.StackUtil;
import ic2.core.uu.UuIndex;
import info.u_team.hycrafthds_wtf_ic2_addon.config.CommonConfig;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class WTFIC2AddonRecipes {
	
	private static BlockTileEntity teBlock;
	
	public static void init() {
		teBlock = TeBlockRegistry.get(IDENTITY);
		
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
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_intermediatelow), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_low), 'X', Blocks.GLASS, 'S', IC2Items.getItem("re_battery") });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateMediumSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_intermediatemedium), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_intermediatelow), 'X', Blocks.GLASS, 'S', IC2Items.getItem("re_battery") });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateHighSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_intermediatehigh), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_intermediatemedium), 'X', Blocks.GLASS, 'S', IC2Items.getItem("advanced_re_battery") });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedLowSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_advancedlow), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_intermediatehigh), 'X', Blocks.GLASS, 'S', IC2Items.getItem("energy_crystal") });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedMediumSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_advancedmedium), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_advancedlow), 'X', Blocks.GLASS, 'S', IC2Items.getItem("energy_crystal") });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedHighSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_advancedhigh), new Object[] { "XSX", "X*X", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_advancedmedium), 'X', Blocks.GLASS, 'S', IC2Items.getItem("lapotron_crystal") });
		}
		
		if (CommonConfig.recipes.crafting.enableSuperiorSolarpanel) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(solar_panel_superior), new Object[] { "XSX", "E*E", "#*#", '#', IC2Items.getItem("crafting", "advanced_circuit"), '*', teBlock.getItemStack(solar_panel_advancedhigh), 'X', IC2Items.getItem("glass", "reinforced"), 'S', IC2Items.getItem("lapotron_crystal"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableIntermediateWTFSolarpanel) {
			UuIndex.instance.add(teBlock.getItemStack(solar_panel_intermediatewtf), CommonConfig.recipes.uumatterindex.intermediateWTFSolarPanel);
			
			ItemStack output = IC2Items.getItem("crystal_memory");
			NBTTagCompound nbt = StackUtil.getOrCreateNbtData(output);
			NBTTagCompound contentTag = new NBTTagCompound();
			teBlock.getItemStack(solar_panel_intermediatewtf).writeToNBT(contentTag);
			nbt.setTag("Pattern", contentTag);
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "***", "*C*", "*E*", '*', teBlock.getItemStack(solar_panel_superior), 'C', IC2Items.getItem("crafting", "raw_crystal_memory"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableAdvancedWTFSolarpanel) {
			UuIndex.instance.add(teBlock.getItemStack(solar_panel_advancedwtf), CommonConfig.recipes.uumatterindex.advancedWTFSolarPanel);
			
			ItemStack output = IC2Items.getItem("crystal_memory");
			NBTTagCompound nbt = StackUtil.getOrCreateNbtData(output);
			NBTTagCompound contentTag = new NBTTagCompound();
			teBlock.getItemStack(solar_panel_advancedwtf).writeToNBT(contentTag);
			nbt.setTag("Pattern", contentTag);
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "*N*", "*C*", "E*E", '*', teBlock.getItemStack(solar_panel_intermediatewtf), 'C', IC2Items.getItem("charging_lapotron_crystal"), 'N', IC2Items.getItem("nuclear", "rtg_pellet"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableExtremeWTFSolarpanel) {
			UuIndex.instance.add(teBlock.getItemStack(solar_panel_extremewtf), CommonConfig.recipes.uumatterindex.extremeWTFSolarPanel);
			
			ItemStack output = IC2Items.getItem("crystal_memory");
			NBTTagCompound nbt = StackUtil.getOrCreateNbtData(output);
			NBTTagCompound contentTag = new NBTTagCompound();
			teBlock.getItemStack(solar_panel_extremewtf).writeToNBT(contentTag);
			nbt.setTag("Pattern", contentTag);
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "E*E", "*C*", "E*E", '*', teBlock.getItemStack(solar_panel_advancedwtf), 'C', IC2Items.getItem("charging_lapotron_crystal"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
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
			
			ItemStack output = IC2Items.getItem("crystal_memory");
			NBTTagCompound nbt = StackUtil.getOrCreateNbtData(output);
			NBTTagCompound contentTag = new NBTTagCompound();
			teBlock.getItemStack(mfsu_extreme).writeToNBT(contentTag);
			nbt.setTag("Pattern", contentTag);
			
			Recipes.advRecipes.addRecipe(output, new Object[] { "***", "*C*", "*E*", '*', teBlock.getItemStack(mfsu_quadruplecompressed), 'C', IC2Items.getItem("crafting", "raw_crystal_memory"), 'E', WTFIC2AddonItems.advanced_condensator_reflector });
		}
		
		if (CommonConfig.recipes.crafting.enableConvertableMFSU) {
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_convertable), new Object[] { "*#*", "#C#", "*#*", '*', teBlock.getItemStack(mfsu_doublecompressed), '#', IC2Items.getItem("lapotron_crystal"), 'C', IC2Items.getItem("crafting", "raw_crystal_memory") });
		}
		
	}
	
}

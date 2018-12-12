package info.u_team.hycrafthds_wtf_ic2_addon.init;

import static info.u_team.hycrafthds_wtf_ic2_addon.init.WTFIC2AddonTes.*;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import ic2.core.block.*;
import ic2.core.uu.UuIndex;
import info.u_team.hycrafthds_wtf_ic2_addon.config.CommonConfig;

public class WTFIC2AddonRecipes {
	
	private static BlockTileEntity teBlock;
	
	public static void init() {
		teBlock = TeBlockRegistry.get(IDENTITY);
		
		// MFSU
		if (CommonConfig.recipes.crafting.enableCompressedMFSU)
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_compressed), new Object[] { "***", "***", "***", '*', IC2Items.getItem("te", "mfsu") });
		
		if (CommonConfig.recipes.crafting.enableDoubleCompressedMFSU)
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_doublecompressed), new Object[] { "***", "***", "***", '*', teBlock.getItemStack(mfsu_compressed) });
		
		if (CommonConfig.recipes.crafting.enableTrippleCompressedMFSU)
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_triplecompressed), new Object[] { "***", "***", "***", '*', teBlock.getItemStack(mfsu_doublecompressed) });
		
		if (CommonConfig.recipes.crafting.enableQuadrupleCompressedMFSU)
			Recipes.advRecipes.addRecipe(teBlock.getItemStack(mfsu_quadruplecompressed), new Object[] { "***", "***", "***", '*', teBlock.getItemStack(mfsu_triplecompressed) });
		
		
		
//		UuIndex.instance.add(stack, value);
		
	}
	
}

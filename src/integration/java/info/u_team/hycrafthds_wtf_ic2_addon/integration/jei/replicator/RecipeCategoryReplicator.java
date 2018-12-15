package info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.replicator;

import ic2.core.init.Localization;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.JeiPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;

public class RecipeCategoryReplicator implements IRecipeCategory<RecipeWrapperReplicator> {
	
	private IDrawable background;
	
	private IGuiHelper helper;
	
	public RecipeCategoryReplicator(IGuiHelper guiHelper) {
		this.helper = guiHelper;
		this.background = helper.drawableBuilder(new ResourceLocation(WTFIC2AddonConstants.MODID, "textures/jei/replicator.png"), 0, 0, 120, 40).setTextureSize(120, 40).build();
	}
	
	@Override
	public String getUid() {
		return JeiPlugin.replicatorID;
	}
	
	@Override
	public String getTitle() {
		return Localization.translate("ic2.te.replicator");
	}
	
	@Override
	public String getModName() {
		return WTFIC2AddonConstants.NAME;
	}
	
	@Override
	public IDrawable getBackground() {
		return background;
	}
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, RecipeWrapperReplicator recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItems = recipeLayout.getItemStacks();
		guiItems.init(0, true, 11, 11);
		guiItems.init(1, false, 91, 11);
		guiItems.set(ingredients);
		
		IGuiFluidStackGroup guiFluids = recipeLayout.getFluidStacks();
		guiFluids.init(0, true, 35, 12);
		guiFluids.set(ingredients);
		
	}
	
}

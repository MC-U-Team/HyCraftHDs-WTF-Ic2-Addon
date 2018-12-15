package info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.scanner;

import ic2.core.init.Localization;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.JeiPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;

public class RecipeCategoryScanner implements IRecipeCategory<RecipeWrapperScanner> {
	
	private IDrawable background;
	
	private IGuiHelper helper;
	
	public RecipeCategoryScanner(IGuiHelper guiHelper) {
		this.helper = guiHelper;
		this.background = helper.drawableBuilder(new ResourceLocation(WTFIC2AddonConstants.MODID, "textures/jei/scanner.png"), 0, 0, 120, 40).setTextureSize(120, 40).build();
	}
	
	@Override
	public String getUid() {
		return JeiPlugin.scannerID;
	}
	
	@Override
	public String getTitle() {
		return Localization.translate("ic2.te.scanner");
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
	public void setRecipe(IRecipeLayout recipeLayout, RecipeWrapperScanner recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItems = recipeLayout.getItemStacks();
		guiItems.init(0, true, 11, 11);
		guiItems.init(1, false, 91, 11);
		guiItems.set(ingredients);
	}
	
}

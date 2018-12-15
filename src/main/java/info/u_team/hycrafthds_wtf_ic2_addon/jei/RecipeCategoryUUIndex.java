package info.u_team.hycrafthds_wtf_ic2_addon.jei;

import ic2.core.IC2;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;

public class RecipeCategoryUUIndex implements IRecipeCategory<RecipeWrapperUUIndex> {
	
	private IDrawable background;
	private ResourceLocation TEXTURE = new ResourceLocation("textures/gui/furnace.png");
	
	public RecipeCategoryUUIndex(IGuiHelper guiHelper) {
		this.background = guiHelper.drawableBuilder(TEXTURE, 26, 17, 116, 30).build();
	}
	
	@Override
	public String getUid() {
		return JeiPlugin.uuIndexID;
	}
	
	@Override
	public String getTitle() {
		return "ROFL";
	}
	
	@Override
	public String getModName() {
		return IC2.MODID;
	}
	
	@Override
	public IDrawable getBackground() {
		return background;
	}
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, RecipeWrapperUUIndex recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();
		guiStacks.init(0, true, 3, 5);
		guiStacks.set(ingredients);
		
	}
	
}

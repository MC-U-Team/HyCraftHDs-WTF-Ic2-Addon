package info.u_team.hycrafthds_wtf_ic2_addon.jei;

import java.util.Map.Entry;

import mezz.jei.api.ingredients.*;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class RecipeWrapperUUIndex implements IRecipeWrapper {
	
	private ItemStack stack;
	private double value;
	
	public RecipeWrapperUUIndex(Entry<ItemStack, Double> entry) {
		this.stack = entry.getKey();
		this.value = entry.getValue();
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(VanillaTypes.ITEM, stack);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		String text = "" + value + " Mico Buckets UU Matter";
		
		int width = minecraft.fontRenderer.getStringWidth(text);
		int x = recipeWidth - 2 - width;
		int y = 27;
		
		minecraft.fontRenderer.drawString(text, x, y, 0xFF5502);
	}
	
}

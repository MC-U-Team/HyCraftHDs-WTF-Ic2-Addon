package info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.scanner;

import java.util.*;
import java.util.Map.Entry;

import ic2.core.init.Localization;
import info.u_team.hycrafthds_wtf_ic2_addon.util.CrystalMemoryUtil;
import mezz.jei.api.ingredients.*;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class RecipeWrapperScanner implements IRecipeWrapper {
	
	private ItemStack stack;
	
	public RecipeWrapperScanner(Entry<ItemStack, Double> entry) {
		stack = entry.getKey();
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		
		ItemStack outputStack = CrystalMemoryUtil.create(stack);
		
		ingredients.setInput(VanillaTypes.ITEM, stack.copy());
		ingredients.setOutput(VanillaTypes.ITEM, outputStack);
	}
	
	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		List<String> list = new ArrayList<>();
		if (mouseX >= 48 && mouseY >= 12 && mouseX <= 70 && mouseY <= 27) {
			list.add(Localization.translate("ic2.Scanner.gui.info1"));
		}
		return list;
	}
	
}

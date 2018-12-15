package info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.replicator;

import java.util.*;
import java.util.Map.Entry;

import ic2.core.ref.FluidName;
import ic2.core.util.Util;
import info.u_team.hycrafthds_wtf_ic2_addon.util.CrystalMemoryUtil;
import mezz.jei.api.ingredients.*;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeWrapperReplicator implements IRecipeWrapper {
	
	private ItemStack stack;
	private double value;
	
	public RecipeWrapperReplicator(Entry<ItemStack, Double> entry) {
		stack = entry.getKey();
		value = entry.getValue();
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		
		ItemStack inputStack = CrystalMemoryUtil.create(stack);
		
		FluidStack inputFluid = new FluidStack(FluidName.uu_matter.getInstance(), (int) (value * 1e-4));
		
		ingredients.setInput(VanillaTypes.ITEM, inputStack);
		ingredients.setInput(VanillaTypes.FLUID, inputFluid);
		ingredients.setOutput(VanillaTypes.ITEM, stack.copy());
	}
	
	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		List<String> list = new ArrayList<>();
		if (mouseX >= 61 && mouseY >= 12 && mouseX <= 83 && mouseY <= 27) {
			list.add(Util.toSiString(value * 1e-5, 4) + "B");
		}
		return list;
	}
	
}

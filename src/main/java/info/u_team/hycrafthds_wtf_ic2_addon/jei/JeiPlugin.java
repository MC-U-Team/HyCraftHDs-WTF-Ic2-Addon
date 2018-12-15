package info.u_team.hycrafthds_wtf_ic2_addon.jei;

import java.util.ArrayList;
import java.util.Map.Entry;

import ic2.core.uu.UuGraph;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import mezz.jei.api.*;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JeiPlugin implements IModPlugin {
	
	public static final String uuIndexID = WTFIC2AddonConstants.MODID + ".uuIndex";
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
		registry.addRecipeCategories(new RecipeCategoryUUIndex(guiHelper));
	}
	
	@Override
	public void register(IModRegistry registry) {
		registry.handleRecipes(Entry.class, RecipeWrapperUUIndex::new, uuIndexID);
		ArrayList<Entry<ItemStack, Double>> list = new ArrayList<>();
		UuGraph.iterator().forEachRemaining(entry -> list.add(entry));
		registry.addRecipes(list, uuIndexID);
	}
}

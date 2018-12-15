package info.u_team.hycrafthds_wtf_ic2_addon.integration.jei;

import java.util.ArrayList;
import java.util.Map.Entry;

import ic2.api.item.IC2Items;
import ic2.core.uu.UuGraph;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.replicator.*;
import info.u_team.hycrafthds_wtf_ic2_addon.integration.jei.scanner.*;
import mezz.jei.api.*;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

@JEIPlugin
public class JeiPlugin implements IModPlugin {
	
	public static final String replicatorID = WTFIC2AddonConstants.MODID + ".replicator";
	public static final String scannerID = WTFIC2AddonConstants.MODID + ".scanner";
	
	@Override
	public void registerItemSubtypes(ISubtypeRegistry registry) {
		registry.registerSubtypeInterpreter(IC2Items.getItem("crystal_memory").getItem(), (stack) -> {
			NBTTagCompound compound = stack.getSubCompound("Pattern");
			return compound == null ? "" : compound.toString();
		});
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
		registry.addRecipeCategories(new RecipeCategoryReplicator(guiHelper));
		registry.addRecipeCategories(new RecipeCategoryScanner(guiHelper));
	}
	
	@Override
	public void register(IModRegistry registry) {
		
		ArrayList<Entry<ItemStack, Double>> uuIndex = getUUIndex();
		
		registry.handleRecipes(Entry.class, RecipeWrapperReplicator::new, replicatorID);
		registry.addRecipes(uuIndex, replicatorID);
		registry.addRecipeCatalyst(IC2Items.getItem("te", "replicator"), replicatorID);
		
		
		registry.handleRecipes(Entry.class, RecipeWrapperScanner::new, scannerID);
		registry.addRecipes(uuIndex, scannerID);
		registry.addRecipeCatalyst(IC2Items.getItem("te", "scanner"), scannerID);
	}
	
	private ArrayList<Entry<ItemStack, Double>> getUUIndex() {
		ArrayList<Entry<ItemStack, Double>> list = new ArrayList<>();
		Item item = IC2Items.getItem("crystal_memory").getItem();
		UuGraph.iterator().forEachRemaining(entry -> {
			if (entry.getValue() != Double.POSITIVE_INFINITY && !item.equals(entry.getKey().getItem())) {
				list.add(entry);
			}
		});
		return list;
	}
}

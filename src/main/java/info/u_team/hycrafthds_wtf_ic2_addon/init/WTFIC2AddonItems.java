package info.u_team.hycrafthds_wtf_ic2_addon.init;

import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.item.*;
import info.u_team.u_team_core.registry.ItemRegistry;
import info.u_team.u_team_core.util.RegistryUtil;
import net.minecraft.item.Item;

public class WTFIC2AddonItems {
	
	public static Item advanced_condensator_reflector = new ItemAdvancedCondensatorReflector("advanced_condensator_reflector");
	
	public static Item dense_iridium_reinforce_plate = new ItemDenseIridiumReinforcedPlate("dense_iridium_reinforce_plate");
	
	public static void preinit() {
		ItemRegistry.register(WTFIC2AddonConstants.MODID, RegistryUtil.getRegistryEntries(Item.class, WTFIC2AddonItems.class));
	}
	
}

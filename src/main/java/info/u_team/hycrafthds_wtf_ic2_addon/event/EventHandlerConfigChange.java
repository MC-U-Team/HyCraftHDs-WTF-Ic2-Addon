package info.u_team.hycrafthds_wtf_ic2_addon.event;

import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerConfigChange {
	
	@SubscribeEvent
	public static void on(OnConfigChangedEvent event) {
		if (event.getModID().equals(WTFIC2AddonConstants.MODID)) {
			ConfigManager.sync(WTFIC2AddonConstants.MODID, Type.INSTANCE);
		}
	}
}

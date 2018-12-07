package info.u_team.hycrafthds_wtf_ic2_addon.config;

import static info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants.MODID;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;

@Config(modid = MODID, category = "")
public class CommonConfig {
	
	@RequiresMcRestart
	public static SolarPanel solarpanel = new SolarPanel();
	
	public static class SolarPanel {
		
		@Name("normal")
		@Comment("Normal Solarpanel")
		public ConfigEntrySolarPanel normal = new ConfigEntrySolarPanel(16, 8, 2, 32, 10000);
	}
	
}

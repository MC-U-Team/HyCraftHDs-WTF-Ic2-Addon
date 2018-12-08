package info.u_team.hycrafthds_wtf_ic2_addon.config;

import static info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants.MODID;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;

@Config(modid = MODID, category = "")
public class CommonConfig {
	
	@RequiresMcRestart
	public static SolarPanel solarpanel = new SolarPanel();
	
	public static class SolarPanel {
		
		public ConfigEntrySolarPanel low = new ConfigEntrySolarPanel(16, 8, 2, 32, 1e4);
		
		public ConfigEntrySolarPanel intermediatelow = new ConfigEntrySolarPanel(32, 16, 2, 32, 5e4);
		public ConfigEntrySolarPanel intermediatemedium = new ConfigEntrySolarPanel(64, 32, 2, 32, 1e5);
		public ConfigEntrySolarPanel intermediatehigh = new ConfigEntrySolarPanel(128, 64, 2, 32, 5e5);
		
		public ConfigEntrySolarPanel advancedlow = new ConfigEntrySolarPanel(256, 128, 2, 32, 1e6);
		public ConfigEntrySolarPanel advancedmedium = new ConfigEntrySolarPanel(512, 256, 2, 32, 5e6);
		public ConfigEntrySolarPanel advancedhigh = new ConfigEntrySolarPanel(1024, 512, 2, 32, 1e7);
		
		public ConfigEntrySolarPanel superior = new ConfigEntrySolarPanel(2048, 1024, 2, 32, 5e7);
		
		public ConfigEntrySolarPanel intermediatewtf = new ConfigEntrySolarPanel(16384, 8192, 2, 32, 1e9);
		public ConfigEntrySolarPanel advancedwtf = new ConfigEntrySolarPanel(131072, 65536, 2, 32, 1e10);
		public ConfigEntrySolarPanel extremewtf = new ConfigEntrySolarPanel(1048576, 524288, 2, 32, 1e11);
		
	}
	
}

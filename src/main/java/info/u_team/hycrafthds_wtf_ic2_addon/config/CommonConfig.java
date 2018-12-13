package info.u_team.hycrafthds_wtf_ic2_addon.config;

import static info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants.MODID;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;

@Config(modid = MODID, category = "")
public class CommonConfig {
	
	@RequiresMcRestart
	@Comment("Solar panel config")
	public static SolarPanel solarpanel = new SolarPanel();
	
	@RequiresMcRestart
	@Comment("Energy storage config")
	public static EnergyStorage energystorage = new EnergyStorage();
	
	@RequiresMcRestart
	@Comment("Enable and disable recipes")
	public static Recipes recipes = new Recipes();
	
	public static class SolarPanel {
		
		public ConfigEntrySolarPanel low = new ConfigEntrySolarPanel(16, 8, 1, 32, 1e4);
		
		public ConfigEntrySolarPanel intermediatelow = new ConfigEntrySolarPanel(32, 16, 1, 64, 5e4);
		public ConfigEntrySolarPanel intermediatemedium = new ConfigEntrySolarPanel(64, 32, 2, 128, 1e5);
		public ConfigEntrySolarPanel intermediatehigh = new ConfigEntrySolarPanel(128, 64, 2, 256, 5e5);
		
		public ConfigEntrySolarPanel advancedlow = new ConfigEntrySolarPanel(256, 128, 3, 512, 1e6);
		public ConfigEntrySolarPanel advancedmedium = new ConfigEntrySolarPanel(512, 256, 3, 1_024, 5e6);
		public ConfigEntrySolarPanel advancedhigh = new ConfigEntrySolarPanel(1_024, 512, 4, 2_048, 1e7);
		
		public ConfigEntrySolarPanel superior = new ConfigEntrySolarPanel(2_048, 1_024, 4, 4_096, 5e7);
		
		public ConfigEntrySolarPanel intermediatewtf = new ConfigEntrySolarPanel(16_384, 8192, 5, 32_768, 1e9);
		public ConfigEntrySolarPanel advancedwtf = new ConfigEntrySolarPanel(131_072, 65_536, 5, 262_144, 1e10);
		public ConfigEntrySolarPanel extremewtf = new ConfigEntrySolarPanel(1_048_576, 524_288, 5, 2_097_152, 1e11);
		
	}
	
	public static class EnergyStorage {
		
		public ConfigEntryEnergyStorage compressedmfsu = new ConfigEntryEnergyStorage(36e7, 18_432, 4);
		public ConfigEntryEnergyStorage doublecompressedmfsu = new ConfigEntryEnergyStorage(324e7, 165_888, 4);
		public ConfigEntryEnergyStorage triplecompressedmfsu = new ConfigEntryEnergyStorage(2916e7, 1_492_992, 4);
		public ConfigEntryEnergyStorage quadruplecompressedmfsu = new ConfigEntryEnergyStorage(26244e7, 13_436_928, 4);
		
		public ConfigEntryEnergyStorage extrememfsu = new ConfigEntryEnergyStorage(Long.MAX_VALUE, 1e12, 5);
		
		public ConfigEntryEnergyStorage convertablemfsu = new ConfigEntryEnergyStorage(1e8, 1e7, 1);
	}
	
	public static class Recipes {
		
		public Crafting crafting = new Crafting();
		
		public UUMatterIndex uumatterindex = new UUMatterIndex();
		
		public class Crafting {
			
			public boolean enableExtremeCondensatorReflector = true;
			public boolean enableDenseIridiumReinforcePlate = true;
			
			public boolean enableLowSolarpanel = true;
			
			public boolean enableIntermediateLowSolarpanel = true;
			public boolean enableIntermediateMediumSolarpanel = true;
			public boolean enableIntermediateHighSolarpanel = true;
			
			public boolean enableAdvancedLowSolarpanel = true;
			public boolean enableAdvancedMediumSolarpanel = true;
			public boolean enableAdvancedHighSolarpanel = true;
			
			public boolean enableSuperiorSolarpanel = true;
			
			public boolean enableIntermediateWTFSolarpanel = true;
			public boolean enableAdvancedWTFSolarpanel = true;
			public boolean enableExtremeWTFSolarpanel = true;
			
			public boolean enableCompressedMFSU = true;
			public boolean enableDoubleCompressedMFSU = true;
			public boolean enableTrippleCompressedMFSU = true;
			public boolean enableQuadrupleCompressedMFSU = true;
			
			public boolean enableExtremeMFSU = true;
			
			public boolean enableConvertableMFSU = true;
		}
		
		public class UUMatterIndex {
			
			public double extremeMFSU = 500e5;
			public double intermediateWTFSolarPanel = 10e5;
			public double advancedWTFSolarPanel = 100e5;
			public double extremeWTFSolarPanel = 500e5;
		}
	}
	
}

package info.u_team.hycrafthds_wtf_ic2_addon.config;

import net.minecraftforge.common.config.Config.*;

public class ConfigEntryEnergyStorage {
	
	@Name("Energy Capacity")
	public double capacity;
	
	@Name("Energy Output")
	public double output;
	
	@Name("Energy Tier")
	public int outputTier;
	
	public ConfigEntryEnergyStorage(double capacity, double output, int outputTier) {
		this.capacity = capacity;
		this.output = output;
		this.outputTier = outputTier;
	}
	
}

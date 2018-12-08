package info.u_team.hycrafthds_wtf_ic2_addon.config;

import net.minecraftforge.common.config.Config.*;

public class ConfigEntrySolarPanel {
	
	@Name("Generation Day")
	public int generateDay;
	
	@Name("Generation Night")
	public int generateNight;
	
	@Name("Energy Tier")
	public int tier;
	
	@Name("Energy Output")
	public int output;
	
	@Name("Energy Capacity")
	public double capacity;
	
	public ConfigEntrySolarPanel(int generateDay, int generateNight, int tier, int output, double capacity) {
		this.generateDay = generateDay;
		this.generateNight = generateNight;
		this.tier = tier;
		this.output = output;
		this.capacity = capacity;
	}
	
}

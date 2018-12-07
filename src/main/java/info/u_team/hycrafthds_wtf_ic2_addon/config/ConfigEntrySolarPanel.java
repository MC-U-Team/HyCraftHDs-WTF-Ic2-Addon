package info.u_team.hycrafthds_wtf_ic2_addon.config;

import net.minecraftforge.common.config.Config.*;

public class ConfigEntrySolarPanel {
	
	@Comment("How much the solarpanel should generate when its day")
	@Name("Generate Day")
	public int generateDay;
	
	@Comment("How much the solarpanel should generate when its night")
	@Name("Generate Night")
	public int generateNight;
	
	@Comment("The energy tier")
	@Name("Tier")
	public int tier;
	
	@Comment("How much energy can be extracted per tick")
	@Name("Output Energy")
	public int output;
	
	@Comment("How much energy this solarpanel can store")
	@Name("Capacity")
	public double capacity;
	
	public ConfigEntrySolarPanel(int generateDay, int generateNight, int tier, int output, int capacity) {
		this.generateDay = generateDay;
		this.generateNight = generateNight;
		this.tier = tier;
		this.output = output;
		this.capacity = capacity;
	}
	
}

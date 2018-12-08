package info.u_team.hycrafthds_wtf_ic2_addon.init;

import ic2.core.gui.Gauge.*;
import ic2.core.gui.Gauge.GaugePropertyBuilder.GaugeOrientation;

public class WTFIC2AddonGauges {
	
	public static void init() {
		GaugeStyle.addStyle("wtf_solarpanel_progress", () -> {
			return new GaugePropertyBuilder(132, 43, 24, 9, GaugeOrientation.Right).withBackground(-4, -11, 32, 32, 128, 0).build();
		});
	}
	
}

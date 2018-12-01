package info.u_team.hycrafthds_wtf_ic2_addon;

import org.apache.logging.log4j.*;

public class WTFIC2AddonConstants {
	
	public static final String MODID = "wtfic2addon";
	public static final String NAME = "HyCraftHDs WTF Ic2 Addon";
	public static final String VERSION = "${version}";
	public static final String MCVERSION = "${mcversion}";
	public static final String DEPENDENCIES = "required:forge@[14.23.4.2705,);required-after:uteamcore@[2.0.0.81,);required-after:IC2@[2.8.101-ex112,)";
	public static final String UPDATEURL = "https://api.u-team.info/update/wtfic2addon.json";
	
	public static final String COMMONPROXY = "info.u_team.hycrafthds_wtf_ic2_addon.proxy.CommonProxy";
	public static final String CLIENTPROXY = "info.u_team.hycrafthds_wtf_ic2_addon.proxy.ClientProxy";
	
	public static final Logger LOGGER = LogManager.getLogger(NAME);
	
	private WTFIC2AddonConstants() {
	}
	
}

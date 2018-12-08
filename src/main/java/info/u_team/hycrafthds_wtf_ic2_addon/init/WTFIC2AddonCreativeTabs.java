package info.u_team.hycrafthds_wtf_ic2_addon.init;

import ic2.core.block.*;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.u_team_core.creativetab.UCreativeTab;

public class WTFIC2AddonCreativeTabs {
	
	public static final UCreativeTab tab = new UCreativeTab(WTFIC2AddonConstants.MODID, "tab");
	
	public static void init() {
		BlockTileEntity block = TeBlockRegistry.get(WTFIC2AddonTes.IDENTITY);
		tab.setIcon(block);
	}
	
}

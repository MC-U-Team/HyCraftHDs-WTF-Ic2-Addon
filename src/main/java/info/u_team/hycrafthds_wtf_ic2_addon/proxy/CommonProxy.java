package info.u_team.hycrafthds_wtf_ic2_addon.proxy;

import info.u_team.hycrafthds_wtf_ic2_addon.event.EventHandlerRegisterTeBlock;
import info.u_team.hycrafthds_wtf_ic2_addon.init.*;
import info.u_team.u_team_core.registry.CommonRegistry;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {
	
	public void construct(FMLConstructionEvent event) {
		CommonRegistry.registerEventHandler(EventHandlerRegisterTeBlock.class);
	}
	
	public void preinit(FMLPreInitializationEvent event) {
	}
	
	public void init(FMLInitializationEvent event) {
		WTFIC2AddonTes.buildDummies();
		WTFIC2AddonCreativeTabs.init();
		WTFIC2AddonGauges.init();
	}
	
	public void postinit(FMLPostInitializationEvent event) {
	}
	
}

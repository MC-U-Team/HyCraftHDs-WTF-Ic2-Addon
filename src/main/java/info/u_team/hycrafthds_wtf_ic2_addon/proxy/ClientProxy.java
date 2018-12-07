package info.u_team.hycrafthds_wtf_ic2_addon.proxy;

import info.u_team.hycrafthds_wtf_ic2_addon.event.EventHandlerConfigChange;
import info.u_team.u_team_core.registry.CommonRegistry;
import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void construct(FMLConstructionEvent event) {
		super.construct(event);
	}
	
	@Override
	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		CommonRegistry.registerEventHandler(EventHandlerConfigChange.class);
	}
	
	@Override
	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
	}
	
}

package info.u_team.hycrafthds_wtf_ic2_addon.event;

import ic2.api.event.TeBlockFinalCallEvent;
import ic2.core.block.TeBlockRegistry;
import info.u_team.hycrafthds_wtf_ic2_addon.init.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerRegisterTeBlock {
	
	@SubscribeEvent
	public static void on(TeBlockFinalCallEvent event) {
		TeBlockRegistry.addAll(WTFIC2AddonTes.class, WTFIC2AddonTes.IDENTITY);
		TeBlockRegistry.addCreativeRegisterer((list, tile, itemblock, tab) -> {
			if (tab == WTFIC2AddonCreativeTabs.tab || tab == CreativeTabs.SEARCH) {
				tile.getAllTypes().forEach(type -> {
					if (type.hasItem()) {
						list.add(tile.getItemStack(type));
					}
				});
			}
		}, WTFIC2AddonTes.IDENTITY);
	}
	
}

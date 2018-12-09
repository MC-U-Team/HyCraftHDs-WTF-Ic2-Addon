package info.u_team.hycrafthds_wtf_ic2_addon.event;

import ic2.api.event.TeBlockFinalCallEvent;
import ic2.core.block.TeBlockRegistry;
import ic2.core.block.comp.Energy;
import ic2.core.util.StackUtil;
import info.u_team.hycrafthds_wtf_ic2_addon.init.*;
import info.u_team.hycrafthds_wtf_ic2_addon.tileentity.TileEntityEnergyStorageBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerRegisterTeBlock {
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void on(TeBlockFinalCallEvent event) {
		TeBlockRegistry.addAll(WTFIC2AddonTes.class, WTFIC2AddonTes.IDENTITY);
		TeBlockRegistry.addCreativeRegisterer((list, tile, itemblock, tab) -> {
			if (tab == WTFIC2AddonCreativeTabs.tab || tab == CreativeTabs.SEARCH) {
				tile.getAllTypes().forEach(type -> {
					if (type.hasItem()) {
						list.add(tile.getItemStack(type));
						if (type.getDummyTe() instanceof TileEntityEnergyStorageBase) {
							TileEntityEnergyStorageBase storagetile = (TileEntityEnergyStorageBase) type.getDummyTe();
							ItemStack filled = tile.getItemStack(type);
							StackUtil.getOrCreateNbtData(filled).setDouble("energy", storagetile.getComponent(Energy.class).getCapacity());
							list.add(filled);
						}
					}
				});
			}
		}, WTFIC2AddonTes.IDENTITY);
	}
}

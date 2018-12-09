package info.u_team.hycrafthds_wtf_ic2_addon.tileentity.energystorage;

import java.util.List;

import ic2.core.init.Localization;
import info.u_team.hycrafthds_wtf_ic2_addon.config.CommonConfig;
import info.u_team.hycrafthds_wtf_ic2_addon.tileentity.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;

public class TileEntityEnergyStorageConvertableMFSU extends TileEntityEnergyStorageBase {
	
	public TileEntityEnergyStorageConvertableMFSU() {
		super(CommonConfig.energystorage.convertablemfsu);
	}
	
	@Override
	public void addInformation(ItemStack stack, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(Localization.translate("wtfic2addon:mfsu_convertable.use"));
		super.addInformation(stack, tooltip, advanced);
	}
	
}

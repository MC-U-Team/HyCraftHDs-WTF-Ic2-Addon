package info.u_team.hycrafthds_wtf_ic2_addon.item;

import info.u_team.hycrafthds_wtf_ic2_addon.init.WTFIC2AddonCreativeTabs;
import info.u_team.u_team_core.item.UItem;
import net.minecraft.item.*;

public class ItemDenseIridiumReinforcedPlate extends UItem {
	
	public ItemDenseIridiumReinforcedPlate(String name) {
		super(name, WTFIC2AddonCreativeTabs.tab);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
}

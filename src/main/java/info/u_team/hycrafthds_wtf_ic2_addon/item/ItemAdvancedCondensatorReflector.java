package info.u_team.hycrafthds_wtf_ic2_addon.item;

import info.u_team.hycrafthds_wtf_ic2_addon.init.WTFIC2AddonCreativeTabs;
import info.u_team.u_team_core.item.UItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;

public class ItemAdvancedCondensatorReflector extends UItem {
	
	public ItemAdvancedCondensatorReflector(String name) {
		super(name, WTFIC2AddonCreativeTabs.tab);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
}

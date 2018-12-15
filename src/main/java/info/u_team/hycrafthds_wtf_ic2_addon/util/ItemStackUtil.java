package info.u_team.hycrafthds_wtf_ic2_addon.util;

import net.minecraft.item.ItemStack;

@Deprecated
// TODO in UTeamCore!
public class ItemStackUtil {
	
	// TODO Capabilites and nbt! (Just a very basic things)
	public static ItemStack copyStackWithNewMetadata(ItemStack stack, int metadata) {
		return new ItemStack(stack.getItem(), stack.getCount(), metadata);
	}
	
}

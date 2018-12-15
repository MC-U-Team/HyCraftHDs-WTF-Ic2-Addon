package info.u_team.hycrafthds_wtf_ic2_addon.util;

import ic2.api.item.IC2Items;
import ic2.core.util.StackUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CrystalMemoryUtil {
	
	public static ItemStack create(ItemStack stack) {
		ItemStack crystalStack = IC2Items.getItem("crystal_memory");
		NBTTagCompound nbt = StackUtil.getOrCreateNbtData(crystalStack);
		NBTTagCompound contentTag = new NBTTagCompound();
		stack.writeToNBT(contentTag);
		nbt.setTag("Pattern", contentTag);
		return crystalStack;
	}
	
}

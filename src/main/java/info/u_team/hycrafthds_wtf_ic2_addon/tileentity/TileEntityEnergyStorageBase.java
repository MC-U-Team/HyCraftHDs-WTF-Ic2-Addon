package info.u_team.hycrafthds_wtf_ic2_addon.tileentity;

import java.util.*;

import ic2.api.energy.EnergyNet;
import ic2.api.tile.IEnergyStorage;
import ic2.core.*;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.comp.Energy;
import ic2.core.block.invslot.*;
import ic2.core.block.invslot.InvSlot.*;
import ic2.core.gui.dynamic.*;
import ic2.core.init.*;
import ic2.core.ref.TeBlock.DefaultDrop;
import ic2.core.util.*;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.config.ConfigEntryEnergyStorage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraftforge.fml.relauncher.*;

public class TileEntityEnergyStorageBase extends TileEntityInventory implements IHasGui, IEnergyStorage {
	
	protected static final ResourceLocation GUILOC = new ResourceLocation(WTFIC2AddonConstants.MODID, "guidef/energy_storage.xml");
	
	protected final double output;
	protected final InvSlotCharge chargeSlot;
	protected final InvSlotDischarge dischargeSlot;
	protected final Energy energy;
	
	public TileEntityEnergyStorageBase(ConfigEntryEnergyStorage type) {
		this.output = type.output;
		chargeSlot = new InvSlotCharge(this, 5);
		dischargeSlot = new InvSlotDischarge(this, Access.IO, 5, InvSide.BOTTOM);
		energy = addComponent(new Energy(this, type.capacity, EnumSet.complementOf(EnumSet.of(EnumFacing.DOWN)), EnumSet.of(EnumFacing.DOWN), 5, type.outputTier, false).addManagedSlot(chargeSlot).addManagedSlot(dischargeSlot));
		energy.setMultiSource(true);
		energy.setPacketOutput((int) (output / EnergyNet.instance.getPowerFromTier(type.outputTier)));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		energy.setDirections(EnumSet.complementOf(EnumSet.of(getFacing())), EnumSet.of(getFacing()));
	}
	
	@Override
	public ContainerBase<?> getGuiContainer(EntityPlayer player) {
		try {
			return DynamicContainer.create(this, player, GuiParser.parse(GUILOC, teBlock.getTeClass()));
		} catch (Exception ex) {
			WTFIC2AddonConstants.LOGGER.catching(ex);
		}
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getGui(EntityPlayer player, boolean b) {
		try {
			return DynamicGui.create(this, player, GuiParser.parse(GUILOC, teBlock.getTeClass()));
		} catch (Exception ex) {
			WTFIC2AddonConstants.LOGGER.catching(ex);
		}
		return null;
	}
	
	@Override
	public InvSlot getInvSlot(String name) {
		if ("charge".equals(name)) {
			return chargeSlot;
		} else if ("discharge".equals(name)) {
			return dischargeSlot;
		}
		return super.getInvSlot(name);
	}
	
	@Override
	public void onGuiClosed(EntityPlayer var1) {
	}
	
	@Override
	public void setFacing(EnumFacing facing) {
		super.setFacing(facing);
		energy.setDirections(EnumSet.complementOf(EnumSet.of(getFacing())), EnumSet.of(getFacing()));
	}
	
	protected final void superSetFacing(EnumFacing facing) {
		super.setFacing(facing);
	}
	
	@Override
	public void onPlaced(ItemStack stack, EntityLivingBase placer, EnumFacing facing) {
		super.onPlaced(stack, placer, facing);
		if (!getWorld().isRemote) {
			NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
			energy.addEnergy(nbt.getDouble("energy"));
		}
		
	}
	
	@Override
	protected ItemStack adjustDrop(ItemStack drop, boolean wrench) {
		drop = super.adjustDrop(drop, wrench);
		if (teBlock.getDefaultDrop() == DefaultDrop.Self) {
			double retainedRatio;
			if (wrench) {
				retainedRatio = 1;
			} else {
				retainedRatio = ConfigUtil.getDouble(MainConfig.get(), "balance/energyRetainedInStorageBlockDrops");
			}
			double totalEnergy = energy.getEnergy();
			if (retainedRatio > 0.0D && totalEnergy > 0.0D) {
				NBTTagCompound nbt = StackUtil.getOrCreateNbtData(drop);
				nbt.setDouble("energy", totalEnergy * retainedRatio);
			}
		}
		
		return drop;
	}
	
	@Override
	public int getOutput() {
		return (int) output;
	}
	
	@Override
	public double getOutputEnergyUnitsPerTick() {
		return output;
	}
	
	@Override
	public void setStored(int energy) {
	}
	
	@Override
	public int addEnergy(int amount) {
		energy.addEnergy(amount);
		return amount;
	}
	
	@Override
	public int getStored() {
		return (int) energy.getEnergy();
	}
	
	@Override
	public int getCapacity() {
		return (int) energy.getCapacity();
	}
	
	@Override
	public boolean isTeleporterCompatible(EnumFacing side) {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, tooltip, advanced);
		tooltip.add(String.format("%s %s %s %s %s %s", Localization.translate("ic2.item.tooltip.Output"), (long) output, Localization.translate("ic2.generic.text.EUt"), Localization.translate("ic2.item.tooltip.Capacity"), (long) energy.getCapacity(), Localization.translate("ic2.generic.text.EU")));
		tooltip.add(Localization.translate("ic2.item.tooltip.Store") + " " + (long) StackUtil.getOrCreateNbtData(stack).getDouble("energy") + " " + Localization.translate("ic2.generic.text.EU"));
	}
	
	// gui display methods
	public String getStorageText() {
		return Localization.translate("wtfic2addon:gui.text.storageLong", (long) energy.getEnergy());
	}
	
	public String getCapacityText() {
		return Localization.translate("wtfic2addon:gui.text.capacity", (long) energy.getCapacity());
	}
	
	public String getOutputText() {
		return Localization.translate("wtfic2addon:gui.text.output", output);
	}
}
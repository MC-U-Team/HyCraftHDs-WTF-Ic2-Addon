package info.u_team.hycrafthds_wtf_ic2_addon.tileentity;

import ic2.api.energy.tile.*;
import ic2.core.*;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotCharge;
import ic2.core.gui.dynamic.*;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.*;

public class TileEntitySolarPanelBase extends TileEntityInventory implements IHasGui, IGuiValueProvider, IMultiEnergySource {
	
	public final InvSlotCharge chargeSlot;
	
	public TileEntitySolarPanelBase() {
		chargeSlot = new InvSlotCharge(this, 1);
	}
	
	@Override
	protected void updateEntityServer() {
	}
	
	@Override
	public boolean emitsEnergyTo(IEnergyAcceptor receiver, EnumFacing side) {
		return side != EnumFacing.UP;
	}
	
	@Override
	public double getOfferedEnergy() {
		return 0;
	}
	
	@Override
	public void drawEnergy(double amount) {
		
	}
	
	@Override
	public boolean sendMultipleEnergyPackets() {
		return false;
	}
	
	@Override
	public int getMultipleEnergyPacketAmount() {
		return 0;
	}
	
	@Override
	public int getSourceTier() {
		return 0;
	}
	
	@Override
	public double getGuiValue(String var1) {
		return 0;
	}
	
	// Gui
	
	@Override
	public ContainerBase<?> getGuiContainer(EntityPlayer player) {
		return DynamicContainer.create(this, player, GuiParser.parse(teBlock));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public GuiScreen getGui(EntityPlayer player, boolean b) {
		return DynamicGui.create(this, player, GuiParser.parse(teBlock));
	}
	
	@Override
	public void onGuiClosed(EntityPlayer player) {
	}
	
}

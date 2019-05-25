package info.u_team.hycrafthds_wtf_ic2_addon.tileentity;

import java.util.List;

import ic2.api.energy.EnergyNet;
import ic2.api.energy.event.*;
import ic2.api.energy.tile.*;
import ic2.core.*;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotCharge;
import ic2.core.gui.dynamic.*;
import ic2.core.init.Localization;
import ic2.core.network.GuiSynced;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.config.ConfigEntrySolarPanel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.*;

public class TileEntitySolarPanelBase extends TileEntityInventory implements IHasGui, IGuiValueProvider, IMultiEnergySource {
	
	protected static final ResourceLocation GUILOC = new ResourceLocation(WTFIC2AddonConstants.MODID, "guidef/solar_panel.xml");
	
	protected final ConfigEntrySolarPanel type;
	protected final InvSlotCharge chargeSlot;
	
	private int ticker = 0;
	
	@GuiSynced
	private GenerateState state = GenerateState.NONE;
	
	@GuiSynced
	private double storage;
	
	private int packetAmount;
	
	private boolean addedToEnet;
	
	public TileEntitySolarPanelBase(ConfigEntrySolarPanel type) {
		this.type = type;
		chargeSlot = new InvSlotCharge(this, 1);
		
		packetAmount = (int) (type.output / EnergyNet.instance.getPowerFromTier(type.tier));
	}
	
	@Override
	protected void onLoaded() {
		super.onLoaded();
		if (!addedToEnet && !world.isRemote) {
			MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
			addedToEnet = true;
		}
	}
	
	@Override
	protected void onUnloaded() {
		super.onUnloaded();
		if (addedToEnet && !world.isRemote) {
			MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
			addedToEnet = false;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		storage = compound.getDouble("storage");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setDouble("storage", storage);
		return compound;
	}
	
	@Override
	public double getOfferedEnergy() {
		return type.output > storage ? storage : type.output;
	}
	
	@Override
	public void drawEnergy(double amount) {
		storage -= amount;
	}
	
	@Override
	public int getSourceTier() {
		return type.tier;
	}
	
	@Override
	public boolean emitsEnergyTo(IEnergyAcceptor receiver, EnumFacing side) {
		return side != EnumFacing.UP;
	}
	
	@Override
	public boolean sendMultipleEnergyPackets() {
		return packetAmount > 0;
	}
	
	@Override
	public int getMultipleEnergyPacketAmount() {
		return packetAmount;
	}
	
	@Override
	protected void updateEntityServer() {
		if (ticker >= 20) {
			canGenerate();
			ticker = 0;
		}
		ticker++;
		state.addEnergy(this, type);
		if (storage > 0) {
			drawEnergy(chargeSlot.charge(storage));
		}
	}
	
	private void canGenerate() {
		if (storage >= type.capacity) {
			state = GenerateState.NONE;
		} else {
			if (world.canBlockSeeSky(pos.up())) {
				if (world.isDaytime() && !world.isRainingAt(pos.up())) {
					state = GenerateState.DAY;
				} else {
					state = GenerateState.NIGHT;
				}
			} else {
				state = GenerateState.NONE;
			}
		}
	}
	
	// Gui
	
	@Override
	public double getGuiValue(String name) {
		if ("progress".equals(name)) {
			return storage / type.capacity;
		}
		return 0;
	}
	
	@Override
	public boolean getGuiState(String name) {
		if ("day".equals(name)) {
			return state == GenerateState.DAY;
		} else if ("night".equals(name)) {
			return state == GenerateState.NIGHT;
		} else {
			return super.getGuiState(name);
		}
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
	public void onGuiClosed(EntityPlayer player) {
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, tooltip, advanced);
		tooltip.add(Localization.translate("ic2.item.tooltip.PowerTier", type.tier));
		tooltip.add(String.format("%s %s %s %s %s %s", Localization.translate("wtfic2addon:tooltip.solarpanel.generateDay"), (long) type.generateDay, Localization.translate("ic2.generic.text.EUt"), Localization.translate("wtfic2addon:tooltip.solarpanel.generateNight"), (long) type.generateNight, Localization.translate("ic2.generic.text.EUt")));
	}
	
	// gui display methods
	
	public String getStorageText() {
		return Localization.translate("wtfic2addon:gui.text.storage", (long) storage, (long) type.capacity);
	}
	
	public String getGeneratingText() {
		final int generation;
		switch (state) {
		case DAY:
			generation = type.generateDay;
			break;
		case NIGHT:
			generation = type.generateNight;
			break;
		default:
			generation = 0;
			break;
		}
		return Localization.translate("wtfic2addon:gui.text.generate", generation);
	}
	
	public String getOutputText() {
		return Localization.translate("wtfic2addon:gui.text.output", type.output);
	}
	
	// generation
	
	private enum GenerateState {
		DAY,
		NIGHT,
		NONE;
		
		public void addEnergy(TileEntitySolarPanelBase solarpanel, ConfigEntrySolarPanel type) {
			switch (this) {
			case DAY:
				solarpanel.storage += type.generateDay;
				break;
			case NIGHT:
				solarpanel.storage += type.generateNight;
				break;
			default:
				break;
			}
			if (solarpanel.storage > type.capacity) {
				solarpanel.storage = type.capacity;
			}
		}
	}
}

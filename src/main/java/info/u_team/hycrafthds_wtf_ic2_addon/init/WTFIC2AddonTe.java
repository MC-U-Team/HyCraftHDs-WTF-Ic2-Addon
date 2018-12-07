package info.u_team.hycrafthds_wtf_ic2_addon.init;

import java.util.Set;

import ic2.core.block.*;
import ic2.core.ref.TeBlock.*;
import ic2.core.util.Util;
import info.u_team.hycrafthds_wtf_ic2_addon.WTFIC2AddonConstants;
import info.u_team.hycrafthds_wtf_ic2_addon.tileentity.TileEntitySolarPanelNormal;
import info.u_team.u_team_core.util.CustomResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;

public enum WTFIC2AddonTe implements ITeBlock {
	
	solar_panel(TileEntitySolarPanelNormal.class, 0, true, Util.horizontalFacings, false, HarvestTool.Pickaxe, DefaultDrop.Generator, 5, 10, EnumRarity.COMMON);
	
	public static final ResourceLocation IDENTITY = new ResourceLocation(WTFIC2AddonConstants.MODID, "te");
	
	static {
		for (WTFIC2AddonTe block : values()) {
			TileEntity.register(new CustomResourceLocation(IDENTITY, "_" + block.getName()).toString(), block.getTeClass());
		}
	}
	
	private final Class<? extends TileEntityBlock> teClass;
	private final int itemMeta;
	private final boolean hasActive;
	private final Set<EnumFacing> possibleFacings;
	private final boolean canBeWrenched;
	private final HarvestTool tool;
	private final DefaultDrop drop;
	private final float hardness;
	private final float explosionResistance;
	private final EnumRarity rarity;
	private final Material material;
	private final boolean isTransparent;
	private TileEntityBlock dummyTe;
	private ITePlaceHandler placeHandler;
	
	private WTFIC2AddonTe(Class<? extends TileEntityBlock> teClass, int itemMeta, boolean hasActive, Set<EnumFacing> supportedFacings, boolean allowWrenchRotating, HarvestTool harvestTool, DefaultDrop defaultDrop, float hardness, float explosionResistance, EnumRarity rarity) {
		this(teClass, itemMeta, hasActive, supportedFacings, allowWrenchRotating, harvestTool, defaultDrop, hardness, explosionResistance, rarity, Material.IRON, false);
	}
	
	private WTFIC2AddonTe(Class<? extends TileEntityBlock> teClass, int itemMeta, boolean hasActive, Set<EnumFacing> possibleFacings, boolean canBeWrenched, HarvestTool tool, DefaultDrop drop, float hardness, float explosionResistance, EnumRarity rarity, Material material, boolean isTransparent) {
		this.teClass = teClass;
		this.itemMeta = itemMeta;
		this.hasActive = hasActive;
		this.possibleFacings = possibleFacings;
		this.canBeWrenched = canBeWrenched;
		this.tool = tool;
		this.drop = drop;
		this.hardness = hardness;
		this.explosionResistance = explosionResistance;
		this.rarity = rarity;
		this.material = material;
		this.isTransparent = isTransparent;
	}
	
	@Override
	public boolean hasItem() {
		return teClass != null && itemMeta != -1;
	}
	
	@Override
	public String getName() {
		return name();
	}
	
	@Override
	public ResourceLocation getIdentifier() {
		return IDENTITY;
	}
	
	@Override
	public Class<? extends TileEntityBlock> getTeClass() {
		return teClass;
	}
	
	@Override
	public boolean hasActive() {
		return hasActive;
	}
	
	@Override
	public int getId() {
		return itemMeta;
	}
	
	@Override
	public float getHardness() {
		return hardness;
	}
	
	@Override
	public HarvestTool getHarvestTool() {
		return tool;
	}
	
	@Override
	public DefaultDrop getDefaultDrop() {
		return drop;
	}
	
	@Override
	public float getExplosionResistance() {
		return explosionResistance;
	}
	
	@Override
	public boolean allowWrenchRotating() {
		return canBeWrenched;
	}
	
	@Override
	public Set<EnumFacing> getSupportedFacings() {
		return possibleFacings;
	}
	
	@Override
	public EnumRarity getRarity() {
		return rarity;
	}
	
	@Override
	public Material getMaterial() {
		return material;
	}
	
	@Override
	public boolean isTransparent() {
		return isTransparent;
	}
	
	@Override
	public void setPlaceHandler(ITePlaceHandler handler) {
		this.placeHandler = handler;
	}
	
	@Override
	public ITePlaceHandler getPlaceHandler() {
		return placeHandler;
	}
	
	public static void buildDummies() {
		for (WTFIC2AddonTe block : values()) {
			if (block.teClass != null) {
				try {
					block.dummyTe = block.teClass.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public TileEntityBlock getDummyTe() {
		return dummyTe;
	}
}

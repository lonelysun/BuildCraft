/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */
package buildcraft.energy.statements;

import java.util.Locale;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import buildcraft.api.statements.IStatementContainer;
import buildcraft.api.statements.IStatementParameter;
import buildcraft.api.statements.ITriggerExternal;
import buildcraft.core.lib.engines.TileEngineBase;
import buildcraft.core.lib.engines.TileEngineBase.EnergyStage;
import buildcraft.core.lib.utils.StringUtils;
import buildcraft.core.statements.BCStatement;

public class TriggerEngineHeat extends BCStatement implements ITriggerExternal {

    public EnergyStage stage;

    public TriggerEngineHeat(EnergyStage stage) {
        super("buildcraft:engine.stage." + stage.name().toLowerCase(Locale.ENGLISH), "buildcraft.engine.stage."
            + stage.name().toLowerCase(Locale.ENGLISH));

        this.stage = stage;
    }

    @Override
    public String getDescription() {
        return StringUtils.localize("gate.trigger.engine." + stage.name().toLowerCase(Locale.ENGLISH));
    }

    @Override
    public boolean isTriggerActive(TileEntity tile, EnumFacing side, IStatementContainer container, IStatementParameter[] parameters) {
        if (tile instanceof TileEngineBase) {
            TileEngineBase engine = (TileEngineBase) tile;

            return engine.getEnergyStage() == stage;
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureAtlasSpriteRegister iconRegister) {
        icon = iconRegister.registerIcon("buildcraftenergy:triggers/trigger_engineheat_" + stage.name().toLowerCase(Locale.ENGLISH));
    }
}

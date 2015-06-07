/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */
package buildcraft.transport.gates;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

import buildcraft.api.gates.IGateExpansion;
import buildcraft.core.lib.utils.StringUtils;

public abstract class GateExpansionBuildcraft implements IGateExpansion {

    private final String tag;
    private TextureAtlasSprite iconBlock;
    private TextureAtlasSprite iconItem;

    public GateExpansionBuildcraft(String tag) {
        this.tag = tag;
    }

    @Override
    public String getUniqueIdentifier() {
        return "buildcraft:" + tag;
    }

    @Override
    public String getDisplayName() {
        return StringUtils.localize("gate.expansion." + tag);
    }

    @Override
    public void registerBlockOverlay(TextureAtlasSpriteRegister iconRegister) {
        iconBlock = iconRegister.registerIcon("buildcrafttransport:gates/gate_expansion_" + tag);
    }

    @Override
    public void registerItemOverlay(TextureAtlasSpriteRegister iconRegister) {
        iconItem = iconRegister.registerIcon("buildcrafttransport:gates/gate_expansion_" + tag);
    }

    @Override
    public TextureAtlasSprite getOverlayBlock() {
        return iconBlock;
    }

    @Override
    public TextureAtlasSprite getOverlayItem() {
        return iconItem;
    }
}

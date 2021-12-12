package com.mcarctic.btb.client.renderer;

import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.client.renderer.RenderType.makeType;

public class ModRenderType extends RenderState {

    public ModRenderType(String p_i225973_1_, Runnable p_i225973_2_, Runnable p_i225973_3_) {
        super(p_i225973_1_, p_i225973_2_, p_i225973_3_);
    }

    public static RenderType getCustomEyes(ResourceLocation p_228652_0_) {
        TextureState renderstate$texturestate = new TextureState(p_228652_0_, false, false);
        return makeType("custom_eyes", DefaultVertexFormats.ENTITY, 7, 256, false, true, RenderType.State.getBuilder().texture(renderstate$texturestate).transparency(ADDITIVE_TRANSPARENCY).writeMask(COLOR_WRITE).fog(BLACK_FOG).fog(NO_FOG).build(false));
    }
}

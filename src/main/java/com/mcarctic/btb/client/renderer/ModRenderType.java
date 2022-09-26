package com.mcarctic.btb.client.renderer;


import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static net.minecraft.client.renderer.RenderType.create;

public class ModRenderType extends RenderStateShard {

    public ModRenderType(String p_i225973_1_, Runnable p_i225973_2_, Runnable p_i225973_3_) {
        super(p_i225973_1_, p_i225973_2_, p_i225973_3_);
    }

    public static RenderType getCustomEyes(ResourceLocation p_228652_0_) {
        RenderStateShard.TextureStateShard renderstate$texturestate = new RenderStateShard.TextureStateShard(p_228652_0_, false, false);
        return create("custom_eyes", DefaultVertexFormat.NEW_ENTITY, 7, 256, false, true, RenderType.CompositeState.builder().setTextureState(renderstate$texturestate).setTransparencyState(ADDITIVE_TRANSPARENCY).setWriteMaskState(COLOR_WRITE).fog(BLACK_FOG).fog(NO_FOG).build(false));
    }
}

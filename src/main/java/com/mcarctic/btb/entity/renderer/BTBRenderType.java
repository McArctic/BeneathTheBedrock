package com.mcarctic.btb.entity.renderer;


import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static net.minecraft.client.renderer.RenderType.create;

public class BTBRenderType extends RenderStateShard {

    public BTBRenderType(String p_i225973_1_, Runnable p_i225973_2_, Runnable p_i225973_3_) {
        super(p_i225973_1_, p_i225973_2_, p_i225973_3_);
    }

    public static RenderType voidEyes(ResourceLocation texture) {
        RenderStateShard.TextureStateShard textureState = new RenderStateShard.TextureStateShard(texture, false, false);

        return create("void_eyes", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true,
                RenderType.CompositeState.builder()
                        .setShaderState(RENDERTYPE_ENTITY_ALPHA_SHADER).setTextureState(textureState)
                        .setTransparencyState(ADDITIVE_TRANSPARENCY).setWriteMaskState(COLOR_WRITE)
                        .createCompositeState(false));
    }
}

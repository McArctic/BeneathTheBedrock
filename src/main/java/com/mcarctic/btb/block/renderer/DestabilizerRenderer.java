package com.mcarctic.btb.block.renderer;

import com.mcarctic.btb.block.entity.DestabilizerBlockEntity;
import com.mcarctic.btb.block.model.DestabilizerBlockModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

public class DestabilizerRenderer extends GeoBlockRenderer<DestabilizerBlockEntity> {

    public DestabilizerRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new DestabilizerBlockModel());
    }

    @Override
    public RenderType getRenderType(DestabilizerBlockEntity animateable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                    int packedLightIn, ResourceLocation texturelocation) {
        return RenderType.entityTranslucent(getTextureLocation(animateable));
    }
}
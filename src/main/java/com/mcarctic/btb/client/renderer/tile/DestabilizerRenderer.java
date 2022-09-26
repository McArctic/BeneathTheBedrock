package com.mcarctic.btb.client.renderer.tile;

import com.mcarctic.btb.client.model.tile.DestabilizerModel;
import com.mcarctic.btb.tileentity.DestabilizerTile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class DestabilizerRenderer extends GeoBlockRenderer<DestabilizerTile> {
    public DestabilizerRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new DestabilizerModel());
    }

    @Override
    public RenderType getRenderType(DestabilizerTile animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));

    }
}

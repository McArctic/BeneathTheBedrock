package com.mcarctic.btb.client.renderer.tile;

import com.mcarctic.btb.client.model.tile.DestabilizerModel;
import com.mcarctic.btb.tileentity.DestabilizerTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

public class DestabilizerRenderer extends GeoBlockRenderer<DestabilizerTile> {
    public DestabilizerRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new DestabilizerModel());
    }

    @Override
    public RenderType getRenderType(DestabilizerTile animatable, float partialTicks, MatrixStack stack,
                                    IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));

    }
}

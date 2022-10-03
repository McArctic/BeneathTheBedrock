package com.mcarctic.btb.entity.renderer;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.VoidCrawler;
import com.mcarctic.btb.entity.model.VoidCrawlerModel;
import com.mcarctic.btb.entity.model.layers.VoidCrawlerBodyLayer;
import com.mcarctic.btb.entity.model.layers.VoidCrawlerEyesLayer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VoidCrawlerRenderer<T extends VoidCrawler> extends MobRenderer<T, VoidCrawlerModel<T>> {
    private static final ResourceLocation VOIDCRAWLER_LOCATION = new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler.png");

    public VoidCrawlerRenderer(EntityRendererProvider.Context p_174401_) {
        this(p_174401_, ModelLayers.SPIDER);
    }

    public VoidCrawlerRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pLayer) {
        super(pContext, new VoidCrawlerModel<>(pContext.bakeLayer(pLayer)), 0.8F);
        this.addLayer(new VoidCrawlerEyesLayer<>(this));
        this.addLayer(new VoidCrawlerBodyLayer<>(this));
    }

    protected float getFlipDegrees(T pLivingEntity) {
        return 180.0F;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(T pEntity) {
        return VOIDCRAWLER_LOCATION;
    }
}
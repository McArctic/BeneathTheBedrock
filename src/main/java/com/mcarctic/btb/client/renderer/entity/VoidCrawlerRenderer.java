package com.mcarctic.btb.client.renderer.entity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.client.model.entity.layers.VoidCrawlerBodyLayer;
import com.mcarctic.btb.client.model.entity.layers.VoidCrawlerEyesLayer;
import com.mcarctic.btb.entity.custom.VoidCrawler;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class VoidCrawlerRenderer extends MobRenderer<VoidCrawler, SpiderModel<VoidCrawler>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler.png");

    public VoidCrawlerRenderer(EntityRendererProvider.Context p_174401_) {
        this(p_174401_, ModelLayers.SPIDER);
    }

    public VoidCrawlerRenderer(EntityRendererProvider.Context pContext, ModelLayerLocation pLayer) {
        super(pContext, new SpiderModel<>(pContext.bakeLayer(pLayer)), 0.8F);
        this.addLayer(new VoidCrawlerEyesLayer<>(this));
        this.addLayer(new VoidCrawlerBodyLayer<>(this));
    }

    protected float getFlipDegrees(VoidCrawler pLivingEntity) {
        return 180.0F;
    }


    @Override
    public ResourceLocation getTextureLocation(VoidCrawler entity) {
        return TEXTURE;
    }
}

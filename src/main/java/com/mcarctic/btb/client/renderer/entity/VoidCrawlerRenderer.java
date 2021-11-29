package com.mcarctic.btb.client.renderer.entity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.client.model.entity.VoidCrawlerModel;
import com.mcarctic.btb.client.model.entity.layers.VoidCrawlerEyesLayer;
import com.mcarctic.btb.entity.custom.VoidCrawlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class VoidCrawlerRenderer extends MobRenderer<VoidCrawlerEntity, VoidCrawlerModel<VoidCrawlerEntity>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler.png");

    public VoidCrawlerRenderer(EntityRendererManager renderManagerIn){
        super(renderManagerIn, new VoidCrawlerModel(),
                //Shadow Size
                0.7f);
        this.addLayer(new VoidCrawlerEyesLayer(this));
    }


    @Override
    public ResourceLocation getEntityTexture(VoidCrawlerEntity entity) {
        return TEXTURE;
    }
}

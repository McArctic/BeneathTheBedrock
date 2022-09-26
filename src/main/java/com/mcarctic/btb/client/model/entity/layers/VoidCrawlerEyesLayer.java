package com.mcarctic.btb.client.model.entity.layers;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.client.renderer.ModRenderType;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;


public class VoidCrawlerEyesLayer<T extends Entity, M extends SpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType RENDER_TYPE = ModRenderType.getCustomEyes(new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler_eyes.png"));


    public VoidCrawlerEyesLayer(RenderLayerParent<T, M> p_i50921_1_) {
        super(p_i50921_1_);
    }

    @Override
    public RenderType renderType() {
        return RENDER_TYPE;
    }
}
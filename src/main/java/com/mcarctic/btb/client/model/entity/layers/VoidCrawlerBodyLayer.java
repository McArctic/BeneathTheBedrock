package com.mcarctic.btb.client.model.entity.layers;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.client.model.entity.VoidCrawlerModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class VoidCrawlerBodyLayer<T extends Entity, M extends VoidCrawlerModel<T>> extends EyesLayer<T, M> {
    private static final RenderType RENDER_TYPE = RenderType.eyes(new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler_body_layer.png"));

    public VoidCrawlerBodyLayer(RenderLayerParent<T, M> p_i50921_1_) {
        super(p_i50921_1_);
    }

    @Override
    public RenderType renderType() {
        return RENDER_TYPE;
    }
}

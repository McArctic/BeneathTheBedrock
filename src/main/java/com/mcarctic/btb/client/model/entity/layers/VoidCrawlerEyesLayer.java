package com.mcarctic.btb.client.model.entity.layers;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.client.model.entity.VoidCrawlerModel;
import com.mcarctic.btb.client.renderer.ModRenderType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;


public class VoidCrawlerEyesLayer<T extends MonsterEntity, M extends VoidCrawlerModel<T>> extends AbstractEyesLayer<T, M> {
    private static final RenderType RENDER_TYPE = ModRenderType.getCustomEyes(new ResourceLocation(BeneathTheBedrock.MOD_ID,"textures/entity/void_crawler_eyes.png"));


    public VoidCrawlerEyesLayer(IEntityRenderer<T, M> p_i50921_1_) {
        super(p_i50921_1_);
    }

    @Override
    public RenderType getRenderType() {
        return RENDER_TYPE;
    }
}
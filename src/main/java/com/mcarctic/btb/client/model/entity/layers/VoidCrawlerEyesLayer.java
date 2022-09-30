package com.mcarctic.btb.client.model.entity.layers;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.client.model.entity.VoidCrawlerModel;
import com.mcarctic.btb.client.renderer.BTBRenderType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VoidCrawlerEyesLayer<T extends Entity, M extends VoidCrawlerModel<T>> extends EyesLayer<T, M> {
    private static final RenderType EYE_TYPE = BTBRenderType.voidEyes(new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler_eyes.png"));

    public VoidCrawlerEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return EYE_TYPE;
    }
}
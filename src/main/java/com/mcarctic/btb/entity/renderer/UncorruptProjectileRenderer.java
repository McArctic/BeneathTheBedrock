package com.mcarctic.btb.entity.renderer;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.projectiles.UncorruptProjectile;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class UncorruptProjectileRenderer extends EntityRenderer<UncorruptProjectile> {

    public UncorruptProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(UncorruptProjectile pEntity) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/entity/void_crawler.png");
    }
}

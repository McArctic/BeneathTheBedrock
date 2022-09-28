package com.mcarctic.btb.client.model.tile;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.DestabilizerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DestabilizerBlockModel extends AnimatedGeoModel<DestabilizerBlockEntity> {


    @Override
    public ResourceLocation getAnimationFileLocation(DestabilizerBlockEntity object) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "animations/destabilizer.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(DestabilizerBlockEntity animatable) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "geo/destabilizer.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DestabilizerBlockEntity object) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/block/destabilizer.png");
    }
}

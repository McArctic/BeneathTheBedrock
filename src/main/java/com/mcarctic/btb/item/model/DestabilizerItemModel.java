package com.mcarctic.btb.item.model;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DestabilizerItemModel extends AnimatedGeoModel<DestabilizerBlockItem> {

    @Override
    public ResourceLocation getAnimationFileLocation(DestabilizerBlockItem object) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "animations/destabilizer.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(DestabilizerBlockItem animatable) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "geo/destabilizer.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DestabilizerBlockItem object) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/block/destabilizer.png");
    }
}


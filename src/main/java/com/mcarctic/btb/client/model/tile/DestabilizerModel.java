package com.mcarctic.btb.client.model.tile;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class
DestabilizerModel extends AnimatedGeoModel {

    //Change and " "
    @Override
    public ResourceLocation getAnimationFileLocation(Object entity) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "animations/destabilizer.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Object animatable) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "geo/destabilizer.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity) {
        return new ResourceLocation(BeneathTheBedrock.MOD_ID, "textures/block/destabilizer.png");
    }
}

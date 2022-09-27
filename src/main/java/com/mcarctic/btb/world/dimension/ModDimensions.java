package com.mcarctic.btb.world.dimension;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> VOIDDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "voiddim"));
    public static final ResourceKey<DimensionType> VOIDDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, VOIDDIM_KEY.getRegistryName());

    public static void register(){
        System.out.println("Register Dim for" + BeneathTheBedrock.MOD_ID);
    }


}

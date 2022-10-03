package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.DimensionType;

public class BTBDimensionTypes {

    public static final ResourceKey<DimensionType> VOID_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, BTBDimensions.VOID.getRegistryName());

    public static void register() {
        System.out.println("Register DimensionTypes for " + BeneathTheBedrock.MOD_ID);
    }

}

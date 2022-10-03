package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class BTBDimensions {
    public static final ResourceKey<Level> VOID = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "void"));

    public static void register() {

        System.out.println("Register Dim for" + BeneathTheBedrock.MOD_ID);
        BTBDimensionTypes.register();
    }


}

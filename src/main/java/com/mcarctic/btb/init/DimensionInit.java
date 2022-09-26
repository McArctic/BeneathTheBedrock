package com.mcarctic.btb.init;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;


public class DimensionInit {
    public static final ResourceKey<Level> VOID_WORLD = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "void"));
}


package com.mcarctic.btb.world.biome;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BTBBiomes {
    public static final ResourceKey<Biome> VOID_PLAINS = ResourceKey.create(Registry.BIOME_REGISTRY,
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "void_plains"));

    public static void register() {
        System.out.println("Register Biome for" + BeneathTheBedrock.MOD_ID);
    }
}

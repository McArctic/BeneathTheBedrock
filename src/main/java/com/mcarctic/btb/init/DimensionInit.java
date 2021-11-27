package com.mcarctic.btb.init;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionInit {
    public static final RegistryKey<World> VOID_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(BeneathTheBedrock.MOD_ID, "void"));
}


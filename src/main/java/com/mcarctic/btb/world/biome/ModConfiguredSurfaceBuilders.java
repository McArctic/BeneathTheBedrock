package com.mcarctic.btb.world.biome;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {
    public static ConfiguredSurfaceBuilder<?> VOID_SURFACE = register("void_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                    ModBlocks.VOID_FABRIC.get().getDefaultState(),
                    ModBlocks.VOID_FABRIC.get().getDefaultState(),
                    ModBlocks.VOID_FABRIC.get().getDefaultState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb){
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(BeneathTheBedrock.MOD_ID, name), csb);
    }

}

package com.mcarctic.btb.world.biome;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.ModEntityTypes;
import com.mcarctic.btb.world.gen.ModStructureGeneration;
import com.mcarctic.btb.world.structure.ModStructures;
import net.minecraft.block.Blocks;
import net.minecraft.block.MagmaBlock;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.*;
import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, BeneathTheBedrock.MOD_ID);

    public static final RegistryObject<Biome> VOID_PLAINS = BIOMES.register("void_plains",
            () -> makeVoidBiome(() -> ModConfiguredSurfaceBuilders.VOID_SURFACE, 0.125f, 0.05f));

    private  static  Biome makeVoidBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale){
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        // DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        // DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
       // mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
          //   new MobSpawnInfo.Spawners(EntityType.BLAZE, 100, 0, 0));
          mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
               new MobSpawnInfo.Spawners(ModEntityTypes.VOID_CRAWLER.get(), 100, 0, 1));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

        // biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL_SWAMP);
        // biomegenerationsettings$builder.withStructure(StructureFeatures.BURIED_TREASURE);

        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);

        // DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        // DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        // DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        // DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        //  DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
        // DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
        //DefaultBiomeFeatures.withDesertVegetation(biomegenerationsettings$builder);
        //  DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);

        //biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
        //  DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);

        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.NONE).depth(depth).scale(scale)
                .temperature(1.5F)
                .downfall(0.9F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(1180449)
                        .setWaterFogColor(0)
                        .setFogColor(0)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.8F))
                        .withFoliageColor(-3407872)
                        .withGrassColor(854292)
                        .setParticle(new ParticleEffectAmbience(ParticleTypes.ASH, 0.003f))
                        .withSkyColor(0)
                        .setAmbientSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST))
                        .build())
                .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();

    }
    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.2460909F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static void register(IEventBus eventBus){
        BIOMES.register(eventBus);
    }


}

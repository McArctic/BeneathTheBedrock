package com.mcarctic.btb.world.biome;

public class ModBiomes {
    /*public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, BeneathTheBedrock.MOD_ID);

    public static final RegistryObject<Biome> VOID_PLAINS = BIOMES.register("void_plains",
            () -> makeVoidBiome(() -> ModConfiguredSurfaceBuilders.VOID_SURFACE, 0.125f, 0.05f));

    private static Biome makeVoidBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();

        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(ModEntityTypes.VOID_CRAWLER.get(), 100, 0, 1));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);

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

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

*/ //TODO Generation
}

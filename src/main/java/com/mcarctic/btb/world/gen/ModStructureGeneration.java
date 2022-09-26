package com.mcarctic.btb.world.gen;

import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        /*ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
        //BiomeDictionary.Type.getAll() Biome Spawn In?
        if (types.contains(BiomeDictionary.Type.OVERWORLD)) {
            List<Supplier<StructureFeature<?>>> structures = event.getGeneration().;

            structures.add(() -> ModStructures.DESTABILIZER_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if (event.getName().toString().contains(ModBiomes.VOID_PLAINS.get().getRegistryName().toString())) {

            List<Supplier<StructureFeature<?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.VOID_REMNANT.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

        }*/ //TODO Generation
    }
}

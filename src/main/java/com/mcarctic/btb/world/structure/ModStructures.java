package com.mcarctic.btb.world.structure;

public class ModStructures {

  /*  public static final DeferredRegister<Structure<?>> STRUCTURES =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, BeneathTheBedrock.MOD_ID);


    public static final RegistryObject<Structure<NoFeatureConfig>> DESTABILIZER_ROOM =
            STRUCTURES.register("destabilizer_room", DestabilizerRoomStructure::new);


    public static final RegistryObject<Structure<NoFeatureConfig>> VOID_REMNANT =
            STRUCTURES.register("void_remnant", VoidRemnantStructure::new);


    public static void setupStructures() {
        setupMapSpacingAndLand(DESTABILIZER_ROOM.get(),
                new StructureSeparationSettings(20, 5, 971241325),
                true);

        setupMapSpacingAndLand(VOID_REMNANT.get(),
                new StructureSeparationSettings(20, 5, 971241325),
                true);
    }


    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings,
                                                                       boolean transformSurroundingLand) {
        //add our structures into the map in Structure class
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);



        if (transformSurroundingLand) {
            Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder()
                    .addAll(Structure.field_236384_t_)
                    .add(structure)
                    .build();


        }

        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();


        WorldGenRegistries.NOISE_SETTINGS.getEntries().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap =
                    settings.getValue().getStructures().func_236195_a_();


            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().getStructures().func_236195_a_();

            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });

    }

    public static void register(IEventBus eventBus){
        STRUCTURES.register(eventBus);
    }
*/ //TODO Generation
}

package com.mcarctic.btb.world.structure;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BTBStructures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, BeneathTheBedrock.MOD_ID);

    public static final RegistryObject<StructureFeature<?>> DESTABILIZER_STRONGHOLDS =
            DEFERRED_REGISTRY_STRUCTURE.register("destabilizer_strongholds", DestabilizerStrongholds::new);


    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}
package com.mcarctic.btb.entity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.ModBlocks;
import com.mcarctic.btb.entity.custom.DestabilizerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BeneathTheBedrock.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }


    public static final RegistryObject<BlockEntityType<DestabilizerBlockEntity>> DESTABILIZER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("destabilizer_block_entity", () ->
                    BlockEntityType.Builder.of(DestabilizerBlockEntity::new,
                            ModBlocks.DESTABILIZER.get()).build(null));


}

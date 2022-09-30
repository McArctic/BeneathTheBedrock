package com.mcarctic.btb.entity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.BTBBlocks;
import com.mcarctic.btb.entity.custom.DestabilizerBlockEntity;
import com.mcarctic.btb.tileentity.VoidFabricBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BTBBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BeneathTheBedrock.MOD_ID);
    public static final RegistryObject<BlockEntityType<VoidFabricBlockEntity>> VOID_FABRIC_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("void_fabric_block_entity", () ->
                    BlockEntityType.Builder.of(VoidFabricBlockEntity::new,
                            BTBBlocks.VOID_FABRIC_TEMP.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<DestabilizerBlockEntity>> DESTABILIZER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("destabilizer_block_entity", () ->
                    BlockEntityType.Builder.of(DestabilizerBlockEntity::new,
                            BTBBlocks.DESTABILIZER.get()).build(null));


}

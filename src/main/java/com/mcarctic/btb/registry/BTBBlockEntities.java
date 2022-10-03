package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.entity.DestabilizerBlockEntity;
import com.mcarctic.btb.block.entity.TieredVoidBlockEntity;
import com.mcarctic.btb.block.entity.VoidFabricBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BTBBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BeneathTheBedrock.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<VoidFabricBlockEntity>> VOID_FABRIC_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("void_fabric_block_entity", () ->
                    BlockEntityType.Builder.of(VoidFabricBlockEntity::new,
                            BTBBlocks.VOID_FABRIC_TEMP.getBlock()).build(null));

    public static final RegistryObject<BlockEntityType<TieredVoidBlockEntity>> TIERED_VOID_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("tiered_void_block_entity", () ->
                    BlockEntityType.Builder.of(TieredVoidBlockEntity::new,
                            BTBBlocks.VOID_FABRIC_WOOD.getBlock()).build(null));

    public static final RegistryObject<BlockEntityType<DestabilizerBlockEntity>> DESTABILIZER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("destabilizer_block_entity", () ->
                    BlockEntityType.Builder.of(DestabilizerBlockEntity::new,
                            BTBBlocks.DESTABILIZER.getBlock()).build(null));


}

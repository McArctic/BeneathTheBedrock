package com.mcarctic.btb.tileentity;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<BlockEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BeneathTheBedrock.MOD_ID);


    /* TODO BlockEntity

    public static RegistryObject<BlockEntityType<DestabilizerTile>> DESTABILIZER_TILE =
            TILE_ENTITIES.register("destabilizer", () -> BlockEntityType.Builder.of(
                    DestabilizerTile::new, ModBlocks.DESTABILIZER.get()).build(null));

     */

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}

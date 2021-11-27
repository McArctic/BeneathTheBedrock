package com.mcarctic.btb.tileentity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BeneathTheBedrock.MOD_ID);


    public static RegistryObject<TileEntityType<DestabilizerTile>> DESTABILIZER_TILE =
            TILE_ENTITIES.register("destabilizer", () -> TileEntityType.Builder.create(
                    DestabilizerTile::new, ModBlocks.DESTABILIZER.get()).build(null));

    public static void register(IEventBus eventBus){
        TILE_ENTITIES.register(eventBus);
    }
}

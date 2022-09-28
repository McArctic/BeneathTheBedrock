package com.mcarctic.btb.item;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.ModBlocks;
import com.mcarctic.btb.entity.ModEntityTypes;
import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import com.mcarctic.btb.item.custom.ModSpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BeneathTheBedrock.MOD_ID);


    public static final RegistryObject<Item> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe",
            () -> new Item(new Item.Properties().tab(ModItemGroup.VOID_GROUP)));

    //Spawn Eggs
    public static final RegistryObject<ModSpawnEggItem> VOID_CRAWLER_SPAWN_EGG = ITEMS.register("void_crawler_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.VOID_CRAWLER, 0x0f141a, 0x0e97a8,
                    new Item.Properties().tab(ModItemGroup.VOID_GROUP)));

    public static final RegistryObject<Item> DESTABILIZER_BLOCK_ITEM = ITEMS.register("destabilizer_block_item",
            () -> new DestabilizerBlockItem(ModBlocks.DESTABILIZER.get(),
                    new Item.Properties().tab(ModItemGroup.VOID_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}

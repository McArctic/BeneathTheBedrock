package com.mcarctic.btb.item;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.BTBBlocks;
import com.mcarctic.btb.entity.BTBEntityTypes;
import com.mcarctic.btb.item.custom.BTBSpawnEggItem;
import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BTBItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BeneathTheBedrock.MOD_ID);


    public static final RegistryObject<Item> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe",
            () -> new Item(new Item.Properties().tab(BTBItemGroup.VOID_GROUP)));

    //Spawn Eggs
    public static final RegistryObject<BTBSpawnEggItem> VOID_CRAWLER_SPAWN_EGG = ITEMS.register("void_crawler_spawn_egg",
            () -> new BTBSpawnEggItem(BTBEntityTypes.VOID_CRAWLER, 0x0f141a, 0x0e97a8,
                    new Item.Properties().tab(BTBItemGroup.VOID_GROUP)));

    public static final RegistryObject<Item> DESTABILIZER_BLOCK_ITEM = ITEMS.register("destabilizer_block_item",
            () -> new DestabilizerBlockItem(BTBBlocks.DESTABILIZER.get(),
                    new Item.Properties().tab(BTBItemGroup.VOID_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}

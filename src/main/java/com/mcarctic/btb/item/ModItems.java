package com.mcarctic.btb.item;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.ModEntityTypes;
import com.mcarctic.btb.item.custom.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BeneathTheBedrock.MOD_ID);


    public static final RegistryObject<Item> BEDROCK_PICKAXE = ITEMS.register("bedrock_pickaxe",
            () -> new Item(new Item.Properties().group(ModItemGroup.VOID_GROUP)));

    //Spawn Eggs
    public static final RegistryObject<ModSpawnEggItem> VOID_CRAWLER_SPAWN_EGG = ITEMS.register("void_crawler_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.VOID_CRAWLER, 0x0f141a, 0x0e97a8,
                    new Item.Properties().group(ModItemGroup.VOID_GROUP)));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}

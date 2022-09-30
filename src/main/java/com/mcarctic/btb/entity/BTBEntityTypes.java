package com.mcarctic.btb.entity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.VoidCrawler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BTBEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BeneathTheBedrock.MOD_ID);

    public static final RegistryObject<EntityType<VoidCrawler>> VOID_CRAWLER =
            ENTITY_TYPES.register("void_crawler",
                    () -> EntityType.Builder.of(VoidCrawler::new, MobCategory.MONSTER)
                            .sized(1f, 2f)
                            .build(new ResourceLocation(BeneathTheBedrock.MOD_ID, "void_crawler").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

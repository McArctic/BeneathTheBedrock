package com.mcarctic.btb.entity;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.VoidCrawlerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BeneathTheBedrock.MOD_ID);





    public static final RegistryObject<EntityType<VoidCrawlerEntity>> VOID_CRAWLER =
            ENTITY_TYPES.register("void_crawler", () -> EntityType.Builder.create(VoidCrawlerEntity::new,
                    EntityClassification.MONSTER).size(1f, 2f).build(new ResourceLocation(BeneathTheBedrock.MOD_ID,
                    "void_crawler").toString()));




    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}

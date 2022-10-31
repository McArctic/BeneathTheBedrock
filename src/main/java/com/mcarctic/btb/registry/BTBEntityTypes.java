package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.VoidCrawler;
import com.mcarctic.btb.entity.custom.projectiles.UncorruptProjectile;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
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
            register("void_crawler",
                    EntityType.Builder.of(VoidCrawler::new, MobCategory.MONSTER).sized(1f, 2f));

    public static final RegistryObject<EntityType<UncorruptProjectile>> UNCORRUPT_PROJECTILE =
            register("uncorrupt_projectile",
                    EntityType.Builder.<UncorruptProjectile>of(UncorruptProjectile::new, MobCategory.MISC).sized(.1f, .1f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(new ResourceLocation(BeneathTheBedrock.MOD_ID, name).toString()));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

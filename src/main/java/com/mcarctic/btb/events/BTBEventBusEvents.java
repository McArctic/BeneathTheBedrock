package com.mcarctic.btb.events;


import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.entity.custom.VoidCrawler;
import com.mcarctic.btb.item.custom.BTBSpawnEggItem;
import com.mcarctic.btb.registry.BTBEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BTBEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(BTBEntityTypes.VOID_CRAWLER.get(), VoidCrawler.createAttributes());
    }


    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        BTBSpawnEggItem.initSpawnEggs();
    }

}

package com.mcarctic.btb.events;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.world.gen.BTBEntityGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID)
public class BTBWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        BTBEntityGeneration.onEntitySpawn(event);
    }
}

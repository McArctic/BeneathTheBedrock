package com.mcarctic.btb.events;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.renderer.DestabilizerRenderer;
import com.mcarctic.btb.registry.BTBBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BTBEventClientBusEvent {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BTBBlockEntities.DESTABILIZER_BLOCK_ENTITY.get(), DestabilizerRenderer::new);
    }
}

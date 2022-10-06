package com.mcarctic.btb.events;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.custom.TieredVoidBlock;
import com.mcarctic.btb.registry.BTBBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zytorx.library.registry.RegisteredBlock;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BTBTextureEvents {
    @SubscribeEvent
    public static void onStitchEvent(TextureStitchEvent.Pre event) {
        for (var field : BTBBlocks.class.getDeclaredFields()) {
            try {
                if (field.canAccess(null) && field.get(null) instanceof RegisteredBlock registered) {
                    if (registered.getBlock() instanceof TieredVoidBlock) {
                        var location = registered.getBlock().getRegistryName();
                        event.addSprite(new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

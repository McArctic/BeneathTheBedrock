package com.mcarctic.btb.events;


import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.registry.BTBEnchantments;
import com.mcarctic.btb.registry.BTBDimensions;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class BTBClientEvents {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onFogDensity(EntityViewRenderEvent.RenderFogEvent event) {

        var player = Minecraft.getInstance().player;

        if (player.getLevel().dimension() != BTBDimensions.VOID) {
            return;
        }

        Enchantment ench = BTBEnchantments.VOID_VISION.get();

        if (EnchantmentHelper.getEnchantmentLevel(ench, player) > 0) {
            return;
        }

        RenderSystem.setShaderFogColor(0, 0, 0);
        RenderSystem.setShaderFogStart(.1F);
        RenderSystem.setShaderFogEnd(Math.min(10F, event.getFarPlaneDistance() * 0.5F));
    }
}

package com.mcarctic.btb.events;


import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.enchantment.ModEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onFogDensityEvent(EntityViewRenderEvent.RenderFogEvent event) {

        Player player = Minecraft.getInstance().player;
        Enchantment ench = ModEnchantments.VOID_VISION.get();

        if (EnchantmentHelper.getEnchantmentLevel(ench, player) > 0) {
            return;
        }

        if (player.getLevel().dimension() == Level.NETHER) {
            event.setNearPlaneDistance(.3F);
            //event.setCanceled(true);
        }
    }
}

package com.mcarctic.btb.events;


import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.init.DimensionInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.RegistryKey;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onFogDensityEvent(EntityViewRenderEvent.FogDensity event) {

        PlayerEntity player = Minecraft.getInstance().player;

        if(event.getRenderer().getActiveRenderInfo().getRenderViewEntity().getEntityWorld().getDimensionKey() == DimensionInit.VOID_WORLD && player.inventory.armorInventory.get(3).getItem() == Items.DIAMOND_HELMET)
        {


        }
        else if (event.getRenderer().getActiveRenderInfo().getRenderViewEntity().getEntityWorld().getDimensionKey() == DimensionInit.VOID_WORLD)
        {
            event.setDensity(.3F);
            event.setCanceled(true);
        }
        else
        {

        }

    }



}

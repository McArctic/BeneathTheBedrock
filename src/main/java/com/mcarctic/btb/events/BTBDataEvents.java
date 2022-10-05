package com.mcarctic.btb.events;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.VoidMagicLevel;
import com.mcarctic.btb.data.playerdata.PlayerMagicLevel;
import com.mcarctic.btb.data.playerdata.PlayerMagicLevelProvider;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BTBDataEvents {
    private static final int tick = 0;

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {

        //If is not instance of Player
        if (!(event.getObject() instanceof Player player)) {
            return;
        }

        if (!player.getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).isPresent()) {
            event.addCapability(new ResourceLocation(BeneathTheBedrock.MOD_ID, "voidmagic"), new PlayerMagicLevelProvider());
        }
    }

    @SubscribeEvent
    public static void onClonePlayer(PlayerEvent.Clone event) {
        event.getOriginal().reviveCaps();

        event.getOriginal().getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(
                oldPlayer ->
                        event.getOriginal().getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(newPlayer ->
                                newPlayer.copyFrom(oldPlayer)
                        )
        );
        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerMagicLevel.class);
    }

    @SubscribeEvent
    public static void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getTo() != BTBDimensions.VOID) {
            return;
        }
        event.getPlayer().getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(capability -> {
            if (capability.getLevel() == VoidMagicLevel.NONE) {
                capability.levelUp();
            }
        });
    }
}

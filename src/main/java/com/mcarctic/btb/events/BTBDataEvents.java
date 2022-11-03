package com.mcarctic.btb.events;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.chunkdata.CorruptedChunkProvider;
import com.mcarctic.btb.data.magicdata.VoidMagicLevel;
import com.mcarctic.btb.data.playerdata.MagicData;
import com.mcarctic.btb.data.playerdata.MagicDataProvider;
import com.mcarctic.btb.registry.BTBDimensions;
import com.mcarctic.btb.util.CapabilityHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BTBDataEvents {
    @SubscribeEvent
    public static void onAttachChunkCapabilities(AttachCapabilitiesEvent<LevelChunk> event) {

        var chunk = event.getObject();

        if (!chunk.getCapability(CorruptedChunkProvider.CORRUPTED_CHUNK).isPresent()) {
            event.addCapability(new ResourceLocation(BeneathTheBedrock.MOD_ID, "corrupted_chunk"), new CorruptedChunkProvider());
        }
    }

    @SubscribeEvent
    public static void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {

        //If is not instance of Player
        if (!(event.getObject() instanceof ServerPlayer player)) {
            return;
        }

        if (!player.getCapability(MagicDataProvider.MAGIC_DATA).isPresent()) {
            event.addCapability(new ResourceLocation(BeneathTheBedrock.MOD_ID, "voidmagic"), new MagicDataProvider());
        }
        player.getCapability(MagicDataProvider.MAGIC_DATA).ifPresent(cap -> cap.update(player));
    }

    @SubscribeEvent
    public static void onClonePlayer(PlayerEvent.Clone event) {

        event.getOriginal().reviveCaps();

        event.getOriginal().getCapability(MagicDataProvider.MAGIC_DATA).ifPresent(
                oldPlayer ->
                        event.getOriginal().getCapability(MagicDataProvider.MAGIC_DATA).ifPresent(newPlayer -> {
                            newPlayer.copyFrom(oldPlayer);
                            if (event.getPlayer() instanceof ServerPlayer player) {
                                newPlayer.update(player);
                            }
                        }));
        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(MagicData.class);
    }

    @SubscribeEvent
    public static void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getTo() != BTBDimensions.VOID) {
            return;
        }
        if (!(event.getPlayer() instanceof ServerPlayer serverPlayer)) {
            return;
        }

        var level = CapabilityHelper.getMagicLevel(serverPlayer);
        if (level == VoidMagicLevel.NONE) {
            CapabilityHelper.setMagicLevel(serverPlayer, VoidMagicLevel.CORRUPTED);
        }
    }

    @SubscribeEvent
    public static void onJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            CapabilityHelper.updateAll(player);
        }
    }
}

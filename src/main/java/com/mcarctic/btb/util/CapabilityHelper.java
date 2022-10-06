package com.mcarctic.btb.util;

import com.mcarctic.btb.data.VoidMagicLevel;
import com.mcarctic.btb.data.playerdata.PlayerMagicLevelProvider;
import net.minecraft.server.level.ServerPlayer;

public class CapabilityHelper {

    public static VoidMagicLevel getMagicLevel(ServerPlayer player) {
        var cap = player.getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL);
        if (!cap.isPresent()) {
            throw new RuntimeException();
        }

        var optional = cap.resolve();
        if (optional.isEmpty()) {
            throw new RuntimeException();
        }

        return optional.get().getLevel();
    }

    public static void setMagicLevel(ServerPlayer player, VoidMagicLevel level) {
        var cap = player.getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL);
        if (!cap.isPresent()) {
            throw new RuntimeException();
        }

        var optional = cap.resolve();
        if (optional.isEmpty()) {
            throw new RuntimeException();
        }

        var playerLevel = optional.get();
        playerLevel.setLevel(level);
        playerLevel.update(player);
    }

}

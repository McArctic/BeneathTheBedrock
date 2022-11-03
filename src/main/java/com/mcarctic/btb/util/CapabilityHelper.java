package com.mcarctic.btb.util;

import com.mcarctic.btb.data.magicdata.model.IMagicLevel;
import com.mcarctic.btb.data.playerdata.MagicDataProvider;
import net.minecraft.server.level.ServerPlayer;

public class CapabilityHelper {

    public static void updateAll(ServerPlayer player) {
        player.getCapability(MagicDataProvider.MAGIC_DATA).ifPresent(cap -> cap.update(player));
    }

    public static IMagicLevel getMagicLevel(ServerPlayer player) {
        var cap = player.getCapability(MagicDataProvider.MAGIC_DATA);
        if (!cap.isPresent()) {
            throw new RuntimeException();
        }

        var optional = cap.resolve();
        if (optional.isEmpty()) {
            throw new RuntimeException();
        }

        return optional.get().getLevel();
    }

    public static void setMagicLevel(ServerPlayer player, IMagicLevel level) {
        var cap = player.getCapability(MagicDataProvider.MAGIC_DATA);
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

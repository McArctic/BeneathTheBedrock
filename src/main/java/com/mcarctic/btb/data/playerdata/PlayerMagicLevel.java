package com.mcarctic.btb.data.playerdata;

import com.mcarctic.btb.data.VoidMagicLevel;
import com.mcarctic.btb.networking.BTBNetworkMessages;
import com.mcarctic.btb.networking.sync.VoidMagicLevelDataSyncS2CPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;

public class PlayerMagicLevel {

    private VoidMagicLevel level = VoidMagicLevel.NONE;

    public VoidMagicLevel getLevel() {
        return level;
    }

    public void setLevel(VoidMagicLevel level) {
        this.level = level;
    }

    public void copyFrom(PlayerMagicLevel sourcce) {
        this.level = sourcce.level;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putString("level", level.name());
    }

    public void loadNBTData(CompoundTag nbt) {
        level = VoidMagicLevel.valueOf(nbt.getString("level"));
    }

    public void update(ServerPlayer player) {
        BTBNetworkMessages.sendToPlayer(new VoidMagicLevelDataSyncS2CPacket(level), player);
    }
}

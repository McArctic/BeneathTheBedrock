package com.mcarctic.btb.networking.sync;

import com.mcarctic.btb.data.VoidMagicLevel;
import com.mcarctic.btb.data.playerdata.ClientPlayerMagicLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class VoidMagicLevelDataSyncS2CPacket {
    private final VoidMagicLevel level;

    public VoidMagicLevelDataSyncS2CPacket(VoidMagicLevel level) {
        this.level = level;
    }

    public VoidMagicLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.level = buf.readEnum(VoidMagicLevel.class);
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeEnum(level);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> ClientPlayerMagicLevel.setMagicLevel(level));
        return true;
    }
}

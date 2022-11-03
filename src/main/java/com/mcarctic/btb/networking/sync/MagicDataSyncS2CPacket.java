package com.mcarctic.btb.networking.sync;

import com.mcarctic.btb.data.playerdata.ClientMagicData;
import com.mcarctic.btb.data.playerdata.MagicData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MagicDataSyncS2CPacket {
    private final MagicData data;

    public MagicDataSyncS2CPacket(MagicData data) {
        this.data = data;
    }

    public MagicDataSyncS2CPacket(FriendlyByteBuf buf) {
        var data = new MagicData();
        data.loadNBTData(buf.readNbt());
        this.data = data;
    }

    public void toBytes(FriendlyByteBuf buf) {
        var tag = new CompoundTag();
        data.saveNBTData(tag);
        buf.writeNbt(tag);

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> ClientMagicData.update(data));
        return true;
    }
}

package com.mcarctic.btb.data.chunkdata;

import com.mcarctic.btb.data.playerdata.PlayerMagicLevel;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CorruptedChunkProvider implements ICapabilitySerializable<CompoundTag> {

    public static Capability<CorruptedChunk> CORRUPTED_CHUNK = CapabilityManager.get(new CapabilityToken<>() {
    });

    private final LazyOptional<CorruptedChunk> optional = LazyOptional.of(this::getCorruptedChunk);

    private CorruptedChunk corruptedChunk;

    private CorruptedChunk getCorruptedChunk() {
        if (corruptedChunk == null) {
            corruptedChunk = new CorruptedChunk();
        }
        return corruptedChunk;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if (cap == CORRUPTED_CHUNK) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    public CompoundTag serializeNBT() {
        var nbt = new CompoundTag();
        getCorruptedChunk().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        getCorruptedChunk().loadNBTData(nbt);
    }
}

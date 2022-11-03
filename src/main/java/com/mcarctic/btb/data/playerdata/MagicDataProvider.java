package com.mcarctic.btb.data.playerdata;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MagicDataProvider implements ICapabilitySerializable<CompoundTag> {

    public static Capability<MagicData> MAGIC_DATA = CapabilityManager.get(new CapabilityToken<>() {
    });
    private MagicData voidlingData = null;
    private final LazyOptional<MagicData> optional = LazyOptional.of(this::getVoidlingData);

    private MagicData getVoidlingData() {
        if (voidlingData == null) {
            voidlingData = new MagicData();
        }
        return voidlingData;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if (cap == MAGIC_DATA) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        var nbt = new CompoundTag();
        getVoidlingData().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        getVoidlingData().loadNBTData(nbt);
    }
}

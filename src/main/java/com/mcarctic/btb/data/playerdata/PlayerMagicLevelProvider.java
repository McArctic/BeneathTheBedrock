package com.mcarctic.btb.data.playerdata;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerMagicLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerMagicLevel> PLAYER_MAGIC_LEVEL = CapabilityManager.get(new CapabilityToken<>() {
    });
    private PlayerMagicLevel magicLevel = null;
    private final LazyOptional<PlayerMagicLevel> optional = LazyOptional.of(this::getMagicLevel);

    private PlayerMagicLevel getMagicLevel() {
        if (magicLevel == null) {
            magicLevel = new PlayerMagicLevel();
        }
        return magicLevel;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if (cap == PLAYER_MAGIC_LEVEL) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        var nbt = new CompoundTag();
        getMagicLevel().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        getMagicLevel().loadNBTData(nbt);
    }
}

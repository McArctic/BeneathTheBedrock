package com.mcarctic.btb.data.playerdata;

import com.mcarctic.btb.data.VoidMagicLevel;
import net.minecraft.nbt.CompoundTag;

public class PlayerMagicLevel {

    private VoidMagicLevel level = VoidMagicLevel.NONE;

    public VoidMagicLevel getLevel() {
        return level;
    }

    public void levelUp() {
        level = level.getLevelAbove();
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
}

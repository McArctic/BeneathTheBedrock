package com.mcarctic.btb.data.playerdata;

import com.mcarctic.btb.data.VoidMagicLevel;

public class ClientPlayerMagicLevel {
    private static VoidMagicLevel level = VoidMagicLevel.NONE;

    public static VoidMagicLevel getMagicLevel() {
        return level;
    }

    public static void setMagicLevel(VoidMagicLevel level) {
        ClientPlayerMagicLevel.level = level;
    }
}

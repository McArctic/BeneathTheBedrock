package com.mcarctic.btb.data.playerdata;

import com.mcarctic.btb.data.magicdata.VoidMagicLevel;
import com.mcarctic.btb.data.magicdata.model.IMagicLevel;

import java.util.HashMap;
import java.util.Map;

public class ClientMagicData {
    private static IMagicLevel level = VoidMagicLevel.NONE;
    private static Map<String, Boolean> learnedSkills = new HashMap<>();

    public static IMagicLevel getMagicLevel() {
        return level;
    }

    public static void update(MagicData data) {
        ClientMagicData.level = data.getLevel();
        ClientMagicData.learnedSkills = data.getLearned();
    }
}

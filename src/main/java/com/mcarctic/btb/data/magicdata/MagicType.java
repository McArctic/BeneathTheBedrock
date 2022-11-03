package com.mcarctic.btb.data.magicdata;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.magicdata.model.IMagicLevel;
import com.mcarctic.btb.data.magicdata.model.IMagicType;

import java.util.HashMap;
import java.util.Map;

public enum MagicType implements IMagicType {
    VOIDLING,
    GODLING;

    private final Map<Integer, IMagicLevel> levels = new HashMap<>();

    @Override
    public boolean is(IMagicType type) {
        return this == type;
    }

    @Override
    public String identifier() {
        return BeneathTheBedrock.MOD_ID + ":" + name();
    }

    @Override
    public void addMagicLevel(IMagicLevel level) {
        levels.put(level.getLevel(), level);
    }

    @Override
    public IMagicLevel getLevel(int level) {
        return levels.getOrDefault(level, null);
    }
}

package com.mcarctic.btb.data.magicdata.model;

public interface IMagicType {
    boolean is(IMagicType type);

    String identifier();

    void addMagicLevel(IMagicLevel level);

    IMagicLevel getLevel(int level);
}

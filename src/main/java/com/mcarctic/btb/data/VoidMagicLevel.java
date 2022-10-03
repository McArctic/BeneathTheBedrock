package com.mcarctic.btb.data;

public enum VoidMagicLevel {


    CHEAT(Integer.MAX_VALUE, null),
    CORRUPTED(1, null),
    NONE(0, CORRUPTED),
    ;

    private final int level;
    private final VoidMagicLevel levelAbove;

    VoidMagicLevel(int level, VoidMagicLevel levelAbove) {
        this.level = level;
        this.levelAbove = levelAbove == null ? this : levelAbove;
    }

    public VoidMagicLevel getLevelAbove() {
        return levelAbove;
    }

    public int getLevel() {
        return level;
    }
}

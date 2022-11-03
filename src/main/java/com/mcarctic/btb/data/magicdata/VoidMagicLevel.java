package com.mcarctic.btb.data.magicdata;

import com.mcarctic.btb.data.magicdata.model.IMagicLevel;
import com.mcarctic.btb.data.magicdata.model.IMagicType;

import java.util.HashSet;
import java.util.Set;

public enum VoidMagicLevel implements IMagicLevel {


    CHEAT(-1, null),
    CORRUPTED(1, null),
    NONE(0, CORRUPTED),
    ;

    private final Set<MagicSkill> skills = new HashSet<>();
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

    @Override
    public IMagicType getType() {
        return MagicType.VOIDLING;
    }

    @Override
    public Set<MagicSkill> getSkills() {
        return Set.copyOf(skills);
    }

    @Override
    public void addSkill(MagicSkill skill) {
        if (isCheat()) {
            throw new RuntimeException("Cheatlevels shouldnt have skills");
        }
        skills.add(skill);
    }
}

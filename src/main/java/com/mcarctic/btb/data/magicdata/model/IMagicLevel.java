package com.mcarctic.btb.data.magicdata.model;

import com.mcarctic.btb.data.magicdata.MagicSkill;

import java.util.Set;

public interface IMagicLevel {

    int getLevel();

    IMagicType getType();

    Set<MagicSkill> getSkills();

    void addSkill(MagicSkill skill);

    default boolean isCheat() {
        return getLevel() <= -1;
    }
}

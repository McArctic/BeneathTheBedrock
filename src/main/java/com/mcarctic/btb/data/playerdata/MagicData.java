package com.mcarctic.btb.data.playerdata;

import com.mcarctic.btb.data.magicdata.CommonMagicData;
import com.mcarctic.btb.data.magicdata.VoidMagicLevel;
import com.mcarctic.btb.data.magicdata.model.IMagicLevel;
import com.mcarctic.btb.networking.BTBNetworkMessages;
import com.mcarctic.btb.networking.sync.MagicDataSyncS2CPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MagicData {

    private final Map<String, Boolean> learnedSkills = new HashMap<>();
    private IMagicLevel level = VoidMagicLevel.NONE;

    public IMagicLevel getLevel() {
        return level;
    }

    public void setLevel(IMagicLevel level) {
        this.level = level;
    }

    public void copyFrom(MagicData sourcce) {
        this.level = sourcce.level;
    }

    public Map<String, Boolean> getLearned() {
        return Map.copyOf(learnedSkills);
    }

    public Set<String> getUnlocked() {
        return learnedSkills.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public void learn(String skillID) {
        learnedSkills.put(skillID, false);
    }

    public void unlock(String skillID) {
        if (learnedSkills.containsKey(skillID)) {
            learnedSkills.put(skillID, true);
        }
    }

    public void saveNBTData(CompoundTag nbt) {
        var level = new CompoundTag();
        level.putString("type", this.level.getType().identifier());
        level.putInt("level", this.level.getLevel());
        nbt.put("level", level);
        var learned = new CompoundTag();
        for (var skill : learnedSkills.keySet()) {
            learned.putBoolean(skill, learnedSkills.get(skill));
        }
        nbt.put("skills", learned);
    }

    public void loadNBTData(CompoundTag nbt) {
        var levelTag = nbt.getCompound("level");
        level = CommonMagicData.getTypeFromIdentifier(levelTag.getString("type")).getLevel(levelTag.getInt("level"));
        var skills = nbt.getCompound("skills");
        for (var skill : skills.getAllKeys()) {
            learnedSkills.put(skill, skills.getBoolean(skill));
        }
    }

    public void update(ServerPlayer player) {
        BTBNetworkMessages.sendToPlayer(new MagicDataSyncS2CPacket(this), player);
    }
}

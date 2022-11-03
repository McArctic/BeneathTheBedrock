package com.mcarctic.btb.data.magicdata;

import com.mcarctic.btb.data.magicdata.model.IMagicType;
import com.mcarctic.btb.registry.BTBSkills;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;
import java.util.Map;

public class CommonMagicData {
    private static final Map<String, IMagicType> types = new HashMap<>();

    public static void setup(FMLCommonSetupEvent event) {
        for (var skill : BTBSkills.REGISTRY.get().getValues()) {
            var level = skill.getLevel();
            var type = level.getType();
            types.put(type.identifier(), type);
            type.addMagicLevel(level);
            level.addSkill(skill);
        }
    }

    public static IMagicType getTypeFromIdentifier(String identifier) {
        return types.getOrDefault(identifier, null);
    }
}

package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.magicdata.MagicSkill;
import com.mcarctic.btb.data.magicdata.VoidMagicLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BTBSkills {
    private static final DeferredRegister<MagicSkill> SKILLS = DeferredRegister.create(new ResourceLocation(BeneathTheBedrock.MOD_ID, "skills"), BeneathTheBedrock.MOD_ID);

    public static final RegistryObject<MagicSkill> TEST1 = register("test1", () -> new MagicSkill(VoidMagicLevel.NONE, 500, 300));
    public static final RegistryObject<MagicSkill> TEST2 = register("test2", () -> new MagicSkill(VoidMagicLevel.CORRUPTED, 500, 300));
    public static final RegistryObject<MagicSkill> TEST3 = register("test3", () -> new MagicSkill(VoidMagicLevel.CHEAT, 500, 300));
    public static final Supplier<IForgeRegistry<MagicSkill>> REGISTRY = SKILLS.makeRegistry(MagicSkill.class, RegistryBuilder::new);

    private static RegistryObject<MagicSkill> register(String name, Supplier<MagicSkill> skill) {
        return SKILLS.register(name, skill);
    }

    public static void register(IEventBus eventBus) {
        SKILLS.register(eventBus);
    }
}
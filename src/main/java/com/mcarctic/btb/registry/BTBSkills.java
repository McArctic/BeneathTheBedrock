package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.magicdata.MagicSkill;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public class BTBSkills {
    private static final DeferredRegister<MagicSkill> SKILLS = DeferredRegister.create(new ResourceLocation(BeneathTheBedrock.MOD_ID, "skills"), BeneathTheBedrock.MOD_ID);

    public static final Supplier<IForgeRegistry<MagicSkill>> REGISTRY = SKILLS.makeRegistry(MagicSkill.class, RegistryBuilder::new);

    public static void register(IEventBus eventBus) {
        SKILLS.register(eventBus);
    }
}
package com.mcarctic.btb.enchantment;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.enchantment.enchantments.VoidVisionEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS
            = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BeneathTheBedrock.MOD_ID);

    public static RegistryObject<Enchantment> VOID_VISION =
            ENCHANTMENTS.register("void_vision", () -> new VoidVisionEnchantment(
                    Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, EquipmentSlot.HEAD));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
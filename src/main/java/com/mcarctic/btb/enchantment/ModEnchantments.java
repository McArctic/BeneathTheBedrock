package com.mcarctic.btb.enchantment;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.enchantment.enchantments.VoidVisionEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS
            = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BeneathTheBedrock.MOD_ID);

    public static RegistryObject<Enchantment> VOID_VISION =
            ENCHANTMENTS.register("void_vision", () -> new VoidVisionEnchantment(
                    Enchantment.Rarity.UNCOMMON, EnchantmentType.ARMOR, EquipmentSlotType.HEAD ));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
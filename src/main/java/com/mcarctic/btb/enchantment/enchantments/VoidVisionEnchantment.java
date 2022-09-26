package com.mcarctic.btb.enchantment.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class VoidVisionEnchantment extends Enchantment {
    public VoidVisionEnchantment(Rarity p_i46731_1_, EnchantmentCategory p_i46731_2_, EquipmentSlot... p_i46731_3_) {
        super(p_i46731_1_, p_i46731_2_, p_i46731_3_);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }


}

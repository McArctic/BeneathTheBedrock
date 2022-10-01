package com.mcarctic.btb.datagen.loot;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class BTBChestLootTables extends ChestLoot {

    private static final ResourceLocation CUSTOM_CHEST_LOOT
            = new ResourceLocation(BeneathTheBedrock.MOD_ID, "chests/custom_chest_loot");

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> builder) {
    }

}

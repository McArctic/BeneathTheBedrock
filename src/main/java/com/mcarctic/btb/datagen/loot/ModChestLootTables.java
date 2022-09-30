package com.mcarctic.btb.datagen.loot;

import net.minecraft.data.loot.ChestLoot;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ConfiguredStructureTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.zytorx.forgelearning.ForgeLearning;

import java.util.function.BiConsumer;

public class ModChestLootTables extends ChestLoot {

    private static final ResourceLocation CUSTOM_CHEST_LOOT
            = new ResourceLocation(ForgeLearning.MOD_ID, "chests/custom_chest_loot");

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> builder) {
        builder.accept(CUSTOM_CHEST_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(2.0F, 8.0F))
                        .add(LootItem.lootTableItem(Items.COAL)
                                .setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                                .setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.EMERALD))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.GOLDEN_APPLE))
                        .add(LootItem.lootTableItem(Items.BOOK)
                                .setWeight(5)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                        .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE))
                        .add(LootItem.lootTableItem(Items.GOLDEN_HELMET))
                        .add(LootItem.lootTableItem(Items.FISHING_ROD)
                                .setWeight(5)
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                        .add(LootItem.lootTableItem(Items.MAP)
                                .setWeight(10)
                                .apply(ExplorationMapFunction.makeExplorationMap()
                                        .setDestination(ConfiguredStructureTags.ON_TREASURE_MAPS)
                                        .setMapDecoration(MapDecoration.Type.RED_X)
                                        .setZoom((byte) 1)
                                        .setSkipKnownStructures(false))
                                .apply(SetNameFunction
                                        .setName(new TranslatableComponent("filled_map.buried_treasure"))))));
    }

}

package com.mcarctic.btb.datagen.loot;

import net.zytorx.forgelearning.block.ModBlocks;
import net.zytorx.forgelearning.item.ModItems;
import net.zytorx.library.datagen.loot.ZytorxBlockLoot;
import net.zytorx.library.registry.Registrar;

public class ModBlockLootTables extends ZytorxBlockLoot {


    public ModBlockLootTables(Registrar registrar) {
        super(registrar, ModBlocks.class);
    }

    @Override
    protected void addBlockTables() {
        createOreDrop(ModBlocks.CITRINE_ORE.getBlock(), ModItems.RAW_CITRINE.getItem(), 1, 2);
        createOreDrop(ModBlocks.DEEPSLATE_CITRINE_ORE.getBlock(), ModItems.RAW_CITRINE.getItem(), 1, 2);
        createOreDrop(ModBlocks.NETHER_CITRINE_ORE.getBlock(), ModItems.RAW_CITRINE.getItem(), 1, 2);
        createOreDrop(ModBlocks.END_CITRINE_ORE.getBlock(), ModItems.RAW_CITRINE.getItem(), 1, 3);
    }
}

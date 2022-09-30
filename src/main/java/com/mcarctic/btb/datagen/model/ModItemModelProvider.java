package com.mcarctic.btb.datagen.model;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.forgelearning.ForgeLearning;
import net.zytorx.forgelearning.block.ModBlocks;
import net.zytorx.forgelearning.item.ModItems;
import net.zytorx.library.datagen.model.ZytorxItemModelProvider;

public class ModItemModelProvider extends ZytorxItemModelProvider {

    public ModItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ForgeLearning.MOD_ID, exFileHelper, ModBlocks.class, ModItems.class);
    }

    @Override
    protected void addItemModels() {

    }
}

package com.mcarctic.btb.datagen.model;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.forgelearning.ForgeLearning;
import net.zytorx.forgelearning.block.ModBlocks;
import net.zytorx.library.datagen.model.ZytorxBlockStateProvider;

public class ModBlockModelProvider extends ZytorxBlockStateProvider {

    public ModBlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ForgeLearning.MOD_ID, exFileHelper, ModBlocks.class);
    }

    @Override
    protected void addStatesAndModels() {

    }
}

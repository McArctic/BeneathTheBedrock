package com.mcarctic.btb.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.forgelearning.ForgeLearning;
import net.zytorx.forgelearning.block.ModBlocks;
import net.zytorx.forgelearning.util.ModTags;
import net.zytorx.library.datagen.tags.ZytorxBlockTagsProvider;

public class ModBlockTagsProvider extends ZytorxBlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ForgeLearning.MOD_ID, exFileHelper, ModBlocks.class);
    }

    @Override
    protected void addCustomTags() {
        this.tag(ModTags.Blocks.DOWSING_ROD_VALUABLES).addTags(Tags.Blocks.ORES);
    }
}

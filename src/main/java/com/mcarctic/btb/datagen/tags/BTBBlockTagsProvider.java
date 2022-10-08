package com.mcarctic.btb.datagen.tags;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.tags.BTBBlockTags;
import com.mcarctic.btb.registry.BTBBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.library.datagen.tags.ZytorxBlockTagsProvider;

public class BTBBlockTagsProvider extends ZytorxBlockTagsProvider {
    public BTBBlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BeneathTheBedrock.MOD_ID, exFileHelper);
    }

    @Override
    protected void addCustomTags() {
        tag(BTBBlockTags.NON_CORRUPTIBLES).add(Blocks.AIR, Blocks.BEDROCK, Blocks.WATER, Blocks.VOID_AIR, Blocks.CAVE_AIR, Blocks.LAVA, Blocks.BUBBLE_COLUMN, Blocks.BARRIER, BTBBlocks.DESTABILIZER.getBlock(), BTBBlocks.VOID_FABRIC.getBlock(), BTBBlocks.VOID_FABRIC_NONSPREADABLE.getBlock());
    }
}

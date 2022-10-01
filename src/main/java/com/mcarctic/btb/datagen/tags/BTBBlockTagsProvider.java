package com.mcarctic.btb.datagen.tags;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.library.datagen.tags.ZytorxBlockTagsProvider;

public class BTBBlockTagsProvider extends ZytorxBlockTagsProvider {
    public BTBBlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BeneathTheBedrock.MOD_ID, exFileHelper);
    }

    @Override
    protected void addCustomTags() {
    }
}

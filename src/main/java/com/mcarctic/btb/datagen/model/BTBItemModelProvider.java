package com.mcarctic.btb.datagen.model;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.library.datagen.model.ZytorxItemModelProvider;

public class BTBItemModelProvider extends ZytorxItemModelProvider {

    public BTBItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BeneathTheBedrock.MOD_ID, exFileHelper);
    }

    @Override
    protected void addItemModels() {

    }
}

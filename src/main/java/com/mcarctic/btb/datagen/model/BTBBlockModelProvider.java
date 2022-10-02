package com.mcarctic.btb.datagen.model;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.library.datagen.model.ZytorxBlockStateProvider;
import net.zytorx.library.datagen.model.ZytorxTextureEnsurer;

public class BTBBlockModelProvider extends ZytorxBlockStateProvider {

    public BTBBlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper, ZytorxTextureEnsurer textureEnsurer) {
        super(gen, BeneathTheBedrock.MOD_ID, exFileHelper, textureEnsurer);
    }

    @Override
    protected void addStatesAndModels() {

    }
}

package com.mcarctic.btb.datagen.lang;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.data.DataGenerator;
import net.zytorx.library.datagen.lang.ZytorxEnglishLanguageProvider;

public class BTBEnglishLanguageProvider extends ZytorxEnglishLanguageProvider {
    public BTBEnglishLanguageProvider(DataGenerator gen) {
        super(gen, BeneathTheBedrock.MOD_ID);
    }

    protected void addManualTranslations() {
    }
}

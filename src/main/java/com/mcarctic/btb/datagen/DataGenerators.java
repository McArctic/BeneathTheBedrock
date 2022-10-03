package com.mcarctic.btb.datagen;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.datagen.lang.BTBEnglishLanguageProvider;
import com.mcarctic.btb.datagen.loot.BTBLootTablesProvider;
import com.mcarctic.btb.datagen.model.BTBBlockModelProvider;
import com.mcarctic.btb.datagen.model.BTBItemModelProvider;
import com.mcarctic.btb.datagen.recipes.BTBRecipeProvider;
import com.mcarctic.btb.datagen.tags.BTBBlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.zytorx.library.datagen.model.ZytorxTextureEnsurer;

@Mod.EventBusSubscriber(modid = BeneathTheBedrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new BTBRecipeProvider(generator));
        generator.addProvider(new BTBLootTablesProvider(generator));
        generator.addProvider(new BTBEnglishLanguageProvider(generator));

        generator.addProvider(new BTBBlockTagsProvider(generator, existingFileHelper));
        var textureEnsurer = new ZytorxTextureEnsurer(generator, existingFileHelper);
        generator.addProvider(new BTBBlockModelProvider(generator, existingFileHelper, textureEnsurer));
        generator.addProvider(new BTBItemModelProvider(generator, existingFileHelper, textureEnsurer));

    }
}

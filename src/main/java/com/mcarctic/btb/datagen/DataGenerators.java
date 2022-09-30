package com.mcarctic.btb.datagen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.zytorx.forgelearning.ForgeLearning;
import net.zytorx.forgelearning.datagen.lang.ModEnglishLanguageProvider;
import net.zytorx.forgelearning.datagen.loot.ModLootTablesProvider;
import net.zytorx.forgelearning.datagen.model.ModBlockModelProvider;
import net.zytorx.forgelearning.datagen.model.ModItemModelProvider;
import net.zytorx.forgelearning.datagen.recipes.ModRecipeProvider;
import net.zytorx.forgelearning.datagen.tags.ModBlockTagsProvider;

@Mod.EventBusSubscriber(modid = ForgeLearning.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ModRecipeProvider(generator));
        generator.addProvider(new ModLootTablesProvider(generator));
        generator.addProvider(new ModEnglishLanguageProvider(generator));

        generator.addProvider(new ModBlockModelProvider(generator, existingFileHelper));
        generator.addProvider(new ModBlockTagsProvider(generator, existingFileHelper));
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));


    }
}

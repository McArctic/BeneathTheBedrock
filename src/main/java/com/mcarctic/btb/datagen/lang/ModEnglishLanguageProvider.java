package com.mcarctic.btb.datagen.lang;

import net.minecraft.data.DataGenerator;
import net.zytorx.forgelearning.ForgeLearning;
import net.zytorx.forgelearning.block.ModBlocks;
import net.zytorx.forgelearning.item.ModItems;
import net.zytorx.library.datagen.lang.ZytorxEnglishLanguageProvider;

public class ModEnglishLanguageProvider extends ZytorxEnglishLanguageProvider {
    public ModEnglishLanguageProvider(DataGenerator gen) {
        super(gen, ForgeLearning.MOD_ID, ModBlocks.class, ModItems.class);
    }

    protected void addManualTranslations() {
        add("itemGroup.forgelearningtab", "Learning Tab");
        add("item.forgelearning.dowsing_rod.valuables", "Found %1$s at (%2$s, %3$s, %4$s)");
        add("item.forgelearning.dowsing_rod.no_valuables", "No Valuables Found!");
        add("tooltip.forgelearning.dowsing_rod.tooltip", "[Press §eShift§r for more Information]");
        add("tooltip.forgelearning.dowsing_rod.tooltip.shift", "Right-click on block to find valuables below");
        add("tooltip.forgelearning.speedy_block.tooltip", "[Press §eShift§r for more Information]");
        add("tooltip.forgelearning.speedy_block.tooltip.shift", "Gives you a speed boost for a short time");
    }
}

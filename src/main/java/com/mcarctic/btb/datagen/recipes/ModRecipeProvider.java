package com.mcarctic.btb.datagen.recipes;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.zytorx.forgelearning.ForgeLearning;
import net.zytorx.forgelearning.block.ModBlocks;
import net.zytorx.forgelearning.item.ModItems;
import net.zytorx.library.datagen.recipes.ZytorxRecipeProvider;

import java.util.function.Consumer;

public class ModRecipeProvider extends ZytorxRecipeProvider {

    private static final ImmutableList<ItemLike> CITRINE_SMELTABLES = ImmutableList.of(
            ModItems.RAW_CITRINE, ModBlocks.CITRINE_ORE, ModBlocks.END_CITRINE_ORE,
            ModBlocks.NETHER_CITRINE_ORE, ModBlocks.DEEPSLATE_CITRINE_ORE);

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator, ForgeLearning.MOD_ID, ModBlocks.class, ModItems.class);
    }

    @Override
    protected void createCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        nineBlockStorageRecipe(consumer, ModItems.CITRINE, ModBlocks.CITRINE_BLOCK.getStandardBlock());
        nineBlockStorageRecipe(consumer, ModItems.RAW_CITRINE, ModBlocks.RAW_CITRINE_BLOCK);
        oreSmeltingAndBlasting(consumer, CITRINE_SMELTABLES, ModItems.CITRINE, 1.0f, 200, "citrine");
        oreSmeltingAndBlasting(consumer, Tags.Items.BONES, ModItems.CITRINE, 1.0f, 200, "citrine");
    }
}


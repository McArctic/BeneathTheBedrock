package com.mcarctic.btb.datagen.recipes;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.zytorx.library.datagen.recipes.ZytorxRecipeProvider;

import java.util.function.Consumer;

public class BTBRecipeProvider extends ZytorxRecipeProvider {

    public BTBRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator, BeneathTheBedrock.MOD_ID);
    }

    @Override
    protected void createCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    }
}


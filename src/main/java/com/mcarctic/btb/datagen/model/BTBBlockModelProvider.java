package com.mcarctic.btb.datagen.model;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.custom.TieredVoidBlock;
import com.mcarctic.btb.registry.BTBBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zytorx.library.datagen.model.ZytorxBlockStateProvider;
import net.zytorx.library.datagen.model.ZytorxTextureEnsurer;
import net.zytorx.library.registry.RegisteredBlock;

public class BTBBlockModelProvider extends ZytorxBlockStateProvider {

    private static final ResourceLocation tieredParent = blockTexture(BeneathTheBedrock.MOD_ID, "parents/tiered");

    public BTBBlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper, ZytorxTextureEnsurer textureEnsurer) {
        super(gen, BeneathTheBedrock.MOD_ID, exFileHelper, textureEnsurer);
    }

    @Override
    protected void addStatesAndModels() {
        registerTieredBlocks();
    }

    private void registerTieredBlocks() {
        for (var field : BTBBlocks.class.getDeclaredFields()) {
            try {
                if (field.canAccess(null) && field.get(null) instanceof RegisteredBlock registered) {
                    if (registered.getBlock() instanceof TieredVoidBlock) {
                        tieredBlockAndItem(registered.getBlock());
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void tieredBlockAndItem(Block block) {
        var model = this.models().withExistingParent(name(block), tieredParent);
        simpleBlock(block, model);
        simpleBlockItem(block, model);
        blockTexture(block);
    }
}

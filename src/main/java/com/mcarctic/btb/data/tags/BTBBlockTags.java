package com.mcarctic.btb.data.tags;

import com.mcarctic.btb.BeneathTheBedrock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BTBBlockTags {

    public static final TagKey<Block> NON_CORRUPTIBLES
            = tag("non_corruptibles");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(BeneathTheBedrock.MOD_ID, name));
    }

    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }
}

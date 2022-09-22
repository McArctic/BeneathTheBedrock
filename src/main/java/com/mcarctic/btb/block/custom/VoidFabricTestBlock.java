package com.mcarctic.btb.block.custom;



import com.mcarctic.btb.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class VoidFabricTestBlock extends Block {
    public VoidFabricTestBlock() {
        super(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BLACK)
                .tickRandomly()
                .hardnessAndResistance(5f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .hardnessAndResistance(5f)
                .sound(SoundType.CLOTH));
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (true)
        {
            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (!worldIn.getBlockState(blockpos).matchesBlock(Blocks.AIR) && !worldIn.getBlockState(blockpos).matchesBlock(Blocks.BEDROCK) && !worldIn.getBlockState(blockpos).matchesBlock(ModBlocks.VOID_FABRIC_TEST.get())) {
                    worldIn.setBlockState(blockpos, ModBlocks.VOID_FABRIC_TEST.get().getDefaultState());
                }
                else {
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
        } /* else {
            if (worldIn.getLight(pos.up()) >= 0) {
                BlockState blockstate = this.getDefaultState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).matchesBlock(Blocks.DIRT)) {
                        worldIn.setBlockState(blockpos, blockstate.with(BlockStateProperties.SNOWY, Boolean.valueOf(worldIn.getBlockState(blockpos.up()).matchesBlock(Blocks.SNOW))));
                    }
                }
            }

        }
        */
    }

}
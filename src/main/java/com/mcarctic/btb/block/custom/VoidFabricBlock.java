package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.List;
import java.util.Random;

public class VoidFabricBlock extends SpreadableSnowyDirtBlock {
    public VoidFabricBlock() {
        super(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BLACK).hardnessAndResistance(5f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .hardnessAndResistance(5f)
                .sound(SoundType.CLOTH));
    }
  /*  public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isRemote) {
            if (!worldIn.isAreaLoaded(pos, 2)) return;
            if (worldIn.getLight(pos.up()) < 1 ){

                worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState().hasProperty(Block.)
            }

        }
    } */
}

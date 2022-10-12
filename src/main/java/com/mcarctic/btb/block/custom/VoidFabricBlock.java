package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.data.tags.BTBBlockTags;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VoidFabricBlock extends Block {
    private static final List<Direction> directions = Arrays.asList(Direction.WEST, Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.DOWN, Direction.UP);

    public VoidFabricBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .randomTicks()
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
    }

    private static boolean isReplaceable(BlockState state) {
        return !state.is(BTBBlockTags.NON_CORRUPTIBLES);
    }

    private static boolean isVoidDimension(Level world) {
        return world.dimension() == BTBDimensions.VOID;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (isVoidDimension(worldIn.getLevel())) {
            worldIn.setBlockAndUpdate(pos, BTBBlocks.VOID_FABRIC_NONSPREADABLE.getBlock().defaultBlockState());
            return;
        }
        if (!worldIn.isAreaLoaded(pos, 3)) {
            return;
        }

        for (Direction direction : directions) {
            BlockPos blockPos = pos.relative(direction);

            if (isReplaceable(worldIn.getBlockState(blockPos))) {
                worldIn.setBlockAndUpdate(blockPos, BTBBlocks.VOID_FABRIC.getBlock().defaultBlockState());
                return;
            }
        }

        //worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}


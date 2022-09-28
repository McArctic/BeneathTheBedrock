package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VoidFabricBlock extends Block {
    private static final List<Direction> directions = Arrays.asList(Direction.WEST, Direction.UP, Direction.SOUTH, Direction.EAST, Direction.DOWN, Direction.NORTH);

    public VoidFabricBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .randomTicks()
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
    }

    private static boolean isReplaceable(BlockState state) {
        return !state.is(Blocks.AIR) &&
                !state.is(Blocks.BEDROCK) &&
                !state.is(ModBlocks.VOID_FABRIC.get()) &&
                !state.is(Blocks.WATER) &&
                !state.is(Blocks.VOID_AIR) &&
                !state.is(Blocks.CAVE_AIR) &&
                !state.is(Blocks.WATER) &&
                !state.is(Blocks.LAVA);
    }

    private static boolean isVoidDimesnion(Level world) {
        return !(world.dimension() == Level.NETHER);

    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (!isVoidDimesnion(worldIn.getLevel())) {
            return;
        }
        if (!worldIn.isAreaLoaded(pos, 3)) {
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
        }

        for (Direction direction : directions) {
            BlockPos blockPos = pos.relative(direction);

            if (isReplaceable(worldIn.getBlockState(blockPos))) {
                worldIn.setBlockAndUpdate(blockPos, ModBlocks.VOID_FABRIC.get().defaultBlockState());
                return;
            }
        }

        //worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}


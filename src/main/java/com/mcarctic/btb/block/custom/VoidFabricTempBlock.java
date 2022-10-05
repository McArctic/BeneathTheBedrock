package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.block.entity.VoidFabricBlockEntity;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VoidFabricTempBlock extends BaseEntityBlock {
    private static final List<Direction> directions = Arrays.asList(Direction.WEST, Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.DOWN, Direction.UP);

    public VoidFabricTempBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
    }


    private static boolean isReplaceable(BlockState state) {
        return !state.is(Blocks.AIR) &&
                !state.is(Blocks.BEDROCK) &&
                !state.is(BTBBlocks.VOID_FABRIC.getBlock()) &&
                !state.is(BTBBlocks.VOID_FABRIC_NONSPREADABLE.getBlock()) &&
                !state.is(BTBBlocks.VOID_FABRIC_TEMP.getBlock()) &&
                !state.is(Blocks.WATER) &&
                !state.is(Blocks.VOID_AIR) &&
                !state.is(Blocks.CAVE_AIR) &&
                !state.is(Blocks.WATER) &&
                !state.is(Blocks.LAVA);
    }

    private static boolean isVoidDimesnion(Level world) {
        return world.dimension() == BTBDimensions.VOID;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if (isVoidDimesnion(worldIn.getLevel())) {
            worldIn.setBlockAndUpdate(pos, BTBBlocks.VOID_FABRIC_NONSPREADABLE.getBlock().defaultBlockState());
            return;
        }
        if (!worldIn.isAreaLoaded(pos, 3)) {
            return;
        }
        for (Direction direction : directions) {
            BlockPos blockPos = pos.relative(direction);

            BlockState formerState = worldIn.getBlockState(blockPos);
            if (isReplaceable(formerState)) {
                worldIn.setBlockAndUpdate(blockPos, BTBBlocks.VOID_FABRIC_TEMP.getBlock().defaultBlockState());
                if (worldIn.getBlockEntity(blockPos) instanceof VoidFabricBlockEntity entity) {
                    entity.setFormerState(formerState);
                }
                return;
            }
        }

    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new VoidFabricBlockEntity(pPos, pState);
    }

}

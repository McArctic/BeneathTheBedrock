package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.data.chunkdata.CorruptedChunkProvider;
import com.mcarctic.btb.data.tags.BTBBlockTags;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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

public class VoidFabricTempBlock extends Block {
    private static final List<Direction> directions = Arrays.asList(Direction.WEST, Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.DOWN, Direction.UP);
    private boolean reverse = false;

    public VoidFabricTempBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .randomTicks()
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
    }

    private static boolean isReplaceable(BlockState state) {
        return !state.is(BTBBlockTags.NON_CORRUPTIBLES) && !state.is(BTBBlocks.VOID_FABRIC_TEMP.getBlock());
    }

    private static boolean isVoidDimension(Level world) {
        return world.dimension() == BTBDimensions.VOID;
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        reverse = !reverse;
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
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

        if (reverse) {
            worldIn.getChunkAt(pos).getCapability(CorruptedChunkProvider.CORRUPTED_CHUNK).ifPresent(cap -> {
                var former = cap.getAndRemoveFormerState(pos);
                worldIn.setBlockAndUpdate(pos, former);
            });
            return;
        }

        for (Direction direction : directions) {
            BlockPos blockPos = pos.relative(direction);

            BlockState formerState = worldIn.getBlockState(blockPos);
            if (isReplaceable(formerState)) {
                worldIn.getChunkAt(blockPos).getCapability(CorruptedChunkProvider.CORRUPTED_CHUNK).ifPresent(cap -> {
                    cap.addFormerState(blockPos, formerState);
                });

                var chunk = worldIn.getChunkAt(blockPos);

                worldIn.setBlockAndUpdate(blockPos, BTBBlocks.VOID_FABRIC_TEMP.getBlock().defaultBlockState());
                return;
            }
        }

    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}

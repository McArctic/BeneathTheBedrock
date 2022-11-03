package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.data.chunkdata.CorruptedChunkProvider;
import com.mcarctic.btb.data.tags.BTBBlockTags;
import com.mcarctic.btb.entity.custom.projectiles.UncorruptProjectile;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

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

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
    }

    @Override
    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        if (pLevel.isClientSide()) {
            return;
        }

        if (pProjectile instanceof UncorruptProjectile) {
            cure(pLevel, pHit.getBlockPos());
        }
    }

    public void cure(Level level, BlockPos pos) {
        if (level.getBlockState(pos).is(this)) {
            level.getChunkAt(pos).getCapability(CorruptedChunkProvider.CORRUPTED_CHUNK).ifPresent(cap -> {
                level.setBlockAndUpdate(pos, cap.getAndRemoveFormerState(pos));
            });
        }
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

        var chunk = worldIn.getChunkAt(pos).getCapability(CorruptedChunkProvider.CORRUPTED_CHUNK).orElseThrow(RuntimeException::new);
        if (chunk.isCleaned()) {
            cure(worldIn, pos);
            return;
        }

        for (Direction direction : directions) {
            BlockPos blockPos = pos.relative(direction);

            var cap = worldIn.getChunkAt(blockPos).getCapability(CorruptedChunkProvider.CORRUPTED_CHUNK).orElseThrow(RuntimeException::new);
            BlockState formerState = worldIn.getBlockState(blockPos);
            if (!cap.isNoSpread() && isReplaceable(formerState)) {

                cap.addFormerState(blockPos, formerState);

                worldIn.setBlockAndUpdate(blockPos, BTBBlocks.VOID_FABRIC.getBlock().defaultBlockState());
                return;
            }
        }
    }

    private static boolean isReplaceable(BlockState state) {
        return !state.is(BTBBlockTags.NON_CORRUPTIBLES) && state.getBlock().getFluidState(state).isEmpty();
    }

    private static boolean isVoidDimension(Level world) {
        return world.dimension() == BTBDimensions.VOID;
    }
}

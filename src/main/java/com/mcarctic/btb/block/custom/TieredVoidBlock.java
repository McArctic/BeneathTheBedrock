package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.block.BTBBlocks;
import com.mcarctic.btb.world.dimension.BTBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public class TieredVoidBlock extends Block {
    public TieredVoidBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .randomTicks()
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (pLevel.dimension() == BTBDimensions.VOID) {
            pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
            pPlayer.causeFoodExhaustion(0.005F);
            dropResources(pState, pLevel, pPos, pBlockEntity, pPlayer, pTool);
        } else {
            var voidFabric = BTBBlocks.VOID_FABRIC.get();
            voidFabric.playerDestroy(pLevel, pPlayer, pPos, voidFabric.defaultBlockState(), null, pTool);
        }
    }
}

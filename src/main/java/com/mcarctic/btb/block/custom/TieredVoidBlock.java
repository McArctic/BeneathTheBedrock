package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.data.magicdata.VoidMagicLevel;
import com.mcarctic.btb.data.playerdata.ClientMagicData;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mcarctic.btb.util.CapabilityHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
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

    private final VoidMagicLevel neededLevel;

    public TieredVoidBlock(VoidMagicLevel neededLevel) {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .randomTicks()
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
        this.neededLevel = neededLevel;
    }

    public boolean canPlayerSee() {
        var level = ClientMagicData.getMagicLevel();
        return level.getType().is(neededLevel.getType()) && (level.isCheat() || level.getLevel() >= neededLevel.getLevel());
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (pLevel.isClientSide()) {
            return;
        }
        var capability = CapabilityHelper.getMagicLevel((ServerPlayer) pPlayer);
        if (capability.getLevel() >= neededLevel.getLevel()) {
            pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
            pPlayer.causeFoodExhaustion(0.005F);
            dropResources(pState, pLevel, pPos, pBlockEntity, pPlayer, pTool);
        } else {
            var voidFabric = BTBBlocks.VOID_FABRIC.getBlock();
            voidFabric.playerDestroy(pLevel, pPlayer, pPos, voidFabric.defaultBlockState(), null, pTool);
        }

        if (capability == VoidMagicLevel.NONE) {
            CapabilityHelper.setMagicLevel((ServerPlayer) pPlayer, VoidMagicLevel.CORRUPTED);
        }
    }
}

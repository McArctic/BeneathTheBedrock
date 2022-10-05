package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.data.VoidMagicLevel;
import com.mcarctic.btb.data.playerdata.PlayerMagicLevelProvider;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.client.Minecraft;
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
        var optional = Minecraft.getInstance().player.getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).resolve();
        if (!optional.isPresent()) {
            return false;
        }
        return optional.get().getLevel().getLevel() >= neededLevel.getLevel();
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (pLevel.dimension() == BTBDimensions.VOID) {
            pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
            pPlayer.causeFoodExhaustion(0.005F);
            dropResources(pState, pLevel, pPos, pBlockEntity, pPlayer, pTool);
        } else {
            var voidFabric = BTBBlocks.VOID_FABRIC.getBlock();
            voidFabric.playerDestroy(pLevel, pPlayer, pPos, voidFabric.defaultBlockState(), null, pTool);
        }
    }
}

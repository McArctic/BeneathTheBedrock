package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.registry.BTBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class VoidFabricNonSpreadableBlock extends Block {
    public VoidFabricNonSpreadableBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(BTBBlocks.VOID_FABRIC);
    }
}

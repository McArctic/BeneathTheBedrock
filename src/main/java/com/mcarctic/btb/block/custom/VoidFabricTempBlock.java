package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.block.entity.VoidFabricBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

public class VoidFabricTempBlock extends BaseEntityBlock {

    public VoidFabricTempBlock() {
        super(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK)
                .requiresCorrectToolForDrops()
                .strength(5f)
                .sound(SoundType.WOOL));
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

package com.mcarctic.btb.block.entity;

import com.mcarctic.btb.registry.BTBBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VoidFabricBlockEntity extends BlockEntity {

    public VoidFabricBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BTBBlockEntities.VOID_FABRIC_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, VoidFabricBlockEntity pBlockEntity) {

    }
}


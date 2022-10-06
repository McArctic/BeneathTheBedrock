package com.mcarctic.btb.block.entity;

import com.mcarctic.btb.registry.BTBBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.INBTSerializable;

public class VoidFabricBlockEntity extends BlockEntity implements INBTSerializable<CompoundTag> {


    private BlockState state;

    public VoidFabricBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BTBBlockEntities.VOID_FABRIC_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    public BlockState getFormerState() {
        return state;
    }

    public void setFormerState(BlockState state) {
        this.state = state;
    }

    @Override
    public CompoundTag serializeNBT() {
        return NbtUtils.writeBlockState(state);
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        state = NbtUtils.readBlockState(nbt);
    }
}


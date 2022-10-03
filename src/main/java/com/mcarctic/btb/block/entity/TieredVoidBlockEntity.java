package com.mcarctic.btb.block.entity;

import com.mcarctic.btb.registry.BTBBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import org.jetbrains.annotations.NotNull;

public class TieredVoidBlockEntity extends BlockEntity {

    public TieredVoidBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BTBBlockEntities.VOID_FABRIC_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @NotNull
    @Override
    public IModelData getModelData() {
        return new ModelDataMap.Builder().build();
    }
}


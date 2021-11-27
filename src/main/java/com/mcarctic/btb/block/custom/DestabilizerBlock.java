package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.tileentity.ModTileEntities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;


public class DestabilizerBlock extends Block {
    public DestabilizerBlock() {
        super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(15f)
                .sound(SoundType.STONE)
                .notSolid());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.DESTABILIZER_TILE.get().create();
    }

    @Override
    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}

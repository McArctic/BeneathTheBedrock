package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.block.ModBlocks;
import com.mcarctic.btb.init.DimensionInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.List;
import java.util.Random;

public class VoidFabricBlock extends Block {
    public VoidFabricBlock() {
        super(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BLACK).hardnessAndResistance(5f)
                .tickRandomly()
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .hardnessAndResistance(5f)
                .sound(SoundType.CLOTH));
    }

    private static boolean isReplaceable(BlockState state) {
        return  !state.matchesBlock(Blocks.AIR) &&
                !state.matchesBlock(Blocks.BEDROCK) &&
                !state.matchesBlock(ModBlocks.VOID_FABRIC.get()) &&
                !state.matchesBlock(Blocks.WATER) &&
                !state.matchesBlock(Blocks.VOID_AIR) &&
                !state.matchesBlock(Blocks.CAVE_AIR) &&
                !state.matchesBlock(Blocks.WATER) &&
                !state.matchesBlock(Blocks.LAVA)
                ;
    }

    private static boolean isInVoidWorld(World world) {
        return !(world.getDimensionKey() == DimensionInit.VOID_WORLD);

    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (isInVoidWorld(worldIn.getWorld())) {
            if (!worldIn.isAreaLoaded(pos, 3))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (isReplaceable(worldIn.getBlockState(pos.up()))) {
                worldIn.setBlockState(pos.up(), ModBlocks.VOID_FABRIC.get().getDefaultState());
            } else if (isReplaceable(worldIn.getBlockState(pos.down()))) {
                worldIn.setBlockState(pos.down(), ModBlocks.VOID_FABRIC.get().getDefaultState());
            }
            else if (isReplaceable(worldIn.getBlockState(pos.north()))) {
                worldIn.setBlockState(pos.north(), ModBlocks.VOID_FABRIC.get().getDefaultState());
            }
            else if (isReplaceable(worldIn.getBlockState(pos.south()))) {
                worldIn.setBlockState(pos.south(), ModBlocks.VOID_FABRIC.get().getDefaultState());
            }
            else if (isReplaceable(worldIn.getBlockState(pos.east()))) {
                worldIn.setBlockState(pos.east(), ModBlocks.VOID_FABRIC.get().getDefaultState());
            }
            else if (isReplaceable(worldIn.getBlockState(pos.west()))) {
                worldIn.setBlockState(pos.west(), ModBlocks.VOID_FABRIC.get().getDefaultState());
            }
            else {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }



        }
    }

}


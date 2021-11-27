package com.mcarctic.btb.init;

import com.mcarctic.btb.block.ModBlocks;
import com.mcarctic.btb.block.custom.DestabilizerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class VoidTeleporter implements ITeleporter {

    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public VoidTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        double y = 61;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
        !destWorld.getBlockState(destinationPos).isReplaceable(Fluids.WATER) &&
        destWorld.getBlockState(destinationPos.up()).getMaterial() !=Material.AIR &&
        !destWorld.getBlockState(destinationPos.up()).isReplaceable(Fluids.WATER) && tries < 25) {

            destinationPos = destinationPos.up(2);
            tries++;
        }

        entity.setPositionAndUpdate(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if(insideDimension){
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.getAllInBoxMutable(destinationPos.down(10).west(10), destinationPos.up(10).east(10))) {
                if(destWorld.getBlockState(checkPos).getBlock() instanceof DestabilizerBlock){
                    doSetBlock = false;
                    break;
                }
            }
            if(doSetBlock){
                destWorld.setBlockState(destinationPos, ModBlocks.DESTABILIZER.get().getDefaultState());
            }
        }

        return entity;

        }
    }

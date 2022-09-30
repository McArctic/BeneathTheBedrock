package com.mcarctic.btb.init;

import com.mcarctic.btb.block.BTBBlocks;
import com.mcarctic.btb.block.custom.DestabilizerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class VoidTeleporter implements ITeleporter {

    public static BlockPos thisPos = BlockPos.ZERO;
    public static BlockPos lastPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public VoidTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {

        entity = repositionEntity.apply(false);
        double y = 61;
        if (lastPos != BlockPos.ZERO) {
            y = lastPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR &&
                !destWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25) {

            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.teleportTo(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof DestabilizerBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destWorld.setBlockAndUpdate(destinationPos, BTBBlocks.DESTABILIZER.get().defaultBlockState());
            }
        }


        lastPos = thisPos;
        System.out.println("LAST POS : " + lastPos);
        return entity;

    }
}

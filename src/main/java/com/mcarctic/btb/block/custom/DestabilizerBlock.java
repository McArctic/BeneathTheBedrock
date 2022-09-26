package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.init.DimensionInit;
import com.mcarctic.btb.init.VoidTeleporter;
import com.mcarctic.btb.tileentity.DestabilizerTile;
import com.mcarctic.btb.tileentity.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class DestabilizerBlock extends BaseEntityBlock {
    public DestabilizerBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                .strength(15f)
                .sound(SoundType.STONE)
                .noOcclusion());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public ModTileEntities createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.DESTABILIZER_TILE.get().create();
    }

    @Override
    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    //NEW STUFF

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == DimensionInit.VOID_WORLD) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        ServerWorld serverworld = ((ServerWorld)worldIn).getServer().getWorld(World.OVERWORLD);

                        if (overWorld != null) {
                            player.changeDimension(overWorld, new VoidTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld voidWorld = server.getWorld(DimensionInit.VOID_WORLD);
                        if (voidWorld != null) {
                            player.changeDimension(voidWorld, new VoidTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }


//SH0peigjsoigj;ldgjkf
/*
    @Override
    public ActionResultType onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity entity, Hand handIn, BlockRayTraceResult hit) {
        if (world instanceof ServerWorld && !entity.isPassenger() && !entity.isBeingRidden() && entity.canChangeDimension())
        {


            RegistryKey<World> registrykey = world.getDimensionKey() == World.THE_END ? World.OVERWORLD: World.THE_END;
            ServerWorld serverworld = ((ServerWorld)world).getServer().getWorld(World.OVERWORLD);
            if (serverworld == null) {
                return ActionResultType.FAIL;
            }

            entity.changeDimension(serverworld);
        }
        return ActionResultType.SUCCESS;

    }

 */


    //////////////////ddd




}





package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.init.DimensionInit;
import com.mcarctic.btb.init.VoidTeleporter;
import com.mcarctic.btb.tileentity.ModTileEntities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.command.CommandSource;
import net.minecraftforge.client.event.ClientChatEvent;

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

                     Minecraft.getInstance().player.sendChatMessage("Whats up twitch chat!");

                        if (overWorld != null) {
                            player.changeDimension(overWorld, new VoidTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld voidWorld = server.getWorld(DimensionInit.VOID_WORLD);
                        if (voidWorld != null) {
                            player.changeDimension(voidWorld, new VoidTeleporter(pos, true));
                            Minecraft.getInstance().player.sendChatMessage("Whats up twitch chat!");
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





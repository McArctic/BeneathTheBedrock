package com.mcarctic.btb.block.custom;

import com.mcarctic.btb.init.VoidTeleporter;
import com.mcarctic.btb.registry.BTBBlockEntities;
import com.mcarctic.btb.registry.BTBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class DestabilizerBlock extends BaseEntityBlock {

    public DestabilizerBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                .strength(15f)
                .sound(SoundType.STONE)
                .noOcclusion());
    }

    private static ServerLevel getDestinationLevel(MinecraftServer server, Level currentLevel) {
        var destination = currentLevel.dimension() == BTBDimensions.VOID ? Level.OVERWORLD : BTBDimensions.VOID;
        return server.getLevel(destination);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BTBBlockEntities.DESTABILIZER_BLOCK_ENTITY.get().create(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos,
                                 Player player, InteractionHand handIn, BlockHitResult hit) {
        if (worldIn.isClientSide() || player.isCrouching()) {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
        var server = worldIn.getServer();

        var destination = getDestinationLevel(server, worldIn);

        if (destination != null) {
            player.changeDimension(destination, new VoidTeleporter(pos, false));
        }

        return InteractionResult.SUCCESS;

    }
}





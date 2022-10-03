package com.mcarctic.btb.block.model;

import com.mcarctic.btb.block.custom.TieredVoidBlock;
import com.mcarctic.btb.registry.BTBBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class TieredVoidBlockBakedModel implements IDynamicBakedModel {

    private static final BlockState FALLBACK = BTBBlocks.VOID_FABRIC.getBlock().defaultBlockState();

    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand, @NotNull IModelData extraData) {
        var blockstate = state;
        if (!(state.getBlock() instanceof TieredVoidBlock tiered) || !tiered.canPlayerSee()) {
            blockstate = FALLBACK;
        }
        return getModel(blockstate).getQuads(blockstate, side, rand, null);
    }

    private BakedModel getModel(@Nonnull BlockState facadeState) {
        return Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getBlockModel(facadeState);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return null;
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }
}

package com.mcarctic.btb.block.model;

import com.mcarctic.btb.block.custom.TieredVoidBlock;
import com.mcarctic.btb.registry.BTBBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.pipeline.BakedQuadBuilder;
import net.minecraftforge.client.model.pipeline.IVertexConsumer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TieredVoidBlockBakedModel implements IDynamicBakedModel {

    private static final String ITEM_MARKER = "#inventory";
    private static final String BLOCK_MARKER = "block/";
    private static TextureAtlasSprite FALLBACK;
    private final ResourceLocation location;
    private final TieredVoidBlock block;
    private final ItemTransforms transforms;
    private TextureAtlasSprite texture;

    public TieredVoidBlockBakedModel(ResourceLocation location, ItemTransforms transforms) {

        location = new ResourceLocation(location.toString().split("#")[0]);

        if (!location.getPath().startsWith(BLOCK_MARKER)) {
            location = new ResourceLocation(location.getNamespace(), BLOCK_MARKER + location.getPath());
        }
        var blockLocation = new ResourceLocation(location.getNamespace(), location.getPath().replaceFirst(BLOCK_MARKER, ""));

        var holder = ForgeRegistries.BLOCKS.getHolder(blockLocation);
        this.block = (TieredVoidBlock) holder.get().value();
        this.location = location;
        this.transforms = transforms;
    }

    public static TextureAtlasSprite getTexture(ResourceLocation resource) {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(resource);
    }

    private static List<BakedQuad> getTextured(Direction side, TextureAtlasSprite texture) {
        List<BakedQuad> quads = new ArrayList<>();
        if (side != null) {
            switch (side) {
                case DOWN -> quads.add(createQuad(v(0, 0, 0), v(1, 0, 0), v(1, 0, 1), v(0, 0, 1), texture));
                case UP -> quads.add(createQuad(v(0, 1, 0), v(0, 1, 1), v(1, 1, 1), v(1, 1, 0), texture));
                case NORTH -> quads.add(createQuad(v(1, 1, 0), v(1, 0, 0), v(0, 0, 0), v(0, 1, 0), texture));
                case SOUTH -> quads.add(createQuad(v(0, 1, 1), v(0, 0, 1), v(1, 0, 1), v(1, 1, 1), texture));
                case WEST -> quads.add(createQuad(v(0, 1, 0), v(0, 0, 0), v(0, 0, 1), v(0, 1, 1), texture));
                case EAST -> quads.add(createQuad(v(1, 1, 1), v(1, 0, 1), v(1, 0, 0), v(1, 1, 0), texture));
            }
        } else {

        }
        return quads;
    }

    private static Vec3 v(double x, double y, double z) {
        return new Vec3(x, y, z);
    }

    private static BakedQuad createQuad(Vec3 v1, Vec3 v2, Vec3 v3, Vec3 v4, TextureAtlasSprite sprite) {
        Vec3 normal = v3.subtract(v2).cross(v1.subtract(v2)).normalize();
        BakedQuadBuilder builder = new BakedQuadBuilder(sprite);
        builder.setQuadOrientation(Direction.getNearest(normal.x, normal.y, normal.z));
        putVertex(builder, normal, v1.x, v1.y, v1.z, 0.0F, 0.0F, sprite);
        putVertex(builder, normal, v2.x, v2.y, v2.z, 0.0F, 16.0F, sprite);
        putVertex(builder, normal, v3.x, v3.y, v3.z, 16.0F, 16.0F, sprite);
        putVertex(builder, normal, v4.x, v4.y, v4.z, 16.0F, 0.0F, sprite);
        return builder.build();
    }

    public static void putVertex(IVertexConsumer builder, Position normal, double x, double y, double z, float u, float v, TextureAtlasSprite sprite) {
        var elements = builder.getVertexFormat().getElements();

        for (int e = 0; e < elements.size(); ++e) {
            switch ((elements.get(e)).getUsage()) {
                case POSITION:
                    builder.put(e, (float) x, (float) y, (float) z);
                    break;
                case COLOR:
                    builder.put(e, 1.0f, 1.0f, 1.0f, 1.0f);
                    break;
                case UV:
                    switch ((elements.get(e)).getIndex()) {
                        case 0:
                            float iu = sprite.getU(u);
                            float iv = sprite.getV(v);
                            builder.put(e, iu, iv);
                            continue;
                        case 2:
                            builder.put(e, 0.0F, 0.0F);
                            continue;
                        default:
                            builder.put(e);
                            continue;
                    }
                case NORMAL:
                    builder.put(e, (float) normal.x(), (float) normal.y(), (float) normal.z());
                    break;
                default:
                    builder.put(e);
            }
        }
    }

    @NotNull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull Random rand, @NotNull IModelData extraData) {
        init();

        return getTextured(side, getTexture());
    }

    private TextureAtlasSprite getTexture() {
        if (block == null || !block.canPlayerSee()) {
            return FALLBACK;
        }
        return texture;
    }

    private void init() {
        if (FALLBACK == null) {
            var location = BTBBlocks.VOID_FABRIC.getBlock().getRegistryName();
            FALLBACK = getTexture(new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
        }
        if (texture == null) {
            texture = getTexture(location);
        }
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return true;
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
        return getTexture();
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }

    @Override
    public ItemTransforms getTransforms() {
        return this.transforms;
    }
}

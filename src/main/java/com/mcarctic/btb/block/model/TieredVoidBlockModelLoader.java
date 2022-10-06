package com.mcarctic.btb.block.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.custom.TieredVoidBlock;
import com.mcarctic.btb.registry.BTBBlocks;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.zytorx.library.registry.RegisteredBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public class TieredVoidBlockModelLoader implements IModelLoader<TieredVoidBlockModelLoader.ModelGeometry> {
    @Override
    public ModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new ModelGeometry();
    }

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {

    }

    public static void register(ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(new ResourceLocation(BeneathTheBedrock.MOD_ID, "tieredloader"), new TieredVoidBlockModelLoader());
    }

    public static class ModelGeometry implements IModelGeometry<ModelGeometry> {
        private ModelGeometry() {
        }

        public BakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ItemOverrides overrides, ResourceLocation modelLocation) {
            return new TieredVoidBlockBakedModel(modelLocation);
        }

        @Override
        public Collection<Material> getTextures(IModelConfiguration owner, Function<ResourceLocation, UnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
            var materials = new ArrayList<Material>();
            for (var field : BTBBlocks.class.getDeclaredFields()) {
                try {
                    if (field.canAccess(null) && field.get(null) instanceof RegisteredBlock registered) {
                        if (registered.getBlock() instanceof TieredVoidBlock) {
                            var location = registered.getBlock().getRegistryName();
                            materials.add(new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(location.getNamespace(), "block/" + location.getPath())));
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }


            return materials;
        }
    }
}

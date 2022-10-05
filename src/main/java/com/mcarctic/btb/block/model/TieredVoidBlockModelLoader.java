package com.mcarctic.btb.block.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mcarctic.btb.BeneathTheBedrock;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.geometry.IModelGeometry;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;

public class TieredVoidBlockModelLoader implements IModelLoader<TieredVoidBlockModelLoader.ModelGeometry> {
    public static void register(ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(new ResourceLocation(BeneathTheBedrock.MOD_ID, "tieredloader"), new TieredVoidBlockModelLoader());
    }

    @Override
    public ModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new ModelGeometry();
    }

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {

    }

    public static class ModelGeometry implements IModelGeometry<ModelGeometry> {
        private ModelGeometry() {
        }

        public BakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ItemOverrides overrides, ResourceLocation modelLocation) {
            
            return new TieredVoidBlockBakedModel();
        }

        @Override
        public Collection<Material> getTextures(IModelConfiguration owner, Function<ResourceLocation, UnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
            return Collections.emptyList();
        }
    }
}

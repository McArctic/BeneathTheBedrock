package com.mcarctic.btb.data.magicdata;

import com.google.common.reflect.TypeToken;
import com.mcarctic.btb.data.magicdata.model.IMagicLevel;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class MagicSkill extends AbstractWidget implements IForgeRegistryEntry<MagicSkill> {

    private final TypeToken<MagicSkill> token = new TypeToken<>(getClass()) {
    };
    private final IMagicLevel level;
    private ResourceLocation registryName = null;

    public MagicSkill(IMagicLevel level, int x, int y, int width, int height) {
        super(x, y, width, height, NarratorChatListener.NO_TITLE);
        this.level = level;
    }

    public MagicSkill(IMagicLevel level, int x, int y) {
        this(level, x, y, 64, 64);
    }

    public final void unlock(ServerPlayer player) {

    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        setMessage(getDescription());
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, new ResourceLocation("btb", "textures/block/void_fabric.png"));
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        this.blit(pPoseStack, this.x, this.y, 64, 64, width, height);
        this.renderBg(pPoseStack, Minecraft.getInstance(), pMouseX, pMouseY);
    }

    public TranslatableComponent getTitle() {
        return getTitle(getRegistryName(), level);
    }

    public TranslatableComponent getDescription() {
        return getDescription(getRegistryName(), level);
    }

    public ResourceLocation getIcon() {
        return getIcon(getRegistryName(), level);
    }

    public IMagicLevel getLevel() {
        return level;
    }

    public final MagicSkill setRegistryName(String modID, String name) {
        return setRegistryName(modID + ":" + name);
    }

    @Nullable
    public final ResourceLocation getRegistryName() {
        return registryName != null ? registryName : null;
    }

    public final MagicSkill setRegistryName(String name) {
        if (getRegistryName() != null)
            throw new IllegalStateException("Attempted to set registry name with existing registry name! New: " + name + " Old: " + getRegistryName());

        this.registryName = checkRegistryName(name);
        return this;
    }

    public final MagicSkill setRegistryName(ResourceLocation name) {
        return setRegistryName(name.toString());
    }

    public final Class<MagicSkill> getRegistryType() {
        return (Class<MagicSkill>) token.getRawType();
    }

    ResourceLocation checkRegistryName(String name) {
        return GameData.checkPrefix(name, true);
    }

    @Override
    public void updateNarration(@NotNull NarrationElementOutput pNarrationElementOutput) {
    }

    public static ResourceLocation getIcon(ResourceLocation location, IMagicLevel level) {
        return new ResourceLocation(location.getNamespace(), "textures/btbskills/" + level.getType().identifier() + "/" + location.getPath() + ".png");
    }

    public static TranslatableComponent getDescription(ResourceLocation location, IMagicLevel level) {
        return new TranslatableComponent("btbskills." + level.getType().identifier() + "." + location.getNamespace() + "." + location.getPath() + ".description");
    }

    public static TranslatableComponent getTitle(ResourceLocation location, IMagicLevel level) {
        return new TranslatableComponent("btbskills." + level.getType().identifier() + "." + location.getNamespace() + "." + location.getPath() + ".title");
    }
}

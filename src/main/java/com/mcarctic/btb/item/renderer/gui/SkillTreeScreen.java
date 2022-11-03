package com.mcarctic.btb.item.renderer.gui;

import com.mcarctic.btb.data.magicdata.model.IMagicType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Player;

public class SkillTreeScreen extends Screen {

    private final Player player;
    private final IMagicType type;

    public SkillTreeScreen(Player player, IMagicType type) {
        super(NarratorChatListener.NO_TITLE);
        this.player = player;
        this.type = type;

    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        this.setFocused(null);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BookViewScreen.BOOK_LOCATION);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    protected void init() {
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        for (var skill : type.getLevel(0).getSkills()) {
            addRenderableWidget(skill);
        }
    }

    @Override
    public void tick() {

    }
}

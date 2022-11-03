package com.mcarctic.btb.item.renderer.gui;

import com.mcarctic.btb.data.magicdata.model.IMagicType;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;

public class SkillTreeScreen extends Screen {

    private final Player player;
    private final IMagicType type;

    public SkillTreeScreen(Player player, IMagicType type) {
        super(NarratorChatListener.NO_TITLE);
        this.player = player;
        this.type = type;
    }
}

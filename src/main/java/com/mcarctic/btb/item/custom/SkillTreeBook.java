package com.mcarctic.btb.item.custom;

import com.mcarctic.btb.data.magicdata.model.IMagicType;
import com.mcarctic.btb.data.playerdata.ClientMagicData;
import com.mcarctic.btb.item.renderer.gui.SkillTreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SkillTreeBook extends Item {

    private final IMagicType type;

    public SkillTreeBook(Properties properties, IMagicType type) {
        super(properties);
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.isLocalPlayer()) {
            if (!ClientMagicData.getMagicLevel().getType().is(type)) {
                return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
            }
            Minecraft.getInstance().setScreen(new SkillTreeScreen(pPlayer, type));
        }

        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }


}

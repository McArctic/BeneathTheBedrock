package com.mcarctic.btb.item.custom;

import com.mcarctic.btb.entity.custom.projectiles.UncorruptProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ClearingGunItem extends ProjectileWeaponItem {

    private final float range;

    public ClearingGunItem(Properties pProperties, float range) {
        super(pProperties);
        this.range = range;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pHand) {
        ItemStack itemstack = player.getItemInHand(pHand);

        if (!pLevel.isClientSide) {
            var stack = player.getItemInHand(pHand);
            UncorruptProjectile abstractarrow = new UncorruptProjectile(pLevel, player);
            abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.0F, 0F);

            stack.hurtAndBreak(1, player, (p_40665_) -> {
                p_40665_.broadcastBreakEvent(pHand);
            });

            pLevel.addFreshEntity(abstractarrow);
        }

        pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);

        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResultHolder.consume(itemstack);

    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 10;
    }
}

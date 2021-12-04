package com.mcarctic.btb.entity.custom;


import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.Event;


public class VoidCrawlerEntity extends MonsterEntity {
    private static final DataParameter<Byte> CLIMBING;

    public VoidCrawlerEntity(EntityType<? extends VoidCrawlerEntity> p_i48550_1_, World p_i48550_2_) {
        super(p_i48550_1_, p_i48550_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH,16D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30000001192092896D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 25D);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new VoidCrawlerEntity.AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(2, new VoidCrawlerEntity.TargetGoal(this, PlayerEntity.class));
        this.targetSelector.addGoal(3, new VoidCrawlerEntity.TargetGoal(this, IronGolemEntity.class));
    }




    @Override
    protected PathNavigator createNavigator(World p_175447_1_) {
        return new ClimberPathNavigator(this, p_175447_1_);
    }


    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CLIMBING, (byte)0);
    }




    @Override
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }

    }

    @Override
    protected int getExperiencePoints(PlayerEntity p_70693_1_)
    {
        return 3 + this.world.rand.nextInt(5);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }


      @Override
    public void setMotionMultiplier(BlockState p_213295_1_, Vector3d p_213295_2_) {
        if (!p_213295_1_.matchesBlock(Blocks.COBWEB)) {
            super.setMotionMultiplier(p_213295_1_, p_213295_2_);
        }

    }



    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance p_70687_1_) {
        if (p_70687_1_.getPotion() == Effects.POISON) {
            PotionEvent.PotionApplicableEvent event = new PotionEvent.PotionApplicableEvent(this, p_70687_1_);
            MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == Event.Result.ALLOW;
        } else {
            return super.isPotionApplicable(p_70687_1_);
        }
    }

    public boolean isBesideClimbableBlock() {
        return ((Byte)this.dataManager.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean p_70839_1_) {
        byte b0 = (Byte)this.dataManager.get(CLIMBING);
        if (p_70839_1_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 &= -2;
        }

        this.dataManager.set(CLIMBING, b0);
    }


    @Override
    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return 0.65F;
    }

    static {
        CLIMBING = EntityDataManager.createKey(VoidCrawlerEntity.class, DataSerializers.BYTE);
    }

    static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(VoidCrawlerEntity p_i45818_1_, Class<T> p_i45818_2_) {
            super(p_i45818_1_, p_i45818_2_, true);
        }


        @Override
        public boolean shouldExecute() {
            float f = this.goalOwner.getBrightness();
            return f >= 0.5F ? false : super.shouldExecute();
        }
    }


    static class AttackGoal extends MeleeAttackGoal {

        public AttackGoal(VoidCrawlerEntity p_i46676_1_) {
            super(p_i46676_1_, 1.0D, true);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            return (double)(4.0F + p_179512_1_.getWidth());
        }
    }
}


package com.mcarctic.btb.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DestabilizerTile extends TileEntity implements IAnimatable {

    private  AnimationFactory factory = new AnimationFactory(this);

    public DestabilizerTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public DestabilizerTile(){
        this(ModTileEntities.DESTABILIZER_TILE.get());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.destabilizer.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


}


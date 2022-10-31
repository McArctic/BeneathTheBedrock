package com.mcarctic.btb.entity.custom.projectiles;

import com.mcarctic.btb.registry.BTBEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class UncorruptProjectile extends Projectile {
    private final Vec3 startPos;

    public UncorruptProjectile(EntityType<? extends UncorruptProjectile> entityType, Level pLevel) {
        super(entityType, pLevel);
        startPos = this.position();
    }

    public UncorruptProjectile(Level pLevel, Entity shooter) {
        super(BTBEntityTypes.UNCORRUPT_PROJECTILE.get(), pLevel);
        this.setPos(shooter.getX(), shooter.getEyeY() - (double) 0.1F, shooter.getZ());
        this.setOwner(shooter);
        startPos = this.position();
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec3 = this.getDeltaMovement();

        Vec3 vec32 = this.position();
        Vec3 vec33 = vec32.add(vec3);
        var hitResult = this.level.clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        this.hitArea(hitResult, 4);

        double d5 = vec3.x;
        double d6 = vec3.y;
        double d1 = vec3.z;

        double d7 = this.getX() + d5;
        double d2 = this.getY() + d6;
        double d3 = this.getZ() + d1;
        float f = 1F;

        this.setDeltaMovement(vec3.scale(f));

        this.setPos(d7, d2, d3);
    }

    private void hitArea(BlockHitResult baseResult, int radius) {
        for (var pos : positionsToRevert(baseResult.getBlockPos(), baseResult.getDirection(), radius)) {
            this.onHitBlock(new BlockHitResult(baseResult.getLocation(), baseResult.getDirection(), pos, baseResult.isInside()));
        }
    }

    private List<BlockPos> positionsToRevert(BlockPos pos, Direction direction, int radius) {
        var positions = new ArrayList<BlockPos>();
        for (int i = -radius; i < radius + 1; i++) {
            for (int j = -radius; j < radius + 1; j++) {
                switch (direction.getAxis()) {
                    case X -> positions.add(pos.offset(0, i, j));
                    case Y -> positions.add(pos.offset(i, 0, j));
                    case Z -> positions.add(pos.offset(i, j, 0));
                }
            }
        }
        return positions;
    }

    @Override
    protected void defineSynchedData() {

    }
}

package com.mcarctic.btb.client.model.entity;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.entity.Entity;

public class VoidCrawlerModel<V extends Entity> extends EntityModel<V> {
    private final ModelRenderer head;
    private final ModelRenderer body0;
    private final ModelRenderer body1;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer leg5;
    private final ModelRenderer leg6;
    private final ModelRenderer leg7;

    public VoidCrawlerModel() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 15.0F, -3.0F);
        head.setTextureOffset(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        body0 = new ModelRenderer(this);
        body0.setRotationPoint(0.0F, 15.0F, 0.0F);
        body0.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

        body1 = new ModelRenderer(this);
        body1.setRotationPoint(0.0F, 15.0F, 9.0F);
        body1.setTextureOffset(0, 12).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, false);

        leg0 = new ModelRenderer(this);
        leg0.setRotationPoint(-4.0F, 15.0F, 2.0F);
        setRotationAngle(leg0, 0.0F, 0.7854F, -0.7854F);
        leg0.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(4.0F, 15.0F, 2.0F);
        setRotationAngle(leg1, 0.0F, -0.7854F, 0.7854F);
        leg1.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(-4.0F, 15.0F, 1.0F);
        setRotationAngle(leg2, 0.0F, 0.2618F, -0.6109F);
        leg2.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(4.0F, 15.0F, 1.0F);
        setRotationAngle(leg3, 0.0F, -0.2618F, 0.6109F);
        leg3.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(-4.0F, 15.0F, 0.0F);
        setRotationAngle(leg4, 0.0F, -0.2618F, -0.6109F);
        leg4.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg5 = new ModelRenderer(this);
        leg5.setRotationPoint(4.0F, 15.0F, 0.0F);
        setRotationAngle(leg5, 0.0F, 0.2618F, 0.6109F);
        leg5.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg6 = new ModelRenderer(this);
        leg6.setRotationPoint(-4.0F, 15.0F, -1.0F);
        setRotationAngle(leg6, 0.0F, -0.7854F, -0.7854F);
        leg6.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        leg7 = new ModelRenderer(this);
        leg7.setRotationPoint(4.0F, 15.0F, -1.0F);
        setRotationAngle(leg7, 0.0F, 0.7854F, 0.7854F);
        leg7.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(V v, float v2, float v1, float v22, float v3, float v4) {
        this.head.rotateAngleY = v3 * 0.017453292F;
        this.head.rotateAngleX = v4 * 0.017453292F;
        float lvt_7_1_ = 0.7853982F;
        this.leg0.rotateAngleZ = -0.7853982F;
        this.leg1.rotateAngleZ = 0.7853982F;
        this.leg2.rotateAngleZ = -0.58119464F;
        this.leg3.rotateAngleZ = 0.58119464F;
        this.leg4.rotateAngleZ = -0.58119464F;
        this.leg5.rotateAngleZ = 0.58119464F;
        this.leg6.rotateAngleZ = -0.7853982F;
        this.leg7.rotateAngleZ = 0.7853982F;
        float lvt_8_1_ = -0.0F;
        float lvt_9_1_ = 0.3926991F;
        this.leg0.rotateAngleY = 0.7853982F;
        this.leg1.rotateAngleY = -0.7853982F;
        this.leg2.rotateAngleY = 0.3926991F;
        this.leg3.rotateAngleY = -0.3926991F;
        this.leg4.rotateAngleY = -0.3926991F;
        this.leg5.rotateAngleY = 0.3926991F;
        this.leg6.rotateAngleY = -0.7853982F;
        this.leg7.rotateAngleY = 0.7853982F;
        float lvt_10_1_ = -(MathHelper.cos(v2 * 0.6662F * 2.0F + 0.0F) * 0.4F) * v1;
        float lvt_11_1_ = -(MathHelper.cos(v2 * 0.6662F * 2.0F + 3.1415927F) * 0.4F) * v1;
        float lvt_12_1_ = -(MathHelper.cos(v2 * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * v1;
        float lvt_13_1_ = -(MathHelper.cos(v2 * 0.6662F * 2.0F + 4.712389F) * 0.4F) * v1;
        float lvt_14_1_ = Math.abs(MathHelper.sin(v2 * 0.6662F + 0.0F) * 0.4F) * v1;
        float lvt_15_1_ = Math.abs(MathHelper.sin(v2 * 0.6662F + 3.1415927F) * 0.4F) * v1;
        float lvt_16_1_ = Math.abs(MathHelper.sin(v2 * 0.6662F + 1.5707964F) * 0.4F) * v1;
        float lvt_17_1_ = Math.abs(MathHelper.sin(v2 * 0.6662F + 4.712389F) * 0.4F) * v1;
        ModelRenderer var10000 = this.leg0;
        var10000.rotateAngleY += lvt_10_1_;
        var10000 = this.leg1;
        var10000.rotateAngleY += -lvt_10_1_;
        var10000 = this.leg2;
        var10000.rotateAngleY += lvt_11_1_;
        var10000 = this.leg3;
        var10000.rotateAngleY += -lvt_11_1_;
        var10000 = this.leg4;
        var10000.rotateAngleY += lvt_12_1_;
        var10000 = this.leg5;
        var10000.rotateAngleY += -lvt_12_1_;
        var10000 = this.leg6;
        var10000.rotateAngleY += lvt_13_1_;
        var10000 = this.leg7;
        var10000.rotateAngleY += -lvt_13_1_;
        var10000 = this.leg1;
        var10000.rotateAngleZ += lvt_14_1_;
        var10000 = this.leg2;
        var10000.rotateAngleZ += -lvt_14_1_;
        var10000 = this.leg3;
        var10000.rotateAngleZ += lvt_15_1_;
        var10000 = this.leg4;
        var10000.rotateAngleZ += -lvt_15_1_;
        var10000 = this.leg4;
        var10000.rotateAngleZ += lvt_16_1_;
        var10000 = this.leg5;
        var10000.rotateAngleZ += -lvt_16_1_;
        var10000 = this.leg6;
        var10000.rotateAngleZ += lvt_17_1_;
        var10000 = this.leg7;
        var10000.rotateAngleZ += -lvt_17_1_;

    }


    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int i, int i1, float v, float v1, float v2, float v3) {
        head.render(matrixStack, buffer, i, i1);
        body0.render(matrixStack, buffer, i, i1);
        body1.render(matrixStack, buffer, i, i1);
        leg0.render(matrixStack, buffer, i, i1);
        leg1.render(matrixStack, buffer, i, i1);
        leg2.render(matrixStack, buffer, i, i1);
        leg3.render(matrixStack, buffer, i, i1);
        leg4.render(matrixStack, buffer, i, i1);
        leg5.render(matrixStack, buffer, i, i1);
        leg6.render(matrixStack, buffer, i, i1);
        leg7.render(matrixStack, buffer, i, i1);

    }
}

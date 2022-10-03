package com.mcarctic.btb.item.renderer;

import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import com.mcarctic.btb.item.model.DestabilizerBlockItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DestabilizerItemRenderer extends GeoItemRenderer<DestabilizerBlockItem> {
    public DestabilizerItemRenderer() {
        super(new DestabilizerBlockItemModel());
    }
}

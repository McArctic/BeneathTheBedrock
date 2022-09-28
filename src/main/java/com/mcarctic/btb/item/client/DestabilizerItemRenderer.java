package com.mcarctic.btb.item.client;

import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DestabilizerItemRenderer extends GeoItemRenderer<DestabilizerBlockItem> {
    public DestabilizerItemRenderer() {
        super(new DestabilizerBlockItemModel());
    }
}

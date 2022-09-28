package com.mcarctic.btb.item.client;

import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DestabilizerBlockItemRenderer extends GeoItemRenderer<DestabilizerBlockItem> {
    public DestabilizerBlockItemRenderer() {
        super(new DestabilizerBlockItemModel());
    }
}

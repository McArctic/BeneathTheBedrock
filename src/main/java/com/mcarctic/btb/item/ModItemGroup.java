package com.mcarctic.btb.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroup {

    public static final CreativeModeTab VOID_GROUP = new CreativeModeTab("voidTab") {
        @Override

        public ItemStack makeIcon() {
            return new ItemStack(Items.BEDROCK);
        }
    };
}

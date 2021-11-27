package com.mcarctic.btb.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroup {

    public static final ItemGroup VOID_GROUP = new ItemGroup("voidTab") {
        @Override

        public ItemStack createIcon()
        {
            return new ItemStack(Items.BEDROCK.getItem());
        }
    };
}

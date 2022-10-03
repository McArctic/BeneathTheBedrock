package com.mcarctic.btb.datagen.loot;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.registry.BTBBlocks;
import net.zytorx.library.datagen.loot.ZytorxBlockLoot;

public class BTBBlockLootTables extends ZytorxBlockLoot {


    public BTBBlockLootTables() {
        super(BeneathTheBedrock.MOD_ID);
    }

    @Override
    protected void addBlockTables() {
        dropOther(BTBBlocks.VOID_FABRIC_NONSPREADABLE.getBlock(), BTBBlocks.VOID_FABRIC);
    }
}

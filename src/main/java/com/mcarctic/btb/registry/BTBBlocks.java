package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.custom.*;
import com.mcarctic.btb.data.VoidMagicLevel;
import com.mcarctic.btb.item.BTBItemGroup;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.zytorx.library.datagen.reflection.ToolType;
import net.zytorx.library.datagen.reflection.annotations.BlockDefinition;
import net.zytorx.library.datagen.reflection.annotations.EnglishName;
import net.zytorx.library.registry.RegisteredBlock;
import net.zytorx.library.registry.Registrar;

import java.util.function.Supplier;

public class BTBBlocks {

    @EnglishName(name = "Void Fabric")
    @BlockDefinition(toolTypes = {ToolType.PICKAXE})
    public static final RegisteredBlock VOID_FABRIC = registerBlock("void_fabric",
            VoidFabricBlock::new, BTBItemGroup.VOID_GROUP);

    @EnglishName(name = "Void Fabric Wood")
    @BlockDefinition(toolTypes = {ToolType.PICKAXE}, hasCustomModel = true)
    public static final RegisteredBlock VOID_FABRIC_WOOD = registerBlock("void_fabric_wood",
            () -> new TieredVoidBlock(VoidMagicLevel.NONE), BTBItemGroup.VOID_GROUP);

    @EnglishName(name = "Void Fabric")
    @BlockDefinition(toolTypes = {ToolType.PICKAXE}, hasItem = false, hasCustomModel = true, hasSpecialDrop = true)
    public static final RegisteredBlock VOID_FABRIC_NONSPREADABLE = registerBlock("void_fabric_nonspreadable",
            VoidFabricNonSpreadableBlock::new);

    @EnglishName(name = "Destabilizer")
    @BlockDefinition(toolTypes = {ToolType.PICKAXE}, hasCustomModel = true)
    public static final RegisteredBlock DESTABILIZER = registerBlock("destabilizer",
            DestabilizerBlock::new);

    @EnglishName(name = "Void Fabric Temp")
    @BlockDefinition(toolTypes = {ToolType.PICKAXE}, hasCustomModel = true)
    public static final RegisteredBlock VOID_FABRIC_TEMP = registerBlock("void_fabric_temp",
            VoidFabricTempBlock::new, BTBItemGroup.VOID_GROUP);


    private static RegisteredBlock registerBlock(String name, Supplier<Block> block, CreativeModeTab tab) {
        return Registrar.getInstance(BeneathTheBedrock.MOD_ID).createBlock(name, block, tab);
    }

    private static RegisteredBlock registerBlock(String name, Supplier<Block> block) {
        return Registrar.getInstance(BeneathTheBedrock.MOD_ID).createBlock(name, block, null, false, false);
    }
}

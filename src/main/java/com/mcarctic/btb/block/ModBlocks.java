package com.mcarctic.btb.block;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.block.custom.DestabilizerBlock;
import com.mcarctic.btb.block.custom.VoidFabricBlock;
import com.mcarctic.btb.block.custom.VoidFabricNonSpreadableBlock;
import com.mcarctic.btb.item.ModItemGroup;
import com.mcarctic.btb.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BeneathTheBedrock.MOD_ID);


    public static final RegistryObject<Block> VOID_FABRIC = registerBlock("void_fabric",
            VoidFabricBlock::new, ModItemGroup.VOID_GROUP);

    public static final RegistryObject<Block> VOID_FABRIC_NONSPREADABLE = registerBlock("void_fabric_nonspreadable",
            VoidFabricNonSpreadableBlock::new, null);


                    /*
                    Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(5f)
                    .sound(SoundType.CLOTH)));

                     */

    //  public static final RegistryObject<Block> VOID_FABRIC_TEST = registerBlock("void_fabric_test",
    //         () -> new VoidFabricTestBlock());

    public static final RegistryObject<Block> DESTABILIZER = registerBlock("destabilizer",
            DestabilizerBlock::new, null);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

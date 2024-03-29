package com.mcarctic.btb.registry;

import com.mcarctic.btb.BeneathTheBedrock;
import com.mcarctic.btb.data.magicdata.MagicType;
import com.mcarctic.btb.item.BTBItemGroup;
import com.mcarctic.btb.item.custom.BTBSpawnEggItem;
import com.mcarctic.btb.item.custom.ClearingGunItem;
import com.mcarctic.btb.item.custom.DestabilizerBlockItem;
import com.mcarctic.btb.item.custom.SkillTreeBook;
import net.minecraft.world.item.Item;
import net.zytorx.library.datagen.reflection.annotations.EnglishName;
import net.zytorx.library.datagen.reflection.annotations.ItemDefinition;
import net.zytorx.library.registry.RegisteredItem;
import net.zytorx.library.registry.Registrar;

import java.util.function.Supplier;

public class BTBItems {

    @EnglishName(name = "Void Crawler Spawn Egg")
    @ItemDefinition(hasCustomModel = true)
    public static final RegisteredItem VOID_CRAWLER_SPAWN_EGG = registerItem("void_crawler_spawn_egg",
            () -> new BTBSpawnEggItem(BTBEntityTypes.VOID_CRAWLER, 0x0f141a, 0x0e97a8,
                    new Item.Properties().tab(BTBItemGroup.VOID_GROUP)));

    @ItemDefinition(hasCustomModel = true)
    public static final RegisteredItem DESTABILIZER_BLOCK_ITEM = registerItem("destabilizer",
            () -> new DestabilizerBlockItem(BTBBlocks.DESTABILIZER.getBlock(),
                    new Item.Properties().tab(BTBItemGroup.VOID_GROUP)));

    @EnglishName(name = "Journal of §kNotch")
    @ItemDefinition(isTool = true)
    public static final RegisteredItem VOIDLING_JOURNAL = registerItem("voidling_journal",
            () -> new SkillTreeBook(new Item.Properties().tab(BTBItemGroup.VOID_GROUP), MagicType.VOIDLING));

    @EnglishName(name = "Clearing Gun")
    @ItemDefinition(isTool = true)
    public static final RegisteredItem CLEARING_GUN = registerItem("clearing_gun",
            () -> new ClearingGunItem(new Item.Properties().tab(BTBItemGroup.VOID_GROUP), 10));

    private static RegisteredItem registerItem(String name, Supplier<Item> sup) {
        return Registrar.getInstance(BeneathTheBedrock.MOD_ID).createItem(name, sup);
    }
}

package com.mcarctic.btb;

import com.mcarctic.btb.block.BTBBlocks;
import com.mcarctic.btb.client.renderer.entity.VoidCrawlerRenderer;
import com.mcarctic.btb.enchantment.BTBEnchantments;
import com.mcarctic.btb.entity.BTBBlockEntities;
import com.mcarctic.btb.entity.BTBEntityTypes;
import com.mcarctic.btb.item.BTBItems;
import com.mcarctic.btb.world.biome.BTBBiomes;
import com.mcarctic.btb.world.dimension.BTBDimensions;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zytorx.library.ZytorxLibrary;
import net.zytorx.library.registry.Registrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BeneathTheBedrock.MOD_ID)
public class BeneathTheBedrock {
    public static final String MOD_ID = "btb";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public BeneathTheBedrock() {
        GeckoLib.initialize();

        var t = ZytorxLibrary.MOD_ID;

        var registrar = Registrar.getInstance(MOD_ID);
        registrar.addBlockDeclaration(BTBBlocks.class);
        registrar.addItemDeclaration(BTBItems.class);

        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registrar.register(eventBus);
        BTBBiomes.register();
        BTBBlockEntities.register(eventBus);
        BTBEntityTypes.register(eventBus);
        BTBEnchantments.register(eventBus);
        BTBDimensions.register();


        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRenderers.register(BTBEntityTypes.VOID_CRAWLER.get(), VoidCrawlerRenderer::new);
    }


    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
}

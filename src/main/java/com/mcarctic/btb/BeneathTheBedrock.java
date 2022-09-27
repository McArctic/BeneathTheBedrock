package com.mcarctic.btb;

import com.mcarctic.btb.block.ModBlocks;
import com.mcarctic.btb.client.renderer.entity.VoidCrawlerRenderer;
import com.mcarctic.btb.enchantment.ModEnchantments;
import com.mcarctic.btb.entity.ModEntityTypes;
import com.mcarctic.btb.item.ModItems;
import com.mcarctic.btb.tileentity.ModTileEntities;
import com.mcarctic.btb.world.biome.ModBiomes;
import com.mcarctic.btb.world.dimension.ModDimensions;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("btb")
public class BeneathTheBedrock {
    public static final String MOD_ID = "btb";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public BeneathTheBedrock() {
        GeckoLib.initialize();

        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBiomes.register();
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModEnchantments.register(eventBus);

        //ModStructures.register(eventBus);

        ModDimensions.register();

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        //*ModStructures.setupStructures();


        //Entity
     //   SpawnPlacements.register(ModEntityTypes.VOID_CRAWLER.get(), SpawnPlacements.Type.ON_GROUND,
      //          Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //ClientRegistry.bindTileEntityRenderer(ModTileEntities.DESTABILIZER_TILE.get(), DestabilizerRenderer::new);

       EntityRenderers.register(ModEntityTypes.VOID_CRAWLER.get(), VoidCrawlerRenderer::new);

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

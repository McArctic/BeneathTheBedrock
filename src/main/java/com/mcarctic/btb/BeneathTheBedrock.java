package com.mcarctic.btb;

import com.mcarctic.btb.block.model.TieredVoidBlockModelLoader;
import com.mcarctic.btb.data.magicdata.CommonMagicData;
import com.mcarctic.btb.enchantment.BTBEnchantments;
import com.mcarctic.btb.entity.renderer.UncorruptProjectileRenderer;
import com.mcarctic.btb.entity.renderer.VoidCrawlerRenderer;
import com.mcarctic.btb.networking.BTBNetworkMessages;
import com.mcarctic.btb.registry.*;
import com.mcarctic.btb.world.structure.BTBStructures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zytorx.library.registry.Registrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BeneathTheBedrock.MOD_ID)
public class BeneathTheBedrock {
    public static final String MOD_ID = "btb";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public BeneathTheBedrock() {
        GeckoLib.initialize();

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
        BTBStructures.register(eventBus);


        eventBus.addListener(TieredVoidBlockModelLoader::register);
        eventBus.addListener(CommonMagicData::setup);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);
    }

    private void setup(final FMLCommonSetupEvent event) {

        BTBNetworkMessages.register();

        SpawnPlacements.register(BTBEntityTypes.VOID_CRAWLER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRenderers.register(BTBEntityTypes.VOID_CRAWLER.get(), VoidCrawlerRenderer::new);
        EntityRenderers.register(BTBEntityTypes.UNCORRUPT_PROJECTILE.get(), UncorruptProjectileRenderer::new);
    }

    private void postSetup(final FMLLoadCompleteEvent event) {

    }
}

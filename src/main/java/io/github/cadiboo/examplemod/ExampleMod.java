package io.github.cadiboo.examplemod;

import io.github.cadiboo.examplemod.config.ConfigHolder;
import io.github.cadiboo.examplemod.init.ModBlocks;
import io.github.cadiboo.examplemod.init.ModContainerTypes;
import io.github.cadiboo.examplemod.init.ModEntityTypes;
import io.github.cadiboo.examplemod.init.ModItems;
import io.github.cadiboo.examplemod.init.ModTileEntityTypes;
import io.github.cadiboo.examplemod.worldgen.OreGen;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(ExampleMod.MODID)
@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)


public final class ExampleMod {

	public static final String MODID = "examplemod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public ExampleMod() {
		LOGGER.debug("Hello from Example Mod!");

		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register Deferred Registers (Does not need to be before Configs)
		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		// Register Configs (Does not need to be after Deferred Registers)
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
	}
	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		OreGen.generateOre();
	}
}

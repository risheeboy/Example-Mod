package io.github.cadiboo.examplemod.util;


import io.github.cadiboo.examplemod.ExampleMod;
import io.github.cadiboo.examplemod.init.DimensionInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(ExampleMod.EXAMPLE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(ExampleMod.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null,
                    true);
        }
        ExampleMod.LOGGER.info("Dimensions Registered!");
    }
}

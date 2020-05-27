package io.github.cadiboo.examplemod.init;


import io.github.cadiboo.examplemod.ExampleMod;
import io.github.cadiboo.examplemod.world.dimension.ExampleModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, ExampleMod.MODID);
	
	public static final RegistryObject<ModDimension> EXAMPLE_DIM = MOD_DIMENSIONS.register("example_dim", () -> new ExampleModDimension());
}

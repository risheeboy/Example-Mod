package io.github.cadiboo.examplemod.world.dimension;

import com.google.common.collect.ImmutableSet;
import io.github.cadiboo.examplemod.init.BiomeInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class ExampleBiomeProvider extends BiomeProvider {

	private Random rand;

	public ExampleBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.EXAMPLE_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.EXAMPLE_BIOME.get();
	}

}

package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class VibrantFlowersConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CHRYSANTHEMUM = ResourceKey.create(Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, "white_chrysanthemum"));

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		context.register(WHITE_CHRYSANTHEMUM, new ConfiguredFeature<>(Feature.FLOWER,
				new RandomPatchConfiguration(8, 4, 1, PlacementUtils.onlyWhenEmpty(
						Feature.SIMPLE_BLOCK,
						new SimpleBlockConfiguration(BlockStateProvider.simple(VibrantFlowersBlocks.WHITE_CHRYSANTHEMUM))
				))
		));
	}
}

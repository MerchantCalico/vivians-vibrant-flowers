package net.merchantcalico.vibrantflowers.datagen;

import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.VibrantFlowersTags;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class VibrantFlowersDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		BlockTagProvider blockTags = pack.addProvider(BlockTagProvider::new);
		pack.addProvider(DynamicRegistryProvider::new);
		pack.addProvider((output, registriesFuture) ->
				new ItemTagProvider(output, registriesFuture, blockTags));
	}

	@Override
	public String getEffectiveModId() {
		return VibrantFlowers.MOD_ID;
	}

	public static class DynamicRegistryProvider extends FabricDynamicRegistryProvider {
		public DynamicRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void configure(HolderLookup.Provider registries, Entries entries) {
			VibrantFlowersConfiguredFeatures.bootstrap(createContext(registries, entries));
		}

		private static <T> BootstrapContext<T> createContext(HolderLookup.Provider registries, Entries entries) {
			return new BootstrapContext<>() {
				@Override
				public Holder.@NotNull Reference<T> register(ResourceKey<T> resourceKey, T object, Lifecycle lifecycle) {
					return (Holder.Reference<T>) entries.add(resourceKey, object);
				}

				@Override
				public <S> @NotNull HolderGetter<S> lookup(ResourceKey<? extends Registry<? extends S>> resourceKey) {
					return registries.lookupOrThrow(resourceKey);
				}
			};
		}

		@Override
		public @NotNull String getName() {
			return "Vibrant Flowers Dynamic Registries";
		}
	}

	public static class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
		public BlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.CHRYSANTHEMUMS)
					.add(
							VibrantFlowersBlocks.RED_CHRYSANTHEMUM,
							VibrantFlowersBlocks.ORANGE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.YELLOW_CHRYSANTHEMUM,
							VibrantFlowersBlocks.GREEN_CHRYSANTHEMUM,
							VibrantFlowersBlocks.BLUE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.PURPLE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.PINK_CHRYSANTHEMUM,
							VibrantFlowersBlocks.WHITE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.BLACK_CHRYSANTHEMUM
					);
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.COMMON_CHRYSANTHEMUMS)
					.add(
							VibrantFlowersBlocks.RED_CHRYSANTHEMUM,
							VibrantFlowersBlocks.ORANGE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.YELLOW_CHRYSANTHEMUM,
							VibrantFlowersBlocks.PURPLE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.PINK_CHRYSANTHEMUM,
							VibrantFlowersBlocks.WHITE_CHRYSANTHEMUM
					);
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.RARE_CHRYSANTHEMUMS)
					.add(
							VibrantFlowersBlocks.GREEN_CHRYSANTHEMUM,
							VibrantFlowersBlocks.BLUE_CHRYSANTHEMUM,
							VibrantFlowersBlocks.BLACK_CHRYSANTHEMUM
					);

			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.BLUE_CHRYSANTHEMUM_FLOWER_CATALYST)
					.add(
							Blocks.CORNFLOWER,
							Blocks.BLUE_ORCHID
					);
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.GREEN_CHRYSANTHEMUM_FLOWER_CATALYST)
					.add(
							Blocks.LILY_OF_THE_VALLEY,
							Blocks.WHITE_TULIP
					);
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.BLACK_CHRYSANTHEMUM_FLOWER_CATALYST)
					.add(
							Blocks.WITHER_ROSE,
							VibrantFlowersBlocks.HALTER
					);
		}
	}

	public static class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
		public ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagProvider blockTagProvider) {
			super(output, registriesFuture, blockTagProvider);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			copy(VibrantFlowersTags.Blocks.CHRYSANTHEMUMS, VibrantFlowersTags.Items.CHRYSANTHEMUMS);
			copy(VibrantFlowersTags.Blocks.COMMON_CHRYSANTHEMUMS, VibrantFlowersTags.Items.COMMON_CHRYSANTHEMUMS);
			copy(VibrantFlowersTags.Blocks.RARE_CHRYSANTHEMUMS, VibrantFlowersTags.Items.RARE_CHRYSANTHEMUMS);
		}
	}
}

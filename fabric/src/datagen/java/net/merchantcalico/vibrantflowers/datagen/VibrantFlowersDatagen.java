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
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.CHRYSANTH_FLOWERS)
					.add(VibrantFlowersBlocks.RED_CHRYSANTH)
					.add(VibrantFlowersBlocks.ORANGE_CHRYSANTH)
					.add(VibrantFlowersBlocks.YELLOW_CHRYSANTH)
					.add(VibrantFlowersBlocks.GREEN_CHRYSANTH)
					.add(VibrantFlowersBlocks.BLUE_CHRYSANTH)
					.add(VibrantFlowersBlocks.PURPLE_CHRYSANTH)
					.add(VibrantFlowersBlocks.PINK_CHRYSANTH)
					.add(VibrantFlowersBlocks.WHITE_CHRYSANTH)
					.add(VibrantFlowersBlocks.BLACK_CHRYSANTH);
		}
	}

	public static class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
		public ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagProvider blockTagProvider) {
			super(output, registriesFuture, blockTagProvider);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			copy(VibrantFlowersTags.Blocks.CHRYSANTH_FLOWERS, VibrantFlowersTags.Items.CHRYSANTH_FLOWERS);
		}
	}
}

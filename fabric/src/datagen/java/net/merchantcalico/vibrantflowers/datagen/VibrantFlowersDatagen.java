package net.merchantcalico.vibrantflowers.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.VibrantFlowersTags;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class VibrantFlowersDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		BlockTags blockTags = pack.addProvider(BlockTags::new);
		pack.addProvider((output, registriesFuture) ->
				new ItemTags(output, registriesFuture, blockTags));
	}

	@Override
	public String getEffectiveModId() {
		return VibrantFlowers.MOD_ID;
	}

	public static class BlockTags extends FabricTagProvider.BlockTagProvider {
		public BlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			getOrCreateTagBuilder(VibrantFlowersTags.Blocks.CHRYSANTH_FLOWERS)
					.add(VibrantFlowersBlocks.LIME_CHRYSANTH);
		}
	}

	public static class ItemTags extends FabricTagProvider.ItemTagProvider {
		public ItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagProvider blockTagProvider) {
			super(output, registriesFuture, blockTagProvider);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			copy(VibrantFlowersTags.Blocks.CHRYSANTH_FLOWERS, VibrantFlowersTags.Items.CHRYSANTH_FLOWERS);
		}
	}
}

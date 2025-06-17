package net.merchantcalico.vibrantflowers;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class VibrantFlowersTags {
	public static class Blocks {
		public static final TagKey<Block> CHRYSANTH_FLOWERS = createTag("chrysanth_flowers");

		private static TagKey<Block> createTag(String name) {
			return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		}
	}

	public static class Items {
		public static final TagKey<Item> CHRYSANTH_FLOWERS = createTag("chrysanth_flowers");

		private static TagKey<Item> createTag(String name) {
			return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		}
	}
}

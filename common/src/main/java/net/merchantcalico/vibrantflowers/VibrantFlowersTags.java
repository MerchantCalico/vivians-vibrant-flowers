package net.merchantcalico.vibrantflowers;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class VibrantFlowersTags {
	public static class Blocks {
		public static final TagKey<Block> CHRYSANTHEMUMS = createTag("chrysanthemums");
		public static final TagKey<Block> COMMON_CHRYSANTHEMUMS = createTag("common_chrysanthemums");
		public static final TagKey<Block> RARE_CHRYSANTHEMUMS = createTag("rare_chrysanthemums");

		public static final TagKey<Block> BLUE_CHRYSANTHEMUM_FLOWER_CATALYST = createTag("chrysanthemum_catalyst/blue");
		public static final TagKey<Block> GREEN_CHRYSANTHEMUM_FLOWER_CATALYST = createTag("chrysanthemum_catalyst/green");
		public static final TagKey<Block> BLACK_CHRYSANTHEMUM_FLOWER_CATALYST = createTag("chrysanthemum_catalyst/black");

		private static TagKey<Block> createTag(String name) {
			return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		}
	}

	public static class Items {
		public static final TagKey<Item> CHRYSANTHEMUMS = createTag("chrysanthemums");
		public static final TagKey<Item> COMMON_CHRYSANTHEMUMS = createTag("common_chrysanthemums");
		public static final TagKey<Item> RARE_CHRYSANTHEMUMS = createTag("rare_chrysanthemums");

		private static TagKey<Item> createTag(String name) {
			return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		}
	}
}

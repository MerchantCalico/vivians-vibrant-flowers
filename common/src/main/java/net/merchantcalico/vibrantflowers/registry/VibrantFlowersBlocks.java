package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.VibrantFlowersTags;
import net.merchantcalico.vibrantflowers.block.ChrysanthemumBlock;
import net.merchantcalico.vibrantflowers.block.HalterBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.function.Function;

public class VibrantFlowersBlocks {

	public static final HalterBlock HALTER = registerBlock("halter",
			HalterBlock::new, Properties.ofFullCopy(Blocks.POPPY));

	public static final ChrysanthemumBlock RED_CHRYSANTHEMUM = registerChrysanthemum(NoteBlock.getPitchFromNote(14),
			DyeColor.RED);
	public static final ChrysanthemumBlock ORANGE_CHRYSANTHEMUM = registerChrysanthemum(NoteBlock.getPitchFromNote(11),
			DyeColor.ORANGE, DyeColor.BROWN);
	public static final ChrysanthemumBlock YELLOW_CHRYSANTHEMUM = registerChrysanthemum(NoteBlock.getPitchFromNote(13),
			DyeColor.YELLOW);
	public static final ChrysanthemumBlock GREEN_CHRYSANTHEMUM = registerRareChrysanthemum(NoteBlock.getPitchFromNote(9),
			VibrantFlowersTags.Blocks.GREEN_CHRYSANTHEMUM_FLOWER_CATALYST, DyeColor.GREEN, DyeColor.LIME);
	public static final ChrysanthemumBlock BLUE_CHRYSANTHEMUM = registerRareChrysanthemum(NoteBlock.getPitchFromNote(7),
			VibrantFlowersTags.Blocks.BLUE_CHRYSANTHEMUM_FLOWER_CATALYST, DyeColor.BLUE, DyeColor.LIGHT_BLUE, DyeColor.CYAN);
	public static final ChrysanthemumBlock PURPLE_CHRYSANTHEMUM = registerChrysanthemum(NoteBlock.getPitchFromNote(10),
			DyeColor.PURPLE, DyeColor.MAGENTA);
	public static final ChrysanthemumBlock PINK_CHRYSANTHEMUM = registerChrysanthemum(NoteBlock.getPitchFromNote(15),
			DyeColor.PINK);
	public static final ChrysanthemumBlock WHITE_CHRYSANTHEMUM = registerChrysanthemum(NoteBlock.getPitchFromNote(12),
			DyeColor.WHITE, DyeColor.LIGHT_GRAY);
	public static final ChrysanthemumBlock BLACK_CHRYSANTHEMUM = registerRareChrysanthemum(NoteBlock.getPitchFromNote(8),
			VibrantFlowersTags.Blocks.BLACK_CHRYSANTHEMUM_FLOWER_CATALYST, DyeColor.BLACK, DyeColor.GRAY);

	public static<T extends Block> T registerBlock(String name,
		  Function<Properties, T> factory, Properties properties){
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		T block = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.BLOCK, key, block);
	}

	private static ChrysanthemumBlock registerChrysanthemum(float pitch, DyeColor... colors){
		return registerBlock(colors[0].getName() + "_chrysanthemum",
				properties -> new ChrysanthemumBlock(properties, pitch, colors),
				Properties.ofFullCopy(Blocks.POPPY));
	}

	private static ChrysanthemumBlock registerRareChrysanthemum(float pitch, TagKey<Block> catalysts, DyeColor... colors){
		return registerBlock(colors[0].getName() + "_chrysanthemum",
				properties -> new ChrysanthemumBlock(properties, pitch, catalysts, colors),
				Properties.ofFullCopy(Blocks.POPPY));
	}

	public static void init() {
	}
}

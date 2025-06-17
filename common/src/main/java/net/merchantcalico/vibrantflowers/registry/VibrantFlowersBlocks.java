package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.block.ChrysanthBlock;
import net.merchantcalico.vibrantflowers.block.HalterBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.function.Function;

public class VibrantFlowersBlocks {

	public static final HalterBlock HALTER = registerBlock("halter",
			HalterBlock::new, Properties.ofFullCopy(Blocks.POPPY));

	public static final ChrysanthBlock RED_CHRYSANTH = registerChrysanth(DyeColor.RED);
	public static final ChrysanthBlock ORANGE_CHRYSANTH = registerChrysanth(DyeColor.ORANGE, DyeColor.BROWN);
	public static final ChrysanthBlock YELLOW_CHRYSANTH = registerChrysanth(DyeColor.YELLOW);
	public static final ChrysanthBlock GREEN_CHRYSANTH = registerChrysanth(DyeColor.GREEN, DyeColor.LIME);
	public static final ChrysanthBlock BLUE_CHRYSANTH = registerChrysanth(DyeColor.BLUE, DyeColor.LIGHT_BLUE, DyeColor.CYAN);
	public static final ChrysanthBlock PURPLE_CHRYSANTH = registerChrysanth(DyeColor.PURPLE, DyeColor.MAGENTA);
	public static final ChrysanthBlock PINK_CHRYSANTH = registerChrysanth(DyeColor.PINK);
	public static final ChrysanthBlock WHITE_CHRYSANTH = registerChrysanth(DyeColor.WHITE, DyeColor.LIGHT_GRAY);
	public static final ChrysanthBlock BLACK_CHRYSANTH = registerChrysanth(DyeColor.BLACK, DyeColor.GRAY);

	public static<T extends Block> T registerBlock(String name,
		  Function<Properties, T> factory, Properties properties){
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		T block = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.BLOCK, key, block);
	}

	private static ChrysanthBlock registerChrysanth(DyeColor... colors){
		return registerBlock(colors[0].getName() + "_chrysanth",
				properties -> new ChrysanthBlock(properties, colors),
				Properties.ofFullCopy(Blocks.POPPY));
	}

	public static void init() {
	}
}

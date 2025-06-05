package net.merchantcalico.vibrantflowers.common.registries;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.function.Function;

public class ModBlocks {
	public static final Block TEST_BLOCK = registerBlock("test_block", Block::new,
			Properties.ofFullCopy(Blocks.STONE));

	public static Block registerBlock(String name,
		  Function<Properties, Block> factory, Properties properties){
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		Block block = factory.apply(properties.setId(key));
		ModItems.registerItem(name, (p)->new BlockItem(block, p), new Item.Properties());
		return Registry.register(BuiltInRegistries.BLOCK, key, block);
	}



	public static Block registerBlock(String name, Properties properties){
		return registerBlock(name, Block::new, properties);
	}


	public static void init(){}
}

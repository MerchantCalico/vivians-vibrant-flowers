package net.merchantcalico.vibrantflowers.common.registries;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.common.flowers.chrysanth.ChrysanthBlock;
import net.merchantcalico.vibrantflowers.common.flowers.halter.HalterBlock;
import net.merchantcalico.vibrantflowers.common.flowers.halter.HalterItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.function.Function;

public class ModBlocks {

	public static final HalterBlock HALTER = registerBlock("halter",
			HalterBlock::new, Properties.ofFullCopy(Blocks.POPPY), false);
	public static final HalterItem HALTER_ITEM = ModItems.registerItem("halter",
			HalterItem::new, new Item.Properties());

	public static final ChrysanthBlock[] CHRYSANTHS = new ChrysanthBlock[16];

	private static ChrysanthBlock registerChrysanth(DyeColor color){
		return registerBlock(color.getName()+"_chrysanth",
				properties -> {return new ChrysanthBlock(properties, color);},
				Properties.ofFullCopy(Blocks.POPPY), true);
	}

	public static<T extends Block> T registerBlock(String name,
		  Function<Properties, T> factory, Properties properties, boolean addItem){
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		T block = factory.apply(properties.setId(key));
		if(addItem)
			ModItems.registerItem(name, (p)->new BlockItem(block, p), new Item.Properties());
		return Registry.register(BuiltInRegistries.BLOCK, key, block);
	}



	public static void init(){
		for(DyeColor color: DyeColor.values()){
			CHRYSANTHS[color.getId()] = registerChrysanth(color);
		}
	}
}

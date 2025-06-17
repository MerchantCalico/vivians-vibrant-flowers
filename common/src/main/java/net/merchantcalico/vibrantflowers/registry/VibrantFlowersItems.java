package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.item.HalterItem;
import net.merchantcalico.vibrantflowers.item.LuteItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class VibrantFlowersItems {

	public static final LuteItem LUTE = registerItem("lute", LuteItem::new, new Item.Properties());
	public static final HalterItem HALTER = registerItem("halter",
			HalterItem::new, new Item.Properties().useBlockDescriptionPrefix());

	public static final BlockItem RED_CHRYSANTH = registerItem("red_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.RED_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem ORANGE_CHRYSANTH = registerItem("orange_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.ORANGE_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem YELLOW_CHRYSANTH = registerItem("yellow_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.YELLOW_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem PINK_CHRYSANTH = registerItem("pink_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.PINK_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem PURPLE_CHRYSANTH = registerItem("purple_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.PURPLE_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem WHITE_CHRYSANTH = registerItem("white_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.WHITE_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem BLACK_CHRYSANTH = registerItem("black_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.BLACK_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem GREEN_CHRYSANTH = registerItem("green_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.GREEN_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());
	public static final BlockItem BLUE_CHRYSANTH = registerItem("blue_chrysanth",
			properties -> new BlockItem(VibrantFlowersBlocks.BLUE_CHRYSANTH, properties),
			new Item.Properties().useBlockDescriptionPrefix());

	public static<T extends Item> T registerItem(String name, Function<Item.Properties, T> factory, Item.Properties properties){
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		T item = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}



	public static void init(){}
}

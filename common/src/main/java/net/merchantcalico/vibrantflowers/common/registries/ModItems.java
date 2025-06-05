package net.merchantcalico.vibrantflowers.common.registries;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItems {

	public static final Item TEST_ITEM = registerItem("test_item");

	public static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties properties){
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		Item item = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static Item registerItem(String name){
		return registerItem(name, Item::new, new Item.Properties());
	}


	public static void init(){}
}

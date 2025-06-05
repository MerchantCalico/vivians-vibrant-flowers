package net.merchantcalico.vibrantflowers.common.registries;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.common.instruments.LuteItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItems {

	public static final LuteItem LUTE = registerItem("lute", LuteItem::new, new Item.Properties());

	public static<T extends Item> T registerItem(String name, Function<Item.Properties, T> factory, Item.Properties properties){
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, name));
		T item = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}



	public static void init(){}
}

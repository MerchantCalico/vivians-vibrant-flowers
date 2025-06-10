package net.merchantcalico.vibrantflowers.common.registries;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

	private static final ResourceKey<CreativeModeTab> VIBRANT_FLOWERS = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, "vibrant_flowers"));

	public static void init(){
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, VIBRANT_FLOWERS,
				CreativeModeTab.builder(CreativeModeTab.Row.TOP,0)
						.title(Component.translatable("tab.vibrantflowers"))
						.icon(()-> new ItemStack(ModItems.LUTE))
						.displayItems((itemDisplayParameters, output) ->{
							output.accept(ModItems.LUTE);
							output.accept(ModBlocks.HALTER_ITEM);
						})
						.build());
	}
}

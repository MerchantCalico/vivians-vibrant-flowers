package net.merchantcalico.vibrantflowers.registry;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class VibrantFlowersCreativeTabs {

	private static final ResourceKey<CreativeModeTab> VIBRANT_FLOWERS = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
			ResourceLocation.fromNamespaceAndPath(VibrantFlowers.MOD_ID, "vibrant_flowers"));

	public static void init(){
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, VIBRANT_FLOWERS,
				CreativeModeTab.builder(CreativeModeTab.Row.TOP,0)
						.title(Component.translatable("tab.vibrantflowers"))
						.icon(()-> new ItemStack(VibrantFlowersItems.LUTE))
						.displayItems((itemDisplayParameters, output) ->{
							output.accept(VibrantFlowersItems.LUTE);
							output.accept(VibrantFlowersItems.WHITE_CHRYSANTH);
							output.accept(VibrantFlowersItems.BLACK_CHRYSANTH);
							output.accept(VibrantFlowersItems.RED_CHRYSANTH);
							output.accept(VibrantFlowersItems.ORANGE_CHRYSANTH);
							output.accept(VibrantFlowersItems.YELLOW_CHRYSANTH);
							output.accept(VibrantFlowersItems.GREEN_CHRYSANTH);
							output.accept(VibrantFlowersItems.BLUE_CHRYSANTH);
							output.accept(VibrantFlowersItems.PURPLE_CHRYSANTH);
							output.accept(VibrantFlowersItems.PINK_CHRYSANTH);
							output.accept(VibrantFlowersItems.HALTER);
						})
						.build());
	}
}

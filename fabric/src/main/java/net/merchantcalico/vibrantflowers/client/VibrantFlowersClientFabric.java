package net.merchantcalico.vibrantflowers.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.minecraft.client.renderer.RenderType;

public class VibrantFlowersClientFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		VibrantFlowersClient.init();
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.HALTER, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.LIME_CHRYSANTH, RenderType.cutout());
	}
}

package net.merchantcalico.vibrantflowers.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.minecraft.client.renderer.RenderType;

public class VibrantFlowersClientFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		VibrantFlowersClient.init();
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.RED_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.ORANGE_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.YELLOW_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.GREEN_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.BLUE_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.PURPLE_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.PINK_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.WHITE_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.BLACK_CHRYSANTH, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(VibrantFlowersBlocks.HALTER, RenderType.cutout());
	}
}

package net.merchantcalico.vibrantflowers.client;

import net.fabricmc.api.ClientModInitializer;

public class VibrantFlowersClientFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		VibrantFlowersClient.init();
	}
}

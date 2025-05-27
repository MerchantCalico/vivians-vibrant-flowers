package net.merchantcalico.vibrantflowers.server.dedicated;

import net.fabricmc.api.DedicatedServerModInitializer;

public class VibrantFlowersDedicatedFabric implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		VibrantFlowersDedicated.init();
	}
}

package net.merchantcalico.vibrantflowers;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(VibrantFlowers.MOD_ID)
public class VibrantFlowersNeoForge {

	public VibrantFlowersNeoForge(IEventBus eventBus) {
		VibrantFlowers.init();
	}
}

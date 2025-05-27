package net.merchantcalico.vibrantflowers.client;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(
		value = VibrantFlowers.MOD_ID,
		dist = Dist.CLIENT
)
public class VibrantFlowersClientNeoForge {
	public VibrantFlowersClientNeoForge() {
		VibrantFlowersClient.init();
	}
}

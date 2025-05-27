package net.merchantcalico.vibrantflowers.server.dedicated;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(
		value = VibrantFlowers.MOD_ID,
		dist = Dist.DEDICATED_SERVER
)
public class VibrantFlowersDedicatedNeoForge {
	public VibrantFlowersDedicatedNeoForge() {
		VibrantFlowersDedicated.init();
	}
}

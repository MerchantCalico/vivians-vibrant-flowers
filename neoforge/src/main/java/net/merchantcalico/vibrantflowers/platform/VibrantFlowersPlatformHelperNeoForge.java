package net.merchantcalico.vibrantflowers.platform;

import net.merchantcalico.vibrantflowers.platform.side.Side;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import org.jetbrains.annotations.ApiStatus;

public class VibrantFlowersPlatformHelperNeoForge implements VibrantFlowersPlatformHelper {

	@Override
	public Platform getPlatform() {
		return Platform.NEOFORGE;
	}

	@Override
	public boolean isModLoaded(String modId) {
		return ModList.get().isLoaded(modId);
	}

	@Override
	public boolean isDevelopmentEnvironment() {
		return !FMLLoader.isProduction();
	}

	@Override
	public Side getSide() {
		return switch (FMLLoader.getDist()) {
			case CLIENT -> Side.CLIENT;
			case DEDICATED_SERVER -> Side.DEDICATED;
		};
	}

	@Override
	@ApiStatus.Internal
	public Class<? extends VibrantFlowersPlatformHelper> type() {
		return VibrantFlowersPlatformHelperNeoForge.class;
	}

	@Override
	@ApiStatus.Internal
	public VibrantFlowersPlatformHelper get() {
		return this;
	}
}

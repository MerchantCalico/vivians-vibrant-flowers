package net.merchantcalico.vibrantflowers.platform;

import net.merchantcalico.vibrantflowers.platform.side.Side;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.ApiStatus;

public class VibrantFlowersPlatformHelperFabric implements VibrantFlowersPlatformHelper {
	@Override
	public Platform getPlatform() {
		return Platform.FABRIC;
	}

	@Override
	public boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	@Override
	public boolean isDevelopmentEnvironment() {
		return FabricLoader.getInstance().isDevelopmentEnvironment();
	}

	@Override
	public Side getSide() {
		return switch (FabricLoader.getInstance().getEnvironmentType()) {
			case CLIENT -> Side.CLIENT;
			case SERVER -> Side.DEDICATED;
		};
	}

	@Override
	@ApiStatus.Internal
	public Class<? extends VibrantFlowersPlatformHelper> type() {
		return VibrantFlowersPlatformHelperFabric.class;
	}

	@Override
	@ApiStatus.Internal
	public VibrantFlowersPlatformHelper get() {
		return this;
	}
}

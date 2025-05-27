package net.merchantcalico.vibrantflowers.platform.side;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import org.jetbrains.annotations.ApiStatus;

import java.util.ServiceLoader;

/**
 * Shared utilities for side-specific behavior.
 */
public interface VibrantFlowersSideHelper<S extends VibrantFlowersSideHelper<S>> extends ServiceLoader.Provider<VibrantFlowersSideHelper<S>> {
	@ApiStatus.Internal
	static VibrantFlowersSideHelper<?> load() {
		var loaders = ServiceLoader.load(VibrantFlowersSideHelper.class);
		// Maintain sanity
		if (loaders.stream().findAny().isEmpty()) {
			throw new IllegalStateException("No " + VibrantFlowersSideHelper.class.getName() + " implementation found");
		}

		return loaders
				.stream()
				.filter(provider -> {
					final String pkg = provider.type().getPackage().getName();
					return switch (VibrantFlowers.getHelper().getSide()) {
						case CLIENT -> pkg.startsWith(VibrantFlowers.CLIENT_PACKAGE);
						case DEDICATED -> pkg.startsWith(VibrantFlowers.DEDICATED_PACKAGE);
					};
				})
				.findFirst()
				.orElseThrow()
				.get();
	}
}

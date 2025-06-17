package net.merchantcalico.vibrantflowers;

import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersCreativeTabs;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersItems;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersSoundEvents;
import net.merchantcalico.vibrantflowers.platform.VibrantFlowersPlatformHelper;
import net.merchantcalico.vibrantflowers.platform.side.VibrantFlowersSideHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VibrantFlowers {
	public static final String MOD_ID = "vibrantflowers";
	public static final String MOD_NAME = "Vivian's Vibrant Flowers";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	// These strings are for the PlatformHelper API.
	// Don't forget to update the service config in
	// "common/src/resources/META-INF/services" after updating the package!
	public static final String CLIENT_PACKAGE = "net.merchantcalico.vibrantflowers.client";
	public static final String DEDICATED_PACKAGE = "net.merchantcalico.vibrantflowers.server.dedicated";

	private static VibrantFlowersPlatformHelper helper;
	private static VibrantFlowersSideHelper<?> sideHelper;

	public static void init() {
		VibrantFlowersBlocks.init();
		VibrantFlowersItems.init();
		VibrantFlowersSoundEvents.init();
		VibrantFlowersCreativeTabs.init();
	}

	public static Logger getLogger(String... subsystems) {
		return LoggerFactory.getLogger(MOD_NAME + "/" + String.join("/", subsystems));
	}

	public static VibrantFlowersPlatformHelper getHelper() {
		if (helper == null) {
			helper = VibrantFlowersPlatformHelper.load();
		}
		return helper;
	}

	public static VibrantFlowersSideHelper<?> getSideHelper() {
		if (sideHelper == null) {
			sideHelper = VibrantFlowersSideHelper.load();
		}
		return sideHelper;
	}
}

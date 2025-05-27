package net.merchantcalico.vibrantflowers.server.dedicated.platform.side;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.platform.side.VibrantFlowersSideHelper;
import org.jetbrains.annotations.ApiStatus;

public class VibrantFlowersDedicatedSideHelper implements VibrantFlowersSideHelper<VibrantFlowersDedicatedSideHelper> {
	static VibrantFlowersDedicatedSideHelper getInstance() {
		return (VibrantFlowersDedicatedSideHelper) VibrantFlowers.getSideHelper();
	}

	@Override
	@ApiStatus.Internal
	public Class<? extends VibrantFlowersSideHelper<VibrantFlowersDedicatedSideHelper>> type() {
		return VibrantFlowersDedicatedSideHelper.class;
	}

	@Override
	@ApiStatus.Internal
	public VibrantFlowersSideHelper<VibrantFlowersDedicatedSideHelper> get() {
		return this;
	}
}

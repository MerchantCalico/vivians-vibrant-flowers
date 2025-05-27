package net.merchantcalico.vibrantflowers.client.platform.side;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.platform.side.VibrantFlowersSideHelper;
import org.jetbrains.annotations.ApiStatus;

public class VibrantFlowersClientSideHelper implements VibrantFlowersSideHelper<VibrantFlowersClientSideHelper> {
	public static VibrantFlowersClientSideHelper getInstance() {
		return (VibrantFlowersClientSideHelper) VibrantFlowers.getSideHelper();
	}

	@Override
	@ApiStatus.Internal
	public Class<? extends VibrantFlowersSideHelper<VibrantFlowersClientSideHelper>> type() {
		return VibrantFlowersClientSideHelper.class;
	}

	@Override
	@ApiStatus.Internal
	public VibrantFlowersSideHelper<VibrantFlowersClientSideHelper> get() {
		return this;
	}
}

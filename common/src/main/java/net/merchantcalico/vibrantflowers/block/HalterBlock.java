package net.merchantcalico.vibrantflowers.block;

import net.merchantcalico.vibrantflowers.registry.VibrantFlowersSoundEvents;
import net.minecraft.world.effect.MobEffects;

public class HalterBlock extends AbstractVibrantFlower {
	public HalterBlock(Properties properties) {
		super(MobEffects.SLOWNESS, 10, properties,
				VibrantFlowersSoundEvents.HALTER_BLOCK_MELODY,1.0F,1.0F);
	}
}

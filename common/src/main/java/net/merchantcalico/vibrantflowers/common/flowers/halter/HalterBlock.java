package net.merchantcalico.vibrantflowers.common.flowers.halter;

import net.merchantcalico.vibrantflowers.common.flowers.AbstractVibrantFlower;
import net.merchantcalico.vibrantflowers.common.registries.ModSoundEvents;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class HalterBlock extends AbstractVibrantFlower {
	public HalterBlock(Properties properties) {
		super(MobEffects.SLOWNESS, 10, properties, ModSoundEvents.HALTER_MELODY);
	}
}

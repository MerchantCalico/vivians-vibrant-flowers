package net.merchantcalico.vibrantflowers.common.flowers;

import net.merchantcalico.vibrantflowers.common.registries.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AbstractVibrantFlower extends FlowerBlock {

	SoundEvent melody;
	int volume;
	int pitch;
	public SoundEvent getMelody() {return melody;}
	public AbstractVibrantFlower(Holder<MobEffect> effect, float seconds, Properties properties, SoundEvent melody,
								 int volume, int pitch) {
		super(effect, seconds, properties);
		this.melody = melody;
		this.volume = volume;
		this.pitch = pitch;
	}

	public void sing(Level level, BlockPos pos, BlockState state, RandomSource random) {
		level.playLocalSound(pos, melody, SoundSource.BLOCKS, volume, pitch,false);

	}
}

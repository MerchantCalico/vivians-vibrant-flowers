package net.merchantcalico.vibrantflowers.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AbstractVibrantFlower extends FlowerBlock {
	private final SoundEvent melody;
	private final float volume;
	private final float pitch;

	public AbstractVibrantFlower(Holder<MobEffect> effect,
								 float seconds,
								 Properties properties,
								 SoundEvent melody,
								 float volume, float pitch) {
		super(effect, seconds, properties);
		this.melody = melody;
		this.volume = volume;
		this.pitch = pitch;
	}

	public void sing(Level level, BlockPos pos, BlockState state, RandomSource random) {
		level.playLocalSound(pos, melody, SoundSource.BLOCKS, volume, pitch,false);
	}

	public SoundEvent getMelody() {
		return melody;
	}
}

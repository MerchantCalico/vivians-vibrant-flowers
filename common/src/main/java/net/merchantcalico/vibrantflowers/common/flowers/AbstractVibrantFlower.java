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
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AbstractVibrantFlower extends FlowerBlock {

	SoundEvent melody;
	public SoundEvent getMelody() {return melody;}
	public AbstractVibrantFlower(Holder<MobEffect> effect, float seconds, Properties properties, SoundEvent melody) {
		super(effect, seconds, properties);
		this.melody = melody;
	}

	@Override
	protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		level.playLocalSound(pos, melody, SoundSource.BLOCKS, 10,1,true);
		level.sendParticles(ParticleTypes.ENCHANT,
				pos.getX()+random.nextDouble(),
				pos.getY()+random.nextDouble(),
				pos.getZ()+random.nextDouble(),
				3,0.0,0.2,0.0,0.1);
	}
}

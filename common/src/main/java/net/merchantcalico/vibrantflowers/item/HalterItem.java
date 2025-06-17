package net.merchantcalico.vibrantflowers.item;

import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HalterItem extends BlockItem {
	public HalterItem(Properties properties) {
		super(VibrantFlowersBlocks.HALTER, properties);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		Entity entity = Minecraft.getInstance().crosshairPickEntity;
		ItemStack stack = player.getItemInHand(hand);
		if(entity instanceof AgeableMob ageableMob){
			ageableMob.setAge(-Integer.MAX_VALUE);
			RandomSource random = level.getRandom();
			for(int i = 0; i < 10; ++i) {
				double d = random.nextGaussian() * 0.02;
				double e = random.nextGaussian() * 0.02;
				double f = random.nextGaussian() * 0.02;
				level.addParticle(ParticleTypes.ASH,
						ageableMob.getRandomX(1.0F),
						ageableMob.getRandomY() + 1.0d,
						ageableMob.getRandomZ(1.0F), d, e, f);
			}
			ageableMob.makeSound(SoundEvents.ZOMBIE_VILLAGER_CURE);
			stack.consume(1, player);

			return InteractionResult.SUCCESS;
		}
		return super.use(level, player, hand);
	}

}

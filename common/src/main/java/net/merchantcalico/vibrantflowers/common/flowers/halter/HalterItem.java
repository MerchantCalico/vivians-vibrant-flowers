package net.merchantcalico.vibrantflowers.common.flowers.halter;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.common.registries.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.AgeableWaterCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class HalterItem extends BlockItem {
	public HalterItem(Properties properties) {
		super(ModBlocks.HALTER, properties);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		Entity entity = Minecraft.getInstance().crosshairPickEntity;
		ItemStack stack = player.getItemInHand(hand);
		if(entity instanceof AgeableMob ageableMob){
			ageableMob.setAge(-Integer.MAX_VALUE);
			level.addParticle(ParticleTypes.ASH,
					ageableMob.getX(), ageableMob.getY(), ageableMob.getZ()
					,0,1,0);
			stack.consume(1,player);

			return InteractionResult.SUCCESS;
		}
		return super.use(level, player, hand);
	}
}

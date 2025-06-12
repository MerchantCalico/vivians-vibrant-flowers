package net.merchantcalico.vibrantflowers.common.flowers.chrysanth;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.common.flowers.AbstractVibrantFlower;
import net.merchantcalico.vibrantflowers.common.registries.ModBlocks;
import net.merchantcalico.vibrantflowers.common.registries.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ChrysanthBlock extends AbstractVibrantFlower {
	private final DyeColor color;
	public ChrysanthBlock(Properties properties, DyeColor color) {
		super(MobEffects.ABSORPTION, 10, properties,
				ModSoundEvents.CHRYSANTH_MELODY, 1, color.getId());
		this.color = color;
	}

	@Override
	protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level,
			  BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(level.isClientSide)
			return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
		if(!stack.is(Items.BONE_MEAL))
			return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
		for(Direction direction: Direction.values()){
			if(direction.getAxis() == Direction.Axis.Y)
				continue;
			BlockPos middlePos = new BlockPos(pos.offset(direction.getUnitVec3i()));
			BlockPos testingPos = new BlockPos(middlePos.offset(direction.getUnitVec3i()));
			if(!(level.getBlockState(testingPos).getBlock() instanceof ChrysanthBlock block))
				continue;
			if(!level.getBlockState(middlePos).is(BlockTags.REPLACEABLE))
				continue;
			DyeColor newColor = DyeColor.getMixedColor((ServerLevel) level, this.color, block.color);
			level.setBlockAndUpdate(middlePos,ModBlocks.CHRYSANTHS[newColor.getId()].defaultBlockState());
			ParticleUtils.spawnParticleInBlock(level, pos, 12, ParticleTypes.HAPPY_VILLAGER);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

}

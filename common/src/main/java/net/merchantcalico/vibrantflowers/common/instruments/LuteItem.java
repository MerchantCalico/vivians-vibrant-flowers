package net.merchantcalico.vibrantflowers.common.instruments;

import net.merchantcalico.vibrantflowers.common.flowers.AbstractVibrantFlower;
import net.merchantcalico.vibrantflowers.common.registries.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LuteItem extends Item {
	public LuteItem(Properties properties) {
		super(properties.stacksTo(1).durability(1024));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		BlockPos pos = context.getClickedPos();
		Level level = context.getLevel();
		BlockState targetBlock = level.getBlockState(pos);
		if(targetBlock.getBlock() instanceof AbstractVibrantFlower avf){
			avf.sing(level, pos, targetBlock, level.getRandom());
			context.getPlayer().awardStat(Stats.ITEM_USED.get(this));

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}
}

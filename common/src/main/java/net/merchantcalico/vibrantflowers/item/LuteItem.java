package net.merchantcalico.vibrantflowers.item;

import net.merchantcalico.vibrantflowers.block.AbstractVibrantFlower;
import net.minecraft.core.BlockPos;
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
		if (targetBlock.getBlock() instanceof AbstractVibrantFlower avf) {
			avf.sing(level, pos, targetBlock, level.getRandom());
			context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
			context.getPlayer().getCooldowns().addCooldown(context.getItemInHand(), 20);
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}
}

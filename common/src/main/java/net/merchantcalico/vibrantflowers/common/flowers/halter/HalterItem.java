package net.merchantcalico.vibrantflowers.common.flowers.halter;

import net.merchantcalico.vibrantflowers.VibrantFlowers;
import net.merchantcalico.vibrantflowers.common.registries.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HalterItem extends BlockItem {
	public HalterItem(Properties properties) {
		super(ModBlocks.HALTER, properties);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		Entity entity = Minecraft.getInstance().crosshairPickEntity;
		if(entity instanceof Animal animal && animal.isBaby()){
			animal.setAge(-Integer.MAX_VALUE);
			return InteractionResult.SUCCESS;
		}
		return super.use(level, player, hand);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		BlockPos blockPos = context.getClickedPos();
		Level level = context.getLevel();
		BlockState state = level.getBlockState(blockPos);
		Block block = state.getBlock();
		if(block instanceof BonemealableBlock){
			//TODO: Implement That, somehow
		}
		return super.useOn(context);
	}
}

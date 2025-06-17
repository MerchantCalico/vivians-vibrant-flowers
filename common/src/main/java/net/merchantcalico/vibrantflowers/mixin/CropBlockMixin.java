package net.merchantcalico.vibrantflowers.mixin;

import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(CropBlock.class)
public class CropBlockMixin {

	int range = 8;
	@Inject(method="randomTick",at=@At("HEAD"),cancellable = true)
	public void considerNearbyHalters(BlockState state, ServerLevel level,
			  BlockPos pos, RandomSource random, CallbackInfo ci){
		AABB area = new AABB(
				pos.getX()-range, pos.getY()-range,pos.getZ()-range,
				pos.getX()+range, pos.getY()+range, pos.getZ()+range
		);
		List<BlockState> list =level.getBlockStates(area).toList();
		if(list.contains(VibrantFlowersBlocks.HALTER.defaultBlockState())) {
			ParticleUtils.spawnParticleInBlock(level, pos, 20, ParticleTypes.ASH);
			ci.cancel();
		}

	}
}

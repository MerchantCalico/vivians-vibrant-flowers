package net.merchantcalico.vibrantflowers.mixin;

import net.merchantcalico.vibrantflowers.registry.VibrantFlowersBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VineBlock.class)
public class VineMixin {
	@Inject(method="randomTick",at=@At("HEAD"),cancellable = true)
	public void vibrantflowers$considerNearbyHalters(BlockState state,
													 ServerLevel level,
													 BlockPos pos,
													 RandomSource random,
													 CallbackInfo ci) {
		if (level.getBlockStates(new AABB(
				pos.getX() - 8, pos.getY() - 8,pos.getZ() - 8,
				pos.getX() + 8, pos.getY() + 8, pos.getZ() + 8
		)).anyMatch(blockState -> blockState.is(VibrantFlowersBlocks.HALTER))) {
			ParticleUtils.spawnParticleInBlock(level, pos, 20, ParticleTypes.ASH);
			ci.cancel();
		}
	}
}

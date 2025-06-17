package net.merchantcalico.vibrantflowers.block;

import net.merchantcalico.vibrantflowers.registry.VibrantFlowersSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ChrysanthemumBlock extends AbstractVibrantFlower implements BonemealableBlock {
	public static final Map<DyeColor, ChrysanthemumBlock> COLOR_MAP = new HashMap<>();
	private final DyeColor firstColor;

	public ChrysanthemumBlock(Properties properties, float pitch, DyeColor... colors) {
		super(MobEffects.ABSORPTION, 10, properties,
				VibrantFlowersSoundEvents.CHRYSANTHEMUM_BLOCK_MELODY, 1.0F, pitch);
		this.firstColor = colors[0];
		for (DyeColor color : colors) {
			COLOR_MAP.put(color, this);
		}
	}
	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		DyeColor newColor = null;
		for (Direction direction : Direction.values()){
			if (direction.getAxis() == Direction.Axis.Y)
				continue;

			BlockPos middlePos = new BlockPos(pos.offset(direction.getUnitVec3i()));
			BlockPos testingPos = new BlockPos(middlePos.offset(direction.getUnitVec3i()));

			if (level.getBlockState(testingPos).getBlock() instanceof ChrysanthemumBlock block &&
					level.getBlockState(middlePos).is(BlockTags.REPLACEABLE)) {
				// TODO: If we have time, custom color logic.
				newColor = DyeColor.getMixedColor(level, firstColor, block.firstColor);
			}
		}

		BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
		for (int i = 0; i < 4; ++i) {
			ChrysanthemumBlock block = newColor != null && random.nextFloat() < 0.25F ? COLOR_MAP.getOrDefault(newColor, this) : this;
			BlockPos spreadPos = mutablePos.set(pos)
					.offset(
							Mth.randomBetweenInclusive(random, -1, 1),
							0,
							Mth.randomBetweenInclusive(random, -1, 1)
					);
			if (level.getBlockState(spreadPos).is(BlockTags.REPLACEABLE) && state.canSurvive(level, spreadPos)) {
				level.setBlockAndUpdate(spreadPos, block.defaultBlockState());
				level.levelEvent(1505, spreadPos, 15);
			}
		}
	}

	@Override
	public @NotNull Type getType() {
		return Type.GROWER;
	}
}

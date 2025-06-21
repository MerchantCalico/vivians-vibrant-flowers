package net.merchantcalico.vibrantflowers.block;

import net.merchantcalico.vibrantflowers.VibrantFlowersTags;
import net.merchantcalico.vibrantflowers.registry.VibrantFlowersSoundEvents;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ChrysanthemumBlock extends AbstractVibrantFlower implements BonemealableBlock {
	public static final Map<DyeColor, ChrysanthemumBlock> COLOR_MAP = new HashMap<>();
	private final DyeColor firstColor;
	@Nullable
	private final TagKey<Block> catalysts;

	public ChrysanthemumBlock(Properties properties, float pitch, DyeColor... colors) {
		this(properties, pitch, null, colors);
	}

	public ChrysanthemumBlock(Properties properties, float pitch, TagKey<Block> catalysts, DyeColor... colors) {
		super(MobEffects.ABSORPTION, 10, properties,
				VibrantFlowersSoundEvents.CHRYSANTHEMUM_BLOCK_MELODY, 1.0F, pitch);
		this.firstColor = colors[0];
		for (DyeColor color : colors) {
			COLOR_MAP.put(color, this);
		}
		this.catalysts = catalysts;
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
		Block newColor = this;
		for (Direction direction : Direction.values()){
			if (direction.getAxis() == Direction.Axis.Y)
				continue;

			BlockPos middlePos = new BlockPos(pos.offset(direction.getUnitVec3i()));
			BlockPos testingPos = new BlockPos(middlePos.offset(direction.getUnitVec3i()));

			if (level.getBlockState(testingPos).getBlock() instanceof ChrysanthemumBlock block && level.isEmptyBlock(middlePos)) {
				var potentialColor = getColoredBlock(level, pos, this, block);
				if (potentialColor != null) {
					newColor = potentialColor;
				}
			}
		}

		BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
		for (int i = 0; i < 4; ++i) {
			Block block = random.nextFloat() < 0.25F ? newColor : this;
			BlockPos spreadPos = mutablePos.set(pos)
					.offset(
							Mth.randomBetweenInclusive(random, -1, 1),
							0,
							Mth.randomBetweenInclusive(random, -1, 1)
					);
			if (level.isEmptyBlock(spreadPos) && state.canSurvive(level, spreadPos)) {
				level.setBlockAndUpdate(spreadPos, block.defaultBlockState());
				level.levelEvent(1505, spreadPos, 15);
			}
		}
	}

	@Nullable
	public static Block getColoredBlock(@NotNull ServerLevel level, BlockPos origin, @NotNull ChrysanthemumBlock first, @NotNull ChrysanthemumBlock second) {
		Block chrysanthemumBlock = COLOR_MAP.get(DyeColor.getMixedColor(level, first.firstColor, second.firstColor));

		if (!first.builtInRegistryHolder().is(VibrantFlowersTags.Blocks.RARE_CHRYSANTHEMUMS) &&
				!second.builtInRegistryHolder().is(VibrantFlowersTags.Blocks.RARE_CHRYSANTHEMUMS) &&
				chrysanthemumBlock.builtInRegistryHolder().is(VibrantFlowersTags.Blocks.RARE_CHRYSANTHEMUMS)) {
			var tag = level.registryAccess().lookupOrThrow(Registries.BLOCK).get(VibrantFlowersTags.Blocks.COMMON_CHRYSANTHEMUMS);
			if (tag.isPresent())
				chrysanthemumBlock = tag.get().getRandomElement(level.getRandom()).map(Holder::value).orElse(null);
		}

		var tag = level.registryAccess().lookupOrThrow(Registries.BLOCK).get(VibrantFlowersTags.Blocks.RARE_CHRYSANTHEMUMS);

		if (tag.isEmpty())
			return chrysanthemumBlock;

		if (level.getRandom().nextInt(128) == 0)
			return tag.get().getRandomElement(level.getRandom()).map(Holder::value).orElse(null);

		var rareCatalysts = Util.toShuffledList(level.getBlockStatesIfLoaded(AABB.ofSize(origin.getCenter(), 3.5, 1.5, 3.5)).flatMap(state ->
				tag.get().stream().map(block -> {
					if (block.isBound() && block.value() instanceof ChrysanthemumBlock chrysan && chrysan.catalysts != null) {
						var catalysts = level.registryAccess().lookupOrThrow(Registries.BLOCK).get(chrysan.catalysts);
						if (catalysts.isPresent() && catalysts.get().contains(block)) {
							return chrysan;
						}
					}
					return null;
				})), level.getRandom());

		if (!rareCatalysts.isEmpty() && level.getRandom().nextInt(16) == 0) {
			return rareCatalysts.getFirst();
		}

		return chrysanthemumBlock;
	}

	@Override
	public @NotNull Type getType() {
		return Type.GROWER;
	}
}

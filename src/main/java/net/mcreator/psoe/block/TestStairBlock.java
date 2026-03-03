package net.mcreator.psoe.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TestStairBlock extends StairBlock {
	public TestStairBlock() {
		super(() -> Blocks.AIR.defaultBlockState(),
				BlockBehaviour.Properties.of().sound(SoundType.LADDER).strength(999f, 0f).friction(0.1f).jumpFactor(5f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).instrument(NoteBlockInstrument.ZOMBIE));
	}

	@Override
	public float getExplosionResistance() {
		return 0f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 80;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 10;
	}

	@Override
	public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
		return Mth.randomBetweenInclusive(randomSource, 20, 50);
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
		return true;
	}
}
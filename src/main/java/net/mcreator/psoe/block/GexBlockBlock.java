package net.mcreator.psoe.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GexBlockBlock extends Block {
	public GexBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.8f, 3f).requiresCorrectToolForDrops().friction(0.8f).speedFactor(1.1f).jumpFactor(0.9f).instrument(NoteBlockInstrument.CHIME));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 14;
	}

	@Override
	public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
		return Mth.randomBetweenInclusive(randomSource, 0, 2);
	}
}
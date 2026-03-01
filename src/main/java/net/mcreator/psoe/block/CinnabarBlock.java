package net.mcreator.psoe.block;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class CinnabarBlock extends Block {
	public CinnabarBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(1.4f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.XYLOPHONE));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
		return Mth.randomBetweenInclusive(randomSource, 0, 2);
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.LAVA;
	}
}
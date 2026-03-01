package net.mcreator.psoe.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BlocksAroundDirectedBlockProcProcedure {
	public static void execute(LevelAccessor world) {
		Direction dir = Direction.NORTH;
		BlockState front_block = Blocks.AIR.defaultBlockState();
		BlockState front_right_block = Blocks.AIR.defaultBlockState();
		BlockState right_block = Blocks.AIR.defaultBlockState();
		BlockState behind_right_block = Blocks.AIR.defaultBlockState();
		BlockState behind_block = Blocks.AIR.defaultBlockState();
		BlockState behind_left_block = Blocks.AIR.defaultBlockState();
		BlockState left_block = Blocks.AIR.defaultBlockState();
		BlockState front_left_block = Blocks.AIR.defaultBlockState();
		BlockState result_block = Blocks.AIR.defaultBlockState();
		double offset = 0;
		double dx = 0;
		double dz = 0;
		double temp = 0;
		double real_x = 0;
		double real_y = 0;
		double real_z = 0;
		if (true) {
			front_block = Blocks.AIR.defaultBlockState();
			front_right_block = Blocks.AIR.defaultBlockState();
			right_block = Blocks.AIR.defaultBlockState();
			behind_right_block = Blocks.AIR.defaultBlockState();
			behind_block = Blocks.AIR.defaultBlockState();
			behind_left_block = Blocks.AIR.defaultBlockState();
			left_block = Blocks.AIR.defaultBlockState();
			front_left_block = Blocks.AIR.defaultBlockState();
			for (int index0 = 0; index0 < 8; index0++) {
				dx = 0;
				dz = 0;
				if (offset == 0) {
					dz = 1;
				} else if (offset == 1) {
					dx = 1;
					dz = 1;
				} else if (offset == 2) {
					dx = 1;
				} else if (offset == 3) {
					dx = 1;
					dz = -1;
				} else if (offset == 4) {
					dz = -1;
				} else if (offset == 5) {
					dx = -1;
					dz = -1;
				} else if (offset == 6) {
					dx = -1;
				} else if (offset == 7) {
					dx = -1;
					dz = 1;
				}
				if (dir == Direction.WEST) {
					temp = dz;
					dz = 0 - dx;
					dx = temp;
				} else if (dir == Direction.NORTH) {
					dx = 0 - dx;
					dz = 0 - dz;
				} else if (dir == Direction.EAST) {
					temp = dx;
					dx = 0 - dz;
					dz = temp;
				}
				result_block = (world.getBlockState(BlockPos.containing(real_x + dx, real_y, real_z + dz)));
				if (offset == 0) {
					front_block = result_block;
				} else if (offset == 1) {
					front_right_block = result_block;
				} else if (offset == 2) {
					right_block = result_block;
				} else if (offset == 3) {
					behind_right_block = result_block;
				} else if (offset == 4) {
					behind_block = result_block;
				} else if (offset == 5) {
					behind_left_block = result_block;
				} else if (offset == 6) {
					left_block = result_block;
				} else if (offset == 7) {
					front_left_block = result_block;
				}
				offset = offset + 1;
			}
		}
	}
}
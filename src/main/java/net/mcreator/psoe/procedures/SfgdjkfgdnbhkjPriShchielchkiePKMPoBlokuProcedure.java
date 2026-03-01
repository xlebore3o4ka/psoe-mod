package net.mcreator.psoe.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SfgdjkfgdnbhkjPriShchielchkiePKMPoBlokuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		Direction dir = Direction.NORTH;
		double temp = 0;
		double offset = 0;
		double real_x = 0;
		double dx = 0;
		double dz = 0;
		double real_z = 0;
		double real_y = 0;
		BlockState behind_left_block = Blocks.AIR.defaultBlockState();
		BlockState behind_right_block = Blocks.AIR.defaultBlockState();
		BlockState front_left_block = Blocks.AIR.defaultBlockState();
		BlockState right_block = Blocks.AIR.defaultBlockState();
		BlockState front_right_block = Blocks.AIR.defaultBlockState();
		BlockState result_block = Blocks.AIR.defaultBlockState();
		BlockState behind_block = Blocks.AIR.defaultBlockState();
		BlockState left_block = Blocks.AIR.defaultBlockState();
		BlockState front_block = Blocks.AIR.defaultBlockState();
		real_x = x;
		real_y = y;
		real_z = z;
		dir = getDirectionFromBlockState(blockstate);
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
					temp = dx;
					dx = 0 - dz;
					dz = temp;
				} else if (dir == Direction.NORTH) {
					dx = 0 - dx;
					dz = 0 - dz;
				} else if (dir == Direction.EAST) {
					temp = dz;
					dz = 0 - dx;
					dx = temp;
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
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u0412\u043E\u043A\u0440\u0443\u0433: " + ForgeRegistries.BLOCKS.getKey(front_block.getBlock()).toString() + ", " + ForgeRegistries.BLOCKS.getKey(front_right_block.getBlock()).toString()
					+ ", " + ForgeRegistries.BLOCKS.getKey(right_block.getBlock()).toString() + ", " + ForgeRegistries.BLOCKS.getKey(behind_right_block.getBlock()).toString() + ", " + ForgeRegistries.BLOCKS.getKey(behind_block.getBlock()).toString()
					+ ", " + ForgeRegistries.BLOCKS.getKey(behind_left_block.getBlock()).toString() + ", " + ForgeRegistries.BLOCKS.getKey(left_block.getBlock()).toString() + ", "
					+ ForgeRegistries.BLOCKS.getKey(front_left_block.getBlock()).toString())), false);
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}
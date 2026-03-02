package net.mcreator.psoe.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.psoe.world.inventory.FurnaceInterfaceGuiMenu;

import io.netty.buffer.Unpooled;

public class FurnaceInterfaceProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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
		dir = getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))));
		for (int index0 = 0; index0 < 1; index0++) {
			if (!((world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + -1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + -1))).getBlock() == Blocks.BRICKS)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0412 \u043E\u0441\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u043F\u0435\u0447\u0438 \u0442\u0440\u0435\u0431\u0443\u044E\u0442\u0441\u044F 4 \u043A\u0438\u0440\u043F\u0438\u0447\u0430 \u043F\u043E \u043A\u0440\u0430\u044F\u043C \u0438\u043D\u0442\u0435\u0440\u0444\u0435\u0439\u0441\u0430.")),
							false);
				break;
			}
			if (!((world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + -1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + 1))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 0))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 0))).getBlock() == Blocks.AIR)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0414\u043E\u0441\u0442\u0443\u043F \u043A \u0432\u043E\u0437\u0434\u0443\u0445\u0443 \u0432 \u043E\u0441\u043D\u043E\u0432\u0430\u043D\u0438\u0438 \u043F\u0435\u0447\u0438 \u0437\u0430\u0431\u043B\u043E\u043A\u0438\u0440\u043E\u0432\u0430\u043D.")),
							false);
				break;
			}
			real_y = real_y + 1;
			if (!((world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + 1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 0))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + -1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + -1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + -1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 0))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 1))).getBlock() == Blocks.BRICKS)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0422\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044F 8 \u0431\u043B\u043E\u043A\u043E\u0432 \u043A\u0438\u0440\u043F\u0438\u0447\u0430 \u043D\u0430 \u0432\u0442\u043E\u0440\u043E\u043C \u0441\u043B\u043E\u0435 \u043F\u0435\u0447\u0438 \u0432\u043E\u043A\u0440\u0443\u0433 \u0446\u0435\u043D\u0442\u0440\u0430.")),
							false);
				temp = 57005;
				break;
			}
			real_y = real_y + 1;
			if (true) {
				front_block = Blocks.AIR.defaultBlockState();
				front_right_block = Blocks.AIR.defaultBlockState();
				right_block = Blocks.AIR.defaultBlockState();
				behind_right_block = Blocks.AIR.defaultBlockState();
				behind_block = Blocks.AIR.defaultBlockState();
				behind_left_block = Blocks.AIR.defaultBlockState();
				left_block = Blocks.AIR.defaultBlockState();
				front_left_block = Blocks.AIR.defaultBlockState();
				for (int index1 = 0; index1 < 8; index1++) {
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
			if (!(front_block.getBlock() == Blocks.BRICK_SLAB && left_block.getBlock() == Blocks.BRICKS && behind_block.getBlock() == Blocks.BRICKS && front_right_block.getBlock() == Blocks.BRICKS && right_block.getBlock() == Blocks.BRICKS
					&& front_left_block.getBlock() == Blocks.BRICKS && behind_right_block.getBlock() == Blocks.BRICKS && behind_left_block.getBlock() == Blocks.BRICKS)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0422\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044F 7 \u0431\u043B\u043E\u043A\u043E\u0432 \u043A\u0438\u0440\u043F\u0438\u0447\u0430 \u043D\u0430 \u0442\u0440\u0435\u0442\u044C\u0435\u043C \u0441\u043B\u043E\u0435 \u0432\u043E\u043A\u0440\u0443\u0433 \u0446\u0435\u043D\u0442\u0440\u0430 \u0438 \u043E\u0434\u043D\u0430 \u043A\u0438\u0440\u043F\u0438\u0447\u043D\u0430\u044F \u043F\u043B\u0438\u0442\u0430 \u043D\u0430 \u043B\u0438\u0446\u0435\u0432\u043E\u0439 \u0441\u0442\u043E\u0440\u043E\u043D\u0435 \u043F\u0435\u0447\u0438 \u043F\u043E \u0441\u0435\u0440\u0435\u0434\u0438\u043D\u0435 (\u043D\u0430\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u0438\u043D\u0442\u0435\u0440\u0444\u0435\u0439\u0441\u0430 \u043F\u0435\u0447\u0438).")),
							false);
				break;
			}
			real_y = real_y + 1;
			if (!((world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + 1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 0))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + -1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + -1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + -1))).getBlock() == Blocks.BRICKS
					&& (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 0))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 1))).getBlock() == Blocks.BRICKS)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0422\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044F 8 \u0431\u043B\u043E\u043A\u043E\u0432 \u043A\u0438\u0440\u043F\u0438\u0447\u0430 \u043D\u0430 \u0447\u0435\u0442\u0432\u0435\u0440\u0442\u043E\u043C \u0441\u043B\u043E\u0435 \u043F\u0435\u0447\u0438 \u0432\u043E\u043A\u0440\u0443\u0433 \u0446\u0435\u043D\u0442\u0440\u0430.")),
							false);
				break;
			}
			temp = 0;
			for (int index2 = 0; index2 < 3; index2++) {
				real_y = real_y + 1;
				if (!((world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + -1))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 0, real_y, real_z + 1))).getBlock() == Blocks.BRICKS
						&& (world.getBlockState(BlockPos.containing(real_x + -1, real_y, real_z + 0))).getBlock() == Blocks.BRICKS && (world.getBlockState(BlockPos.containing(real_x + 1, real_y, real_z + 0))).getBlock() == Blocks.BRICKS)) {
					temp = 1;
					break;
				}
			}
			if (temp == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0422\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044F \u0442\u0440\u0443\u0431\u0430, \u0441\u043E\u0441\u0442\u043E\u044F\u0449\u0430\u044F \u0438\u0437 4 \u0431\u043B\u043E\u043A\u043E\u0432 \u043A\u0438\u0440\u043F\u0438\u0447\u0430, \u043F\u043E \u043A\u0430\u0436\u0434\u0443\u044E \u0441\u0442\u043E\u0440\u043E\u043D\u0443 \u043E\u0442 \u0441\u0435\u0440\u0435\u0434\u0438\u043D\u044B \u043F\u0435\u0447\u0438, 3 \u0431\u043B\u043E\u043A\u0430 \u0432\u0432\u0435\u0440\u0445 \u043D\u0430\u0447\u0438\u043D\u0430\u044F \u0441 \u043F\u044F\u0442\u043E\u0433\u043E \u0441\u043B\u043E\u044F.")),
							false);
				break;
			}
			temp = 0;
			real_y = real_y + 1;
			for (int index3 = 0; index3 < 7; index3++) {
				if (!((world.getBlockState(BlockPos.containing(real_x, real_y, real_z))).getBlock() == Blocks.AIR)) {
					temp = 1;
					break;
				}
				real_y = real_y - 1;
			}
			if (temp == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u041D\u0435 \u0443\u0434\u0430\u043B\u043E\u0441\u044C \u0441\u043E\u0431\u0440\u0430\u0442\u044C:" + "\n"
							+ "\u0421\u0435\u0440\u0435\u0434\u0438\u043D\u0430 \u043F\u0435\u0447\u0438 \u0434\u043E\u043B\u0436\u043D\u0430 \u043E\u0441\u0442\u0430\u0432\u0430\u0442\u044C\u0441\u044F \u043F\u0443\u0441\u0442\u043E\u0439 \u0438 \u0438\u043C\u0435\u0442\u044C \u043D\u0435\u0437\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u0432\u044B\u0445\u043E\u0434 \u0432\u043E \u0432\u043D\u0435\u0448\u043D\u0438\u044E \u0441\u0440\u0435\u0434\u0443.")),
							false);
				break;
			}
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("FurnaceInterfaceGui");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new FurnaceInterfaceGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}
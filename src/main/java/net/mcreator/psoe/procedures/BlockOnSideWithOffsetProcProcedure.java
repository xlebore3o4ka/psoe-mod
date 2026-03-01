package net.mcreator.psoe.procedures;

import net.minecraft.core.Direction;

public class BlockOnSideWithOffsetProcProcedure {
	public static void execute() {
		Direction dir = Direction.NORTH;
		double dx = 0;
		double dz = 0;
		double offset = 0;
		if (true) {
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
			if (dir == Direction.EAST) {
				dx = 0 - dx;
			} else if (dir == Direction.WEST) {
				dz = 0 - dz;
			} else if (dir == Direction.NORTH) {
				dx = 0 - dx;
				dz = 0 - dz;
			}
		}
	}
}
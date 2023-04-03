package be.pxl.h7.oef4;

public class DirectionUtil {

	public static Direction getOpposite(Direction direction) {
		if (direction == Direction.SOUTH) {
			return Direction.NORTH;
		} else if (direction == Direction.NORTH) {
			return Direction.SOUTH;
		} else if (direction == Direction.WEST) {
			return Direction.EAST;
		} else {
			return Direction.WEST;
		}
	}

}

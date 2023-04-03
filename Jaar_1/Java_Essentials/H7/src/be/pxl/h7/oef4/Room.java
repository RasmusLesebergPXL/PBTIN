package be.pxl.h7.oef4;

public class Room {
    private String name;
    private Room[] doors = new Room[Direction.values().length];

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Room explore(Direction direction) {
        return doors[direction.ordinal()];
    }


    public void setDoor(Direction direction, Room adjacentRoom) {
        if (doors[direction.ordinal()] == null && adjacentRoom.explore(DirectionUtil.getOpposite(direction)) == null) {
            doors[direction.ordinal()] = adjacentRoom;
            adjacentRoom.doors[DirectionUtil.getOpposite(direction).ordinal()] = this;
        } else {
            System.out.println("Room could not be added, direction already taken");
        }
    }

    public String getInstructions() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("== %s ==", name));
        builder.append(System.lineSeparator());
        builder.append("Doors here lead:");
        builder.append(System.lineSeparator());
        for (Direction dir : Direction.values()) {
            if (doors[dir.ordinal()] != null) {
                builder.append(String.format("%s %s%n", dir, doors[dir.ordinal()]));
            }
        }
        return builder.toString();
    }

    public String toString() {
        return name;
    }

}


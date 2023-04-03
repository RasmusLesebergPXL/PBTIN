package be.pxl.h7.oef4;

import java.util.Random;

public class Plant {

	private static final Random RANDOM = new Random();
	public static int MISSION_TARGET;

	/**
	 * A new plant with adjacent rooms is created. There are three types of rooms.
	 *
	 * @return the first room
	 */
	public static Room createPlant() {
		Item stethoscope = new Item("stethoscoop", 350);
		Item mug = new Item("mug", 30);
		Item glass = new Item("glass", 900);
		Item sand = new Item("sand", 300);
		Item horse = new Item("horse", 700);
		Item telescope = new Item("telescope", 420);
		Item brochure = new Item("PXL brochure", 30);
		Room scienceLab = new Laboratory("Science lab", sand, glass);
		Room stables = new TreasureRoom("Stables", horse);
		Room corridor = new Room("Corridor");
		Room observatory = new TreasureRoom("Observatory", telescope);
		Room hallway = new Room("Hallway");
		Room sickBay = new TreasureRoom("Sick bay", stethoscope);
		Room crewQuarters = new TreasureRoom("Crew Quarters", mug);
		Room kitchen = new Room("Kitchen");
		Room studyRoom = new TreasureRoom("Study room", brochure);
		MISSION_TARGET = RANDOM.nextInt(1991) + 30;
		Room securityCheckpoint = new CheckPoint("Security Checkpoint", MISSION_TARGET);
		Room arcade = new TreasureRoom("Arcade", sand);
		hallway.setDoor(Direction.NORTH, crewQuarters);
		hallway.setDoor(Direction.SOUTH, sickBay);
		sickBay.setDoor(Direction.WEST, scienceLab);
		scienceLab.setDoor(Direction.SOUTH, kitchen);
		scienceLab.setDoor(Direction.WEST, stables);
		kitchen.setDoor(Direction.WEST, securityCheckpoint);
		stables.setDoor(Direction.NORTH, corridor);
		corridor.setDoor(Direction.EAST, arcade);
		arcade.setDoor(Direction.EAST, studyRoom);
		arcade.setDoor(Direction.SOUTH, observatory);
		studyRoom.setDoor(Direction.SOUTH, crewQuarters);
		observatory.setDoor(Direction.EAST, crewQuarters);
		System.out.println("You're mission is MIV" + MISSION_TARGET);
		return hallway;
	}
}

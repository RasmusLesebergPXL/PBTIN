package be.pxl.h7.oef4;

import java.util.Scanner;

public class CheckPointGame {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = keyboard.nextLine();
		Player player = new Player(name);
		System.out.printf("Hello, %s%n", name);
		boolean playing = true;
		Room currentRoom = Plant.createPlant();
		while (playing) {
			System.out.println();
			System.out.println(currentRoom.getInstructions());
			System.out.println("Command?");
			currentRoom = executeCommand(keyboard.nextLine(), currentRoom, player);
			if (currentRoom instanceof CheckPoint) {
				boolean sufficientTotalItemValue = ((CheckPoint) currentRoom).checkPointControl(player);
				if (sufficientTotalItemValue) {
					playing = false;
					System.out.println("You collected enough items to leave the plant.");
				}
			}
			if (currentRoom == null) {
				System.out.println("Bye.");
				playing = false;
			}
		}
	}

	/**
	 * Handles the command given the player is in currentRoom.
	 * @param command a command: take, transform, items, north, east, south or west.
	 * @param currentRoom the current room of the player
	 * @param player the player
	 * @return the room where the player is situated after executing the given command.
	 */
	private static Room executeCommand(String command, Room currentRoom, Player player) {
		command = command.trim().toUpperCase();
		if ("TAKE".equals(command)) {
			if (currentRoom instanceof TreasureRoom) {
				((TreasureRoom) currentRoom).takeItem(player);
			}
			return currentRoom;
		}
		if ("TRANSFORM".equals(command)){
			if (currentRoom instanceof Laboratory) {
				((Laboratory) currentRoom).transform(player);
			}
			return currentRoom;
		}
		if ("ITEMS".equals(command)) {
			player.displayItems();
			return currentRoom;
		}
		if (isDirection(command)){
			Room explore = currentRoom.explore(Direction.valueOf(command));
			if (explore == null) {
				System.out.println("You can't go that way.");
				return currentRoom;
			} else {
				return explore;
			}
		}
		if ("EXIT".equals(command)) {
			return null;
		}
		if ("MISSION".equals(command)) {
			System.out.println(Plant.MISSION_TARGET);
			return currentRoom;
		}
		if ("WHOAMI".equals(command)) {
			System.out.println(player.getName());
			return currentRoom;

		}
		System.out.println("Unknown command.");
		return currentRoom;
	}

	private static boolean isDirection(String input) {
		for (Direction direction : Direction.values()) {
			if (direction.name().equals(input)) {
				return true;
			}
		}
		return false;
	}
}

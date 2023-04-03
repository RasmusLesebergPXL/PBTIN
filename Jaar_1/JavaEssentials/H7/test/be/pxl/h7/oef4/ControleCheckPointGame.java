package be.pxl.h7.oef4;

import java.lang.reflect.Field;

public class ControleCheckPointGame {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		Player player = new Player("Tester");
		int score = 50;
		Room currentRoom = Plant.createPlant();
		currentRoom = executeCommand("north", currentRoom, player);
		if (!currentRoom.getName().equals("Crew Quarters")) {
			System.out.println("Not arrived in crew quarters");
			score -= 5;
		}
		int prevValue = player.getTotalValue();
		currentRoom = executeCommand("take", currentRoom, player);
		if (player.getTotalValue() != prevValue + 30) {
			System.out.println("Mug not taken.");
			score -= 5;
		}
		currentRoom = executeCommand("north", currentRoom, player);
		if (!currentRoom.getName().equals("Study room")) {
			System.out.println("Not arrived in study room");
			score -= 5;
		}
		prevValue = player.getTotalValue();
		currentRoom = executeCommand("take", currentRoom, player);
		if (player.getTotalValue() != prevValue + 30) {
			System.out.println("PXL brochure not taken.");
			score -= 5;
		}
		currentRoom = executeCommand("west", currentRoom, player);
		if (!currentRoom.getName().equals("Arcade")) {
			System.out.println("Not arrived in arcade");
			score -= 5;
		}
		prevValue = player.getTotalValue();
		currentRoom = executeCommand("take", currentRoom, player);
		if (player.getTotalValue() != prevValue + 300) {
			System.out.println("Sand not taken.");
			score -= 5;
		}
		currentRoom = executeCommand("west", currentRoom, player);
		if (!currentRoom.getName().equals("Corridor")) {
			System.out.println("Not arrived in corridor.");
			score -= 5;
		}
		currentRoom = executeCommand("south", currentRoom, player);
		if (!currentRoom.getName().equals("Stables")) {
			System.out.println("Not arrived in stables.");
			score -= 5;
		}
		currentRoom = executeCommand("east", currentRoom, player);
		if (!currentRoom.getName().equals("Science lab")) {
			System.out.println("Not arrived in stables.");
			score -= 5;
		}
		prevValue = player.getTotalValue();
		currentRoom = executeCommand("transform", currentRoom, player);
		if (player.getTotalValue() != prevValue + 600) { // -300 sand + 900 glass
			System.out.println("Sand not transformed.");
			score -= 10;
		}
		currentRoom = executeCommand("south", currentRoom, player);
		if (!currentRoom.getName().equals("Kitchen")) {
			System.out.println("Not arrived in kitchen.");
			score -= 5;
		}
		currentRoom = executeCommand("west", currentRoom, player);
		if (!currentRoom.getName().equals("Security Checkpoint")) {
			System.out.println("Not arrived in security checkpoint.");
			score -= 5;
		} else {
			CheckPoint checkPoint = (CheckPoint) currentRoom;
			Field valueNeededField = checkPoint.getClass().getDeclaredField("valueNeeded");
			valueNeededField.setAccessible(true);
			valueNeededField.setInt(checkPoint, player.getTotalValue());
			if (!checkPoint.checkPointControl(player)) {
				System.out.println("Should always pass security checkpoint.");
				score -= 10;
			}
			valueNeededField.setInt(checkPoint, player.getTotalValue() + 1);
			if (checkPoint.checkPointControl(player)) {
				System.out.println("Should not pass security checkpoint.");
				score -= 10;
			}
		}
		System.out.println(Math.max(0, score) + " / 50");
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

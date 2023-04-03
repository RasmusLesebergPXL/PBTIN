package be.pxl.h7.oef4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomTest {

	private Room kitchen = new Room("Kitchen");
	private Room garage = new Room("Garage");
	private Room livingRoom = new Room("Living Room");

	@BeforeEach
	public void init() {
		kitchen.setDoor(Direction.EAST, garage);
		kitchen.setDoor(Direction.WEST, livingRoom);
	}

	@Test
	public void getInstructionsTest() {
		String instructions = kitchen.getInstructions();
		assertTrue(instructions.contains("EAST Garage"));
		assertTrue(instructions.contains("WEST Living Room"));
	}

	@Test
	public void getNameTest() {
		assertEquals("Living Room", livingRoom.getName());
	}

}

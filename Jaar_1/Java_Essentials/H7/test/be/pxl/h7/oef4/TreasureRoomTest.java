package be.pxl.h7.oef4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureRoomTest {
	private TreasureRoom room;
	private Player player;
	private Item treasure = new Item("Treasure", 5);

	@BeforeEach
	public void init() {
		room = new TreasureRoom("Treasure Room", treasure);
		player = new Player("Tester");
	}


	@Test
	public void getInstructions() {
		String instructions = room.getInstructions();
		assertTrue(instructions.contains("TAKE Treasure (5)"));
	}

	@Test
	public void getInstructionsWhenItemIsTaken() {
		room.takeItem(player);
		String instructions = room.getInstructions();
		assertFalse(instructions.contains("TAKE"));
	}

	@Test
	public void playerCanTakeItem() {
		assertEquals(0, player.getTotalValue());
		room.takeItem(player);
		assertEquals(5, player.getTotalValue());
	}

	@Test
	public void playerCanTakeItemOnce() {
		assertEquals(0, player.getTotalValue());
		room.takeItem(player);
		assertEquals(5, player.getTotalValue());
		room.takeItem(player);
		assertEquals(5, player.getTotalValue());
	}

	@Test
	public void toStringWhenItemAvailable() {
		assertEquals("Treasure Room*", room.toString());
	}

	@Test
	public void toStringWhenItemNotAvailable() {
		room.takeItem(player);
		assertEquals("Treasure Room", room.toString());
	}

}

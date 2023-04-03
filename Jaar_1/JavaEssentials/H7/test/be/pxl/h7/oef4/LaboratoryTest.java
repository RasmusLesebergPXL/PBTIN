package be.pxl.h7.oef4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaboratoryTest {

	private Laboratory laboratory;
	private Player player;
	private Item in = new Item("In", 5);

	@BeforeEach
	public void init() {
		laboratory = new Laboratory("MyLab", in, new Item("Out", 10));
		player = new Player("Tester");
	}


	@Test
	public void getInstructions() {
		String instructions = laboratory.getInstructions();
		assertTrue(instructions.contains("TRANSFORM In (5) -> Out (10)"));
	}

	@Test
	public void transformWhenPlayerHasItem() {
		player.addItem(in);
		laboratory.transform(player);
		assertEquals(10, player.getTotalValue());
	}

	@Test
	public void transformWhenPlayerHasItemNot() {
		player.addItem(new Item("Something", 8));
		laboratory.transform(player);
		assertEquals(8, player.getTotalValue());
	}

}

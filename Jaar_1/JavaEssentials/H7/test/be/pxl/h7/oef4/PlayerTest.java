package be.pxl.h7.oef4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

	private Player player;

	@BeforeEach
	public void init() {
		player = new Player("Tester");
	}

	@Test
	public void returnsZeroWhenNoItems() {
		assertEquals(0, player.getTotalValue());
	}

	@Test
	public void returnSumOfAllItemValues() {
		player.addItem(new Item("Item 1", 2));
		player.addItem(new Item("Item 2", 4));
		player.addItem(new Item("Item 3", 6));
		player.addItem(new Item("Item 4", 8));
		assertEquals(20, player.getTotalValue());
	}

	@Test
	public void displayItemsTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		player.addItem(new Item("Item 1", 20));
		player.addItem(new Item("Item 2", 4));
		player.displayItems();
		System.out.flush();
		String result = baos.toString();
		assertTrue(result.contains("Item 1 (20)"));
		assertTrue(result.contains("Item 2 (4)"));
		assertTrue(result.contains("24"));
	}

	@Test
	public void isTotalValueSufficientReturnsTrueIfSufficient() {
		player.addItem(new Item("Item 1", 20));
		player.addItem(new Item("Item 2", 4));
		assertTrue(player.isTotalValueSufficient(24));
	}

	@Test
	public void isTotalValueSufficientReturnsTrueIfNotSufficient() {
		player.addItem(new Item("Item 1", 20));
		player.addItem(new Item("Item 2", 4));
		assertFalse(player.isTotalValueSufficient(25));
	}

	@Test
	public void itemCanBeReplacedCorrectly() {
		player.addItem(new Item("Item 1", 2));
		player.addItem(new Item("Item 2", 4));
		Item itemOut = new Item("Item 3", 6);
		player.addItem(itemOut);
		player.addItem(new Item("Item 4", 8));
		assertEquals(20, player.getTotalValue());
		player.replaceItem(itemOut, new Item("Item 5", 12));
		assertEquals(26, player.getTotalValue());
	}

	@Test
	public void getNameTest() {
		assertEquals("Tester", player.getName());
	}

}

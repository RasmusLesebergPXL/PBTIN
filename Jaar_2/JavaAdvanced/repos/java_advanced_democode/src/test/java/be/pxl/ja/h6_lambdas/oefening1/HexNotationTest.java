package be.pxl.ja.h6_lambdas.oefening1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HexNotationTest {

	private static final int[] NUMBERS_INPUT = new int[] { 1, 17, 132 };
	private static final String EXPECTED_OUTPUT = "1-11-84";

	@Test
	public void hexNotationUsedForInts() {
		NumberMachine machine = new NumberMachine(NUMBERS_INPUT);
		NumberSelector selector = new NumberSelector(machine);

		assertEquals(EXPECTED_OUTPUT, selector.printHexNumbers());
	}
}

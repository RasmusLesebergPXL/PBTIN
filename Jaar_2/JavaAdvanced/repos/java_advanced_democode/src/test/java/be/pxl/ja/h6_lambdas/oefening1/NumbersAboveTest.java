package be.pxl.ja.h6_lambdas.oefening1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersAboveTest {

	private static final int[] NUMBERS_INPUT = new int[] { 25, 3, 8, 18, 19, 66, 21, 36 };
	private static final int NUMBER_LIMIT_1 = 20;
	private static final int NUMBER_LIMIT_2 = 25;
	private static final String EXPECTED_OUTPUT_1 = "25-66-21-36";
	private static final String EXPECTED_OUTPUT_2 = "66-36";

	@Test
	public void onlyBiggerNumbersAreShown() {
		NumberMachine machine = new NumberMachine(NUMBERS_INPUT);
		NumberSelector selector = new NumberSelector(machine);

		assertEquals(EXPECTED_OUTPUT_1, selector.showNumbersAbove(NUMBER_LIMIT_1));
	}

	@Test
	public void greaterThanIsExclusive() {
		NumberMachine machine = new NumberMachine(NUMBERS_INPUT);
		NumberSelector selector = new NumberSelector(machine);

		assertEquals(EXPECTED_OUTPUT_2, selector.showNumbersAbove(NUMBER_LIMIT_2));
	}
}

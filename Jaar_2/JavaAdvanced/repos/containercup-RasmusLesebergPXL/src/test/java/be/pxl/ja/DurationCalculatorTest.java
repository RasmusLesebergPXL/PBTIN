package be.pxl.ja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurationCalculatorTest {

	private DurationCalculator durationCalculator;

	@BeforeEach
	public void init() {
		durationCalculator = new DurationCalculator();
	}

	@Test
	public void testPlus() {
		durationCalculator.plus(Duration.ofSeconds(5));
		durationCalculator.plus(Duration.ofSeconds(3));

		assertEquals(Duration.ofSeconds(8), durationCalculator.getResult());
	}

	@Test
	public void testMinus() {
		durationCalculator.plus(Duration.ofSeconds(5));
		durationCalculator.minus(Duration.ofSeconds(3));

		assertEquals(Duration.ofSeconds(2), durationCalculator.getResult());
	}

	@Test
	public void testMinusGenericWithString() {
		durationCalculator.plus(Duration.ofSeconds(10));
		Function<String, Duration> stringLengthDuration = s -> Duration.ofSeconds(s.length());
		durationCalculator.minus("abcd", stringLengthDuration);
		durationCalculator.minus("xy", stringLengthDuration);

		assertEquals(Duration.ofSeconds(4), durationCalculator.getResult());
	}

	@Test
	public void testMinusGenericWithInteger() {
		durationCalculator.plus(Duration.ofSeconds(20));
		Function<Integer, Duration> kwadraat = i -> Duration.ofSeconds(i * i);
		durationCalculator.minus(2, kwadraat);
		durationCalculator.minus(3, kwadraat);

		assertEquals(Duration.ofSeconds(7), durationCalculator.getResult());
	}



}

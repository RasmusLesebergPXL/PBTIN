package be.pxl.ja;

import java.time.Duration;
import java.util.function.Function;

public class DurationCalculator {

	private Duration value = Duration.ZERO;

	public void minus(String type, Function<String, Duration> stringLengthDuration) {
		stringLengthDuration = s -> Duration.ofSeconds(s.length());
		Duration duration = stringLengthDuration.apply(type);
		value = value.minus(duration);
	}

	public void minus(int number, Function<Integer, Duration> intLengthDuration) {
		intLengthDuration = i -> Duration.ofSeconds(i * i);
		Duration duration = intLengthDuration.apply(number) ;
		value = value.minus(duration);
	}

	public void minus(Duration duration) {
		value = value.minus(duration);
	}

	public void plus(Duration duration) {
		value = value.plus(duration);
	}

	public Duration getResult() {
		return value;
	}
}

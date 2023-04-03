package be.pxl.ja.h6_lambdas.demo9;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Weights {

	private List<Double> weigths = Arrays.asList(87.5, 87.3, 88.1, 87.7, 87.4, 86.6);


	public void roundWeights(Function<Double, Integer> rounder) {
		for (double weight : weigths) {
			int intValue = rounder.apply(weight);
			System.out.println("Rounded " + weight + ": " + intValue);
		}
	}

	public void consumeWeights(Consumer<Double> consumer) {
		for (double weight : weigths) {
			consumer.accept(weight);
		}
	}
}

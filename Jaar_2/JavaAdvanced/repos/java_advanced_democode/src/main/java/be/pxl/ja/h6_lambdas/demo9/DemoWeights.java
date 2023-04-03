package be.pxl.ja.h6_lambdas.demo9;

public class DemoWeights {

	public static void main(String[] args) {
		Weights weights = new Weights();
		System.out.println("Rounding down");
		weights.roundWeights(d -> Double.valueOf(Math.floor(d)).intValue());

		System.out.println("Rounding up");
		weights.roundWeights(d -> Double.valueOf(Math.ceil(d)).intValue());

		System.out.println("Displaying");
		weights.consumeWeights(d -> System.out.println(String.format("%.2f", d)));
	}
}

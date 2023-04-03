package be.pxl.ja.h6_lambdas.demo10;

import be.pxl.ja.h6_lambdas.demo4.Document;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

public class MethodReferenceDemo {

	public static void main(String[] args) {

		System.out.println("Static method");
		IntBinaryOperator min = (x, y) -> Math.min(x, y);
		IntBinaryOperator max = Math::max;

		System.out.println(min.applyAsInt(-3, 17));
		System.out.println(max.applyAsInt(-3, 17));

		System.out.println("Instance method (unbounded)");
		Function<String, String> toUpperCase = s -> s.toUpperCase();
		Function<String, String> toLowerCase = String::toLowerCase;
		System.out.println(toUpperCase.apply("abcdef"));
		System.out.println(toLowerCase.apply("ABCDEF"));

		System.out.println("Constructor");
		Supplier<Random> randomCreator = Random::new;
		Random random = randomCreator.get();

		Function<Integer, ArrayList<Document>> movieListCreator = ArrayList::new;
		ArrayList<Document> documentList = movieListCreator.apply(120);

		System.out.println("Instance method (bounded)");
		IntSupplier randomInt = random::nextInt;
		IntUnaryOperator randomIntWithBound = random::nextInt;
		System.out.println(randomInt.getAsInt());
		System.out.println(randomIntWithBound.applyAsInt(12));
	}
}

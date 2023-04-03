package be.pxl.ja.h6_lambdas.demo8;

import java.util.function.Predicate;

public class DemoNames {

	public static void main(String[] args) {
		PrincessNames princessNames = new PrincessNames();
		System.out.println("Filter 1");
		princessNames.filterNames((n) -> n.contains("o"));
		System.out.println("Filter 2");
		Predicate<String> length5 = (n) -> n.length() == 5;
		princessNames.filterNames(length5);
		System.out.println("Filter 3");
		Predicate<String> startsWithA = (n) -> n.startsWith("A");
		princessNames.filterNames(startsWithA.and(length5));
	}

}

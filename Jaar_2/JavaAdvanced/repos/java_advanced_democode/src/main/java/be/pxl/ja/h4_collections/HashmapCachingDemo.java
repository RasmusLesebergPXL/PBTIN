package be.pxl.ja.h4_collections;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashmapCachingDemo {
	private Map<Integer, BigDecimal> cache = new HashMap<>();

	public static void main(String[] args) {
		HashmapCachingDemo hashmapCachingDemo = new HashmapCachingDemo();
		System.out.println("Van welk getal wil je de faculteit berekenen?");
		System.out.println("Geef 0 of een negatief getal om te stoppen.");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		while (number > 0) {
			BigDecimal faculty = hashmapCachingDemo.calculateFaculty(number);
			System.out.println(faculty);
			System.out.println("Van welk getal wil je de faculteit berekenen?");
			number = scanner.nextInt();
		}
	}

	public BigDecimal calculateFaculty(int number) {
		if (cache.containsKey(number)) {
			return cache.get(number);
		}
		BigDecimal result = BigDecimal.ONE;
		BigDecimal multiplier = BigDecimal.valueOf(2);
		while (multiplier.compareTo(BigDecimal.valueOf(number)) <= 0) {
			result = result.multiply(multiplier);
			multiplier = multiplier.add(BigDecimal.ONE);
		}
		cache.put(number, result);
		return result;
	}

}

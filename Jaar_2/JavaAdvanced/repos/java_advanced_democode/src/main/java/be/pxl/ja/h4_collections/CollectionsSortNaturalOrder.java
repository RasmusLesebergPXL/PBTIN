package be.pxl.ja.h4_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSortNaturalOrder {

	public static void main(String[] args) {
		List<Integer> points = Arrays.asList(-5, 5, 7, -3, 10, 9, -9, 8, 4, 8);
		System.out.println("Max: " + Collections.max(points));
		System.out.println("Min: " + Collections.min(points));
		Collections.sort(points);
		System.out.println(points);
		// ADD when we study lambda expressions
		//Collections.sort(points, (x,y) -> Math.abs(x) - Math.abs(y));
		//System.out.println(points);
	}
}

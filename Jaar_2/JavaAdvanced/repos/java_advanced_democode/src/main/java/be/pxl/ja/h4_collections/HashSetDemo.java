package be.pxl.ja.h4_collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Set<String> daysOfWeek = new HashSet<>();

		// Adding new elements to the HashSet
		daysOfWeek.add("Monday");
		daysOfWeek.add("Tuesday");
		daysOfWeek.add("Wednesday");
		daysOfWeek.add("Thursday");
		daysOfWeek.add("Friday");
		daysOfWeek.add("Saturday");
		daysOfWeek.add("Sunday");

		// Adding null is allowed
		daysOfWeek.add(null);

		// Adding duplicate elements will be ignored
		daysOfWeek.add("Monday");

		System.out.println(daysOfWeek);
	}

}

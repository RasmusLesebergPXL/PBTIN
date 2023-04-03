package be.pxl.ja.h5_generics.demo5;

import java.util.List;

public class OccurenceUtil {

	public static <T> boolean occursExactTimes(List<T> items, T item, int times) {
		int count = 0;
		for (T anItem : items) {
			if (anItem.equals(item)) {
				count++;
			}
		}
		return count == times;
	}

	public static <T extends Comparable<T>> int countSmaller(List<T> items, T item) {
		int countSmaller = 0;
		for (T anItem : items) {
			if (anItem.compareTo(item) < 0) {
				countSmaller++;
			}
		}
		return countSmaller;
	}

}

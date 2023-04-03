package be.pxl.ja.h4_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayListVsLinkedList {

	private static final int ITEMS = 9999999;

	public static void main(String[] args) {
		List<String> data1 = new ArrayList<>();
		List<String> data2 = new LinkedList<>();

		for (int i = 0; i < ITEMS; i++) {
			String e = generateString(8);
			data1.add(e);
			data2.add(e);
		}

		add(data1, 0, "first");
		add(data2, 0, "first");
		add(data1, ITEMS/2, "middle");
		add(data2, ITEMS/2, "middle");
		add(data1, ITEMS, "last");
		add(data2, ITEMS, "last");

		indexOf(data1, "first");
		indexOf(data2, "first");
		indexOf(data1, "middle");
		indexOf(data2, "middle");
		indexOf(data1, "last");
		indexOf(data2, "last");

		get(data1, 0);
		get(data2, 0);
		get(data1, data1.size() / 2);
		get(data2, data2.size() / 2);
		get(data1, data1.size() - 1);
		get(data2, data2.size() - 1);

		remove(data1, "first");
		remove(data2, "first");
		remove(data1, "middle");
		remove(data2, "middle");
		remove(data1, "last");
		remove(data2, "last");

		remove(data1, 0);
		remove(data2, 0);
		remove(data1, data1.size() / 2);
		remove(data2, data2.size() / 2);
		remove(data1, data1.size() - 1);
		remove(data2, data2.size() - 1);

		data1 = new ArrayList<>(data1.subList(0, ITEMS / 10));
		data2 = new LinkedList<>(data2.subList(0, ITEMS / 10));
		removeAllStartingWithA(data1);
		removeAllStartingWithA(data2);
	}

	public static void remove(List<String> data, String value) {
		long start = System.currentTimeMillis();
		boolean removed = data.remove(value);
		long time = System.currentTimeMillis() - start;
		System.out.println(data.getClass().getSimpleName() + ": " + value + " removed in " + time + "ms");
	}

	public static void get(List<String> data, int index) {
		long start = System.currentTimeMillis();
		String result = data.get(index);
		long time = System.currentTimeMillis() - start;
		System.out.println(data.getClass().getSimpleName() + ": " + result + " at index " + index + " found  in " + time + "ms");
	}

	public static void remove(List<String> data, int index) {
		long start = System.currentTimeMillis();
		String remove = data.remove(index);
		long time = System.currentTimeMillis() - start;
		System.out.println(data.getClass().getSimpleName() + ": " + remove + " removed from index " + index + " in " + time + "ms");
	}

	public static void removeAllStartingWithA(List<String> data) {
		long start = System.currentTimeMillis();
		Iterator<String> iterator = data.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().startsWith("a")) {
				iterator.remove();
			}
		}
		long time = System.currentTimeMillis() - start;
		System.out.println(data.getClass().getSimpleName() + ": remove starting with a in " + time + "ms");
	}

	public static void add(List<String> data, int index, String value) {
		long start = System.currentTimeMillis();
		data.add(index, value);
		long time = System.currentTimeMillis() - start;
		System.out.println(data.getClass().getSimpleName() + ": " + value + " added at  " + index + " in " + time + "ms");
	}

	public static void indexOf(List<String> data, String value) {
		long start = System.currentTimeMillis();
		int i = data.indexOf(value);
		long time = System.currentTimeMillis() - start;
		System.out.println(data.getClass().getSimpleName() + ": " + value + " found at index " + i + " in " + time + "ms");
	}


	public static String generateString(int length) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}

}

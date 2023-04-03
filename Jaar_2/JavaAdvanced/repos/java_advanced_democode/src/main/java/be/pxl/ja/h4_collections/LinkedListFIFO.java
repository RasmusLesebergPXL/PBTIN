package be.pxl.ja.h4_collections;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListFIFO {

	public static void main(String[] args) {
		Queue<String> elements = new LinkedList<>();
		elements.offer("One");
		elements.offer("One");
		elements.offer("Two");
		elements.offer(null);
		elements.offer("Three");

		while (!elements.isEmpty()) {
			System.out.println(elements.remove());
		}
	}
}

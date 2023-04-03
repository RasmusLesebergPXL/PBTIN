package be.pxl.ja.h4_collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListLIFO {

	public static void main(String[] args) {
		Deque<String> elements = new LinkedList<>();
		elements.push("One");
		elements.push("One");
		elements.push("Two");
		elements.push(null);
		elements.push("Three");

		while (!elements.isEmpty()) {
			System.out.println(elements.pop());
		}

		/* Question: what happens if you replace LinkedList with ArrayDeque? */
	}

}

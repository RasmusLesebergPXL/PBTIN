package be.pxl.ja.h4_collections;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {

		PriorityQueue<String> namePriorityQueue = new PriorityQueue<>();

		namePriorityQueue.offer("Lisa");
		namePriorityQueue.add("Robert");
		namePriorityQueue.offer("John");
		namePriorityQueue.add("Chris");
		namePriorityQueue.add("Angelina");
		namePriorityQueue.add("Joe");

		while (!namePriorityQueue.isEmpty()) {
			System.out.println(namePriorityQueue.peek());
			System.out.println(namePriorityQueue.poll());
		}

	}
}


package be.pxl.ja.h4_collections;

import java.util.HashMap;
import java.util.Map;

public class PhonebookDemo {

	public static void main(String[] args) {
		Map<String,String> phoneBook = new HashMap<>();
		phoneBook.put("Ben", "+32 11 77 55 10");
		phoneBook.put("Gerrit", "+32 11 77 55 16");
		phoneBook.put("Rudy", "+ 32 11 77 56 91");
		phoneBook.put("Heidi", "+32 11 77 58 01");

		System.out.println(phoneBook.get("Ben"));
		System.out.println(phoneBook.containsKey("Els"));
		System.out.println(phoneBook.values());
	}
}

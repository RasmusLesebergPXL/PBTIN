package be.pxl.ja.h5_generics.demo1;

import java.util.ArrayList;
import java.util.Iterator;

public class SinceGenerics {

	public static void main(String[] args) {

		ArrayList<Double> objecten = new ArrayList<>();
		objecten.add((double) 1);
		objecten.add(5.4);
		//objecten.add(new Movie("Inception", Rating.MATURE));

		Iterator<Double> iterator = objecten.iterator();
		double total = 0;
		while (iterator.hasNext()) {
			total += iterator.next();
		}
		System.out.println(total);
	}
}

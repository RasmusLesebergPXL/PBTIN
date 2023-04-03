package be.pxl.ja.h5_generics.demo7;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureDemo {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Float> list2 = new ArrayList<>();
		if (list1.getClass() == list2.getClass()) {
			System.out.println("Lists have same class.");
		}
	}
}

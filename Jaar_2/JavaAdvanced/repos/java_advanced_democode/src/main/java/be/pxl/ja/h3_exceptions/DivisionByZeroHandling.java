package be.pxl.ja.h3_exceptions;

public class DivisionByZeroHandling {

	public static void main(String[] args) {
		int a = (1 + 1) % 2;
		int b = 5;
		try {
			int c = b / a;
			System.out.println("Het resultaat is " + c);
		} catch (ArithmeticException e) {
			System.out.println("You should not divide a number by zero");
		}
		System.out.println("First catch completed!");
	}
}

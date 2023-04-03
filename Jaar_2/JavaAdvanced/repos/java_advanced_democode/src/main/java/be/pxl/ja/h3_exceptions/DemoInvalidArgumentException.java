package be.pxl.ja.h3_exceptions;

public class DemoInvalidArgumentException {

	public static void main(String[] args) {
		String tekst = "abc";
		System.out.println(tekst.repeat(-5));
	}
}

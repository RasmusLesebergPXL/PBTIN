package be.pxl.ja.h9_multithreading.synchronisatie;


import java.util.Arrays;

public class KoekjesEten {

	public static void main(String[] args) {
		Koekjesdoos koekjesdoos = new Koekjesdoos(50);
		Kind[] kinderen = { new Kind("Bram", koekjesdoos),
				new Kind("Sophie", koekjesdoos),
				new Kind("Elke", koekjesdoos),
				new Kind("Robin", koekjesdoos),
				new Kind("Sammy", koekjesdoos),
				new Kind("Max", koekjesdoos) };
		for (Kind item : kinderen) {
			item.start();
		}
		for (Kind value : kinderen) {
			try {
				value.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("De kinderen aten: " +
				Arrays.stream(kinderen)
						.mapToInt(Kind::getAantalKoekjes)
						.sum());
	}
}

package be.pxl.ja.h8_files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Demo07BufferedWriter {

	private static final Random RANDOM = new Random();

	public static void main(String[] args) {

		int numberOfBugs = 99;

		try (BufferedWriter writer =  Files.newBufferedWriter(Paths.get("src/main/resources/h8/poem.txt"))) {
			for (int i =0; i < 5; i++) {
				writer.write(numberOfBugs + " little bugs in the code,\n");
				writer.write(numberOfBugs + " little bugs in the code.\n");
				writer.write("Take one down, patch it around,\n");
				numberOfBugs += RANDOM.nextInt(50) ;
				writer.write(numberOfBugs + " little bugs in the code.\n");
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

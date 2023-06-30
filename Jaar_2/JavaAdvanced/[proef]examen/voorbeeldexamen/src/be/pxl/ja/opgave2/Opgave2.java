package be.pxl.ja.opgave2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Opgave2 {
	public static void main(String[] args) {
		try {
			int aantalValid = 0;
			BufferedReader reader = Files.newBufferedReader(Path.of("resources", "opgave2", "passphrases.txt"));
			String line;
			while ((line = reader.readLine()) != null)
			{
				try {
					String[] passPhrase = line.split(" ");
					PassPhraseValidator<Object> validator = new PassPhraseValidator<>(Arrays.asList(passPhrase));
					validator.start();
					if (validator.isValid()) {
						aantalValid++;
					}
					validator.join();
				}
				catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			reader.close();
			System.out.println("Aantal valid passphrases: " + aantalValid);
		} catch (IOException e) {
			e.getStackTrace();
			System.err.println(e.getMessage());
		}
	}
}

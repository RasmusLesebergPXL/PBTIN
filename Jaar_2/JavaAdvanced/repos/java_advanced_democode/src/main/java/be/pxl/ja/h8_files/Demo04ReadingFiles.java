package be.pxl.ja.h8_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Demo04ReadingFiles {
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		Path path = Paths.get("resources/small_file_with_text.txt");

		try {
			List<String> text = Files.readAllLines(path);
			System.out.println(text.get(RANDOM.nextInt(text.size())));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

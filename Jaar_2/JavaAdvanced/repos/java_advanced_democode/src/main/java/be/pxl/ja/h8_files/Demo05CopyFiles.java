package be.pxl.ja.h8_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo05CopyFiles {

	public static void main(String[] args) {
		Path original = Paths.get("src/main/resources/h8/small_file_with_text.txt");
		Path copy = Paths.get("src/main/resources/h8/", "copy_" + System.currentTimeMillis() + ".txt");
		System.out.println(Files.exists(copy));
		try {
			Files.copy(original, copy);
			System.out.println(Files.exists(copy));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

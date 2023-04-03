package be.pxl.ja.h8_files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo06BufferedReader {

	public static void main(String[] args) {

		try (BufferedReader reader =  Files.newBufferedReader(Paths.get("src/main/resources/h8/small_file_with_text.txt"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

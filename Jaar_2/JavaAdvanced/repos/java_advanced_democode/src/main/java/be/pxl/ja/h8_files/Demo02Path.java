package be.pxl.ja.h8_files;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Demo02Path {

	public static void main(String[] args) {
		FileSystem defaultFileSystem = FileSystems.getDefault();
		System.out.println(defaultFileSystem.getClass());
		for (Path rootDirs: defaultFileSystem.getRootDirectories()) {
			System.out.println(rootDirs);
		}
		Path srcDir = Path.of(System.getProperty("user.dir"), "src");
		System.out.println(srcDir.toAbsolutePath());
		System.out.println(srcDir.getClass().getName());
		System.out.println(Files.isDirectory(srcDir));
	}

}

package be.pxl.ja.h8_files;

public class Demo01SystemProperties {

	public static final String SEPARATOR = System.getProperty("file.separator");

	public static void main(String[] args) {
		System.out.println("Current operating system: " + System.getProperty("os.name"));
		System.out.println("File separator: " + SEPARATOR);
		System.out.println("User's home directory: " + System.getProperty("user.home"));
		System.out.println("Current working directory: " + System.getProperty("user.dir"));
	}
}

package be.pxl.ja.h8_files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;

public class Demo09ProgramWithProperties {
	private static final String CONFIG_FILE = "src/main/resources/h8/config.properties";

	public static void main(String[] args) {
		try(InputStream inputStream = Files.newInputStream(Path.of(CONFIG_FILE))) {
			Properties properties = new Properties();
			properties.load(inputStream);
			System.out.println("Welcome " + properties.getProperty("name") + "!");
			System.out.println("You're mails will be sent to: " + properties.getProperty("email"));
		} catch (IOException e) {
			createProperties();
		}

	}

	private static void createProperties() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("You're using this program for the first time.");
		System.out.println("What's your name:");
		String name = scanner.nextLine();
		System.out.println("What's your company:");
		String company = scanner.nextLine();
		System.out.println("What's your email:");
		String email = scanner.nextLine();
		Properties properties = new Properties();
		properties.setProperty("name", name);
		properties.setProperty("company", company);
		properties.setProperty("email", email);
		try(OutputStream outputStream = Files.newOutputStream(Path.of(CONFIG_FILE))) {
			properties.store(outputStream, "Demo program configuration");
		}
		catch (IOException e) {
			System.out.println("We were not able to save your configuration.");
		}

	}

}

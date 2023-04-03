package be.pxl.ja.h8_files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Demo11Deserialization {

	public static void main(String[] args) {
		try (FileInputStream file = new FileInputStream(
				"src/main/resources/h8/demo.ser");
		     ObjectInputStream in = new ObjectInputStream(file)) {
			Student student = (Student) in.readObject();
			System.out.println(student.getName());
			System.out.println(student.getDateOfBirth());
			List<?> animals = (List<?>) in.readObject();
			//List<String> animals = (List<String>) in.readObject();
			System.out.println(animals.size());
			System.out.println(animals.get(0));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


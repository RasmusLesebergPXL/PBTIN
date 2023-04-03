package be.pxl.ja.h8_files;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {

	private String name;
	private LocalDate graduationDate;
	private transient LocalDate dateOfBirth;

	public Student(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public String getName() {
		return name;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
}

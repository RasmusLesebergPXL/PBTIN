package be.pxl.ja.h9_multithreading.streams;

public class Employee {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}
}

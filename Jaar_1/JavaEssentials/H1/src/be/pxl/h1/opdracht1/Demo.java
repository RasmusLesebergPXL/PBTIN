package be.pxl.h1.opdracht1;

public class Demo {
    public static void main(String[] args) {
        int number;
        number = 5;
        int sum = number + 2;
        double salary = 1234.5;
        long bigNumber = 123456789123456789L;
        number = (int) salary;
        System.out.println("Salary: " + number);
        number = (int) bigNumber;
        System.out.println("Big number: " + number);
        char letter = 'a';
        boolean geslaagd = true;
        String text = "Goedenacht!";
    }
}


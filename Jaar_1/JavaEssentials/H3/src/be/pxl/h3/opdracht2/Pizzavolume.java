package be.pxl.h3.opdracht2;

import java.util.Scanner;

public class Pizzavolume {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de straal van de pizza: ");
        double straal = input.nextDouble();
        input.nextLine();
        System.out.println(Math.round(Math.PI * Math.pow(straal, 2) * 100) / 100.0);

    }
}

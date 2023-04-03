package be.pxl.h1.oefextra1;

import java.util.Scanner;

public class XShapeApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een getal tussen 5 en 49: ");
        int getal = input.nextInt();
        input.nextLine();
        while ((getal < 5 | getal > 49) | getal % 2 == 0) {
            System.out.println("Het getal moet groter zijn dan 5 of kleiner dan 49, en oneven: ");
            getal = input.nextInt();
        }

        for (int row = 0; row < getal; row++) {
            for (int col = 0; col < getal; col++) {
                if (row == col || row + col == getal -1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


}

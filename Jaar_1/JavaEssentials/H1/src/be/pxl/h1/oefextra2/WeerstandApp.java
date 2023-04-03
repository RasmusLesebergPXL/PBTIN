package be.pxl.h1.oefextra2;

import java.util.Scanner;

public class WeerstandApp {
    public static void main(String[] args) {
        Weerstand weerstand = new Weerstand();
        Scanner input = new Scanner(System.in);

        System.out.println("Geef de karakter voor het eerste band:  ");
        char band1 = input.next().charAt(0);
        weerstand.setBand1(band1);

        System.out.println("Geef de karakter voor het tweede band:  ");
        char band2 = input.next().charAt(0);
        weerstand.setBand2(band2);

        System.out.println("Geef de karakter voor het derde band:  ");
        char band3 = input.next().charAt(0);
        weerstand.setBand3(band3);

        System.out.printf("Weerstandswaarde: %.0f%n", weerstand.getWeerstandswaarde());
        System.out.println("Weerstandskleur van band1: " +weerstand.getKleur(band1));
        System.out.println("Weerstandskleur van band2: " +weerstand.getKleur(band2));
        System.out.println("Weerstandskleur van band3: " +weerstand.getKleur(band3));

    }
}

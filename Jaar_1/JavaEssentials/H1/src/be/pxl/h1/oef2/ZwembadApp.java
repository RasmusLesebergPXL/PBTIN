package be.pxl.h1.oef2;

import java.util.Scanner;

public class ZwembadApp {
    public static void main(String[] args) {
        Zwembad zwembad1 = new Zwembad();
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de leengte van het zwembad: ");
        double lengte = input.nextDouble();
        input.nextLine();
        zwembad1.setLengte(lengte);
        System.out.println("Geef de breedte van het zwembad: ");
        double breedte = input.nextDouble();
        input.nextLine();
        zwembad1.setBreedte(breedte);
        System.out.println("Geef de diepte van het zwembad: ");
        double diepte = input.nextDouble();
        input.nextLine();
        zwembad1.setDiepte(diepte);

        System.out.printf("Liter water: %.0f %n", zwembad1.getVolumeWater());
        System.out.printf("Liter ontsmettingsmiddel: %.0f ", zwembad1.getVolumeOntsmettingsmiddel());

    }
}

package be.pxl.h1.oef3;

import java.util.Scanner;

public class VoetballerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Naam: ");
        String naam = input.nextLine();
        while (!naam.equals("stop")) {
            Voetballer voetballer1 = new Voetballer();

            System.out.println("Leeftijd: ");
            int leeftijd = input.nextInt();
            input.nextLine();
            voetballer1.setLeeftijd(leeftijd);

            System.out.println("Positie: ");
            String typespeler = input.nextLine();
            voetballer1.setTypespeler(typespeler);

            System.out.println("Beoordeling: ");
            int beoordelingscijver = input.nextInt();
            input.nextLine();
            voetballer1.setBeoordelingscijfer(beoordelingscijver);

            System.out.println("Doelpunten: ");
            int doelpunten = input.nextInt();
            input.nextLine();
            voetballer1.setDoelpunten(doelpunten);

            System.out.printf("Prijs: %.2f %n", voetballer1.getPrijs());
            System.out.println("Naam: ");
            naam = input.nextLine();


        }


    }
}

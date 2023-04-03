package be.pxl.h1.oefextra3;

import java.util.Scanner;

public class DeelnemerApp {
    public static void main(String[] args) {
        Deelnemer[] aantal_personen = new Deelnemer[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Geef het aantal deelnemers: ");
        int aantal_deelnemers = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= aantal_deelnemers; i++) {
            aantal_personen[i] = new Deelnemer();
            System.out.println("Geef de naam van deelnemer " + i + ": ");
            String naam = input.nextLine();
            aantal_personen[i].setNaam(naam);
        }
        System.out.println("Punten voor " + aantal_personen[1].getNaam() + ": ");

        for (int i = 1; i <= 2; i++) {
            System.out.println(aantal_personen[2].getNaam() + " geef uw punten voor SFEER: ");
            int sfeer = input.nextInt();
            input.nextLine();
            while (sfeer < 0 | sfeer > 10) {
                System.out.println("Ongeldig!");
                System.out.println(aantal_personen[2].getNaam() + " geef uw punten voor SFEER: ");
                sfeer = input.nextInt();
                input.nextLine();
            }
            aantal_personen[1].setSfeerArray(sfeer);

            System.out.println(aantal_personen[2].getNaam() + " geef uw punten voor ETEN: ");
            int eten = input.nextInt();
            input.nextLine();
            while (eten < 0 | eten > 10) {
                System.out.println("Ongeldig!");
                System.out.println(aantal_personen[2].getNaam() + " geef uw punten voor ETEN: ");
                eten = input.nextInt();
                input.nextLine();
            }
            aantal_personen[1].setEtenArray(eten);

        }


    }
}

package be.pxl.h1.oef8;

import java.util.Scanner;

public class LiftApp {
    public static void main(String[] args) {
        Lift lift1 = new Lift();
        lift1.setAantalVerdiepingen(11);
        lift1.setToegelatenPersonen(5);
        lift1.setWelkeVerdieping(0);

        System.out.println("Maak uw keuze: ");
        System.out.println("1. Ga naar verdieping: ...");
        System.out.println("2. Betreed de lift: ...");
        System.out.println("3. Verlaat de lift: ...");
        System.out.println("4. Stoppen\n");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.nextLine();

        while (number != 4) {
            if (number == 1) {
                System.out.println("Kies een verdieping: ");
                int verdieping = input.nextInt();
                input.nextLine();
                lift1.gaNaar(verdieping);

            } else if (number == 2) {
                System.out.println("Aantal personen: ");
                int personen = input.nextInt();
                input.nextLine();
                lift1.betreed(personen);

            } else if (number == 3) {
                System.out.println("Aantal personen: ");
                int verlaten = input.nextInt();
                input.nextLine();
                lift1.verlaat(verlaten);
            }
            System.out.println("Maak uw keuze: ");
            System.out.println("1. Ga naar verdieping: ...");
            System.out.println("2. Betreed de lift: ...");
            System.out.println("3. Verlaat de lift: ...");
            System.out.println("4. Stoppen\n");
            number = input.nextInt();
            input.nextLine();
        }


    }
}

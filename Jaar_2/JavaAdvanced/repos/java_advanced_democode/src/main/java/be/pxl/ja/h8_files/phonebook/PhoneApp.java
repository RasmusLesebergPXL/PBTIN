package be.pxl.ja.h8_files.phonebook;

import java.util.Scanner;

public class PhoneApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // TODO create a collection

        // TODO load collection from file

        boolean running = true;
        while (running) {
            System.out.println("Geef een naam: ");
            String naam = input.nextLine();

            // TODO do stuff

            System.out.println("Geef een telefoonnummer: ");
            String telnr = input.nextLine();

            // TODO do stuff

            System.out.println("Wilt u nog namen toevoegen? (j/n)");
            running = input.nextLine().equals("j");
        }


        // TODO save contacts to file

        input.close();
    }
}

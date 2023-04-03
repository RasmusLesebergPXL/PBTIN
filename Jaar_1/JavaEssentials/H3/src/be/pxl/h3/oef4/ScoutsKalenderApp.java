package be.pxl.h3.oef4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoutsKalenderApp {
    public static void main(String[] args) {
        Scanner invoer = new Scanner(System.in);
        System.out.println("geef een maandnr in");
        int maand = invoer.nextInt();
        System.out.println("geef een jaar in");
        int jaar = invoer.nextInt();

        ArrayList<Activiteit> gegevens = new ArrayList<>();

        String activiteit;
        int tel = 0;

        System.out.println("geef een dag in");
        int dag = invoer.nextInt();
        while (dag != 0) {
            invoer.nextLine();
            System.out.println("geef de activiteit in");
            activiteit = invoer.nextLine();
            gegevens.add(new Activiteit(activiteit, LocalDate.of(jaar, maand, dag)));
            tel++;
            System.out.println("geef een dag in");
            dag = invoer.nextInt();
        }

        dag = 1;
        System.out.println("**** Kalender voor " + LocalDate.of(jaar, maand, dag).getMonth() + " " + jaar + " ****");
        for (int i = 0; i < tel; i++) {
            System.out.printf("%-20s %n", gegevens.get(i).toString());
        }
        invoer.close();
    }
}

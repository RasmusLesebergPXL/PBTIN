package be.pxl.h4.oef4;

import java.time.LocalDate;

public class HuwelijkApp {

    public static void main(String[] args) {

        Persoon p1 = new Persoon("Vervoort", "Lies", 29, 11, 1990, "Dorpsstraat", "14", 3500, "Hasselt");
        Persoon p2 = new Persoon("Bex", "Jo", 12,6,1992, "Kastanjelaan", "100", 3600, "Genk");

        p1.getAdres().getGemeente().setGemeenteNaam("Beringen");

        Huwelijk huwelijk = new Huwelijk(p1, p2, 5, 5, 2021);

        System.out.println("Getrouwd in " + huwelijk.getHuwelijksdatum().getYear());

        System.out.println("\n" + huwelijk.getPartner1() + "\n");

        huwelijk.adresWijziging("Lentestraat", "15C", 3500, "Hasselt");

        System.out.println("Gegevens huwelijk:");
        huwelijk.print();
    }
}

package be.pxl.h2.oef1;

import java.util.Scanner;

public class PersonApp {
    public static void main(String[] args) {
        Persoon persoon = new Persoon();
        persoon.setNaam("Mystery");
        persoon.setVoornaam("Michael");
        persoon.setLengte(1.85);
        persoon.setGewicht(59.0);
        persoon.setGeboortejaar(1984);

        System.out.println(persoon);
        persoon.berekenBmi();
        persoon.geefOmschrijving();
        persoon.voegVoornamentoe(" Manson Alice Wonderman");
        System.out.println("\n" + persoon);

        Scanner input = new Scanner(System.in);
        System.out.println("Geef hier uw leeftijd: ");
        int leeftijd = input.nextInt();
        input.nextLine();
        persoon.setLeeftijd(leeftijd);

        persoon.groei();
        System.out.println(persoon);
        persoon.groei(0.23);
        System.out.println(persoon);

        Persoon persoon2 = new Persoon("Leseberg", "Rasmus", 1.86, 63, 1995);
        System.out.println(persoon2);

        Persoon persoon3 = new Persoon();
        System.out.println(persoon3);
    }
}

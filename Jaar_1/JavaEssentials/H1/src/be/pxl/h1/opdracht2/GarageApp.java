package be.pxl.h1.opdracht2;

import static be.pxl.h1.opdracht2.Auto.*;

public class GarageApp {
    public static void main(String[] args) {
        System.out.println("Aantal auto-objecten" + getTeller());
        Auto auto1 = new Auto("Opel", "Groen",2, true);
        auto1.setAantalDeuren(2);
        auto1.setKilometerstand(120000);
        auto1.rijden(320);
        System.out.println("voor de ritjes auto1: " + auto1.getKilometerstand());
        auto1.rijden(2,60);
        System.out.println("na de ritjes auto1: " + auto1.getKilometerstand());


        Auto auto2 = new Auto();
        auto2.setMerk("Volvo");
        auto2.setKleur("Rood");
        auto2.setAantalDeuren(3);
        auto2.setKilometerstand(160000);
        auto2.setAutomaat(false);
        auto2.rijden(180);
        System.out.println("voor de ritjes auto2: " + auto2.getKilometerstand());
        auto2.rijden(3,100);
        System.out.println("na de ritjes auto2: " + auto2.getKilometerstand());


        Auto auto3 = new Auto("Tesla");
        auto3.setKleur("Blauw");
        auto3.setAantalDeuren(6);
        auto3.setKilometerstand(80000);
        auto3.setAutomaat(true);
        auto3.rijden(470);
        System.out.println("voor de ritjes auto3: " + auto3.getKilometerstand());
        auto3.rijden(5,80);
        System.out.println("na de ritjes auto3 " + auto3.getKilometerstand()+"\n");

        Auto auto4 = new Auto(auto1);
        System.out.println(auto4.getKleur());
        System.out.println(auto4.getMerk());

        System.out.println(auto1.getMerk());
        System.out.println(auto1.getKleur());
        System.out.println(auto1.getAantalDeuren());
        System.out.println(auto1.getPrijs());
        System.out.println(auto2.isAutomaat()+"\n");

        System.out.println(auto2.getMerk());
        System.out.println(auto2.getKleur());
        System.out.println(auto2.getAantalDeuren());
        System.out.println(auto2.getPrijs());
        System.out.println(auto2.isAutomaat()+"\n");

        System.out.println(auto3.getMerk());
        System.out.println(auto3.getKleur());
        System.out.println(auto3.getAantalDeuren());
        System.out.println(auto3.getPrijs());
        System.out.println(auto2.isAutomaat()+"\n");

        System.out.println(AANTAL_WIELEN);
        System.out.println("Aantal auto-objecten" + getTeller());


    }
}

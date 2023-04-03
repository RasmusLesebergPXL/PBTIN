package be.pxl.h1.opdracht7;

import be.pxl.h1.opdracht2.Auto;

public class PlanetApp {
    public static void main(String[] args) {
        Planet planet1 = new Planet();
        planet1.setName("Earth");
        planet1.setDiameter(12756);
        planet1.setDistancefromsun(149600000L);

        Planet planet2 = new Planet();
        planet2.setName("Neptune");
        planet2.setDiameter(49528);
        planet2.setDistancefromsun(4495100000L);

        if (planet1.getDistancefromsun() < planet2.getDistancefromsun()) {
            System.out.println(planet1.getName());
        } else {
            System.out.println(planet2.getName());
        }

        System.out.println("planet1 <> SUN = " + planet1.getAE() + "AE");
        System.out.println("planet2 <> SUN = " + planet1.getAE() + "AE");
    }
}


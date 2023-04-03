package be.pxl.h3.oef1;

import java.util.concurrent.ThreadLocalRandom;

public class PersonApp {
    public static void main(String[] args) {
        Persoon persoon = new Persoon();
        persoon.setGewicht(ThreadLocalRandom.current().nextDouble(40, 101));
        persoon.setLengte(ThreadLocalRandom.current().nextDouble(1.57, 2.11));
        System.out.println(persoon);
    }
}

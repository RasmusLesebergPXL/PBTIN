package be.pxl.h7.oef2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BingoApp {
    public static void main(String[] args) {
        ArrayList<Bingokaart> personen = new ArrayList<>();
        personen.add(new Bingokaart("Sam"));
        personen.add(new Bingokaart("Sander"));
        personen.add(new Bingokaart("Nele"));
        personen.add(new Bingokaart("Heidi"));
        personen.add(new Bingokaart("Ingrid"));
        for (Bingokaart persoon : personen) {
            for (int i = 0; i < 6; i++) {
                persoon.addNumbers(ThreadLocalRandom.current().nextInt(0, 100));
            }
        }
        for (Bingokaart persoon : personen) {
            System.out.println(persoon);
        }
        int teller = 1;
        while (teller != 0) {
        int getal = ThreadLocalRandom.current().nextInt(0,100);
        System.out.printf("Nummer %d getrokken...%n", getal);
        for (Bingokaart persoon : personen) {
            if (persoon.hasNumber(getal)) {
                System.out.println("BINGO!!");
                System.out.println(persoon);
                teller = 0;
            }
            }
        }
    }
}

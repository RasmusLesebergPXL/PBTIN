package be.pxl.h6.oef2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class KaartApp {
    public static void main(String[] args) {
        Kaart[] deck = new Kaart[Soort.values().length * Ranking.values().length];

        int teller = 0;
        for(Soort soort: Soort.values()) {
            for(Ranking ranking: Ranking.values()) {
                Kaart kaart = new Kaart(soort, ranking);
                deck[teller] = kaart;
                teller++;
            }
        }

        System.out.println(deck[0]);

        Collections.shuffle(Arrays.asList(deck));

        System.out.println(deck[0]);


        Random r = new Random();
        int randomIndex = r.nextInt(deck.length); // PC
        int randomIndex2 = r.nextInt(deck.length); // IK

        Kaart pc = deck[randomIndex];
        Kaart ik = deck[randomIndex2];
        System.out.println("PC: " + pc);
        System.out.println("IK: " + ik);

        if(pc.getRanking().ordinal() > ik.getRanking().ordinal()) {
            System.out.println("Computer wint");
        } else if(pc.getRanking().ordinal() < ik.getRanking().ordinal()) {
            System.out.println("Ik win");
        } else {
            System.out.println("Draw...");
        }
    }
}

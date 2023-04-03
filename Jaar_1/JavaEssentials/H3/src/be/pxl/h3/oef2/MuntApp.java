package be.pxl.h3.oef2;

import java.util.ArrayList;

public class MuntApp {
    public static void main(String[] args) {
        ArrayList<Munt> munten = new ArrayList<>();
        Munt euro = new Munt();
        munten.add(euro);
        Munt roebel = new Munt();
        roebel.setNaam("roebel");
        roebel.setKoers(86.950);
        munten.add(roebel);
        Munt rand = new Munt();
        rand.setNaam("rand");
        rand.setKoers(14.876);
        munten.add(rand);
        Munt pond = new Munt();
        pond.setNaam("birtse pont");
        pond.setKoers(0.958);
        munten.add(pond);
        Munt dollar = new Munt();
        dollar.setNaam("dollar");
        dollar.setKoers(1.287);
        munten.add(dollar);
        Munt yen = new Munt();
        yen.setNaam("yen");
        yen.setKoers(10000);
        munten.add(yen);

        for (Munt munt : munten) {
            System.out.println(munt.getKoers() + " " + munt.getNaam());
        }
        System.out.println("Overzicht koersen tov BRITSE POND: 1 BRITSE POND = ");
        for(Munt m : munten) {
            System.out.printf("%."+Munt.AFRONDING+"f %s%n", m.getKoers(), m.getNaam());
        }





    }
}

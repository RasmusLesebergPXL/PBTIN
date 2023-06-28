package be.pxl.h5.oef2;

import be.pxl.h5.oef1.Persoon;

import java.util.ArrayList;

public class SportApp {
    public static void main(String[] args) {
        ArrayList<Sporter> sporters = new ArrayList<>();
        sporters.add(new Sporter("Bex","An", "zwemmen"));
        sporters.add(new Voetballer("Maes","Jelle", "KSKHasselt", "middenvelder"));
        sporters.add(new Voetballer("Vos","Nils", "KSKHasselt", "aanvaller"));
        sporters.add(new Sporter("Nilis","Els", "volleybal"));
        sporters.add(new Sporter("Adams","Leen", "atletiek"));
        sporters.add(new Voetballer("Vos","Joren", "KSKHasselt", "verdediger"));
        sporters.add(new Sporter("Jordan","Michael", "Basketbal"));
        sporters.add(new Voetballer("Dirix","Joni", "KSKHasselt", "verdediger"));
        sporters.add(new Voetballer("Hox","Martijn", "onbepaald", "doelman"));
        sporters.add(new Voetballer("Courtois","Thibaut", "Real Madrid", "rechts-mid"));

        System.out.println("Overzicht sporters (behalve voetbal)");
        for (Persoon persoon : sporters ) { //Polymorphisme: Persoon kan of voetballer of geen voetballer zijn
            if(!(persoon instanceof Voetballer)) {
                persoon.print();
            }
        }
        System.out.println("Overzicht voetballers volgens opstelling");
        for (Persoon persoon : sporters ) {
            if (persoon instanceof Voetballer) {
                for (String opstelling : ((Voetballer) persoon).getOpstellingenArray()) {
                    if (((Voetballer) persoon).getOpstelling().equals(opstelling)) {
                        System.out.println("*** " + opstelling + " ***");
                        persoon.print();
                    }
                }
            }
        }
    }
}

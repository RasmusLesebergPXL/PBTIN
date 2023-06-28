package be.pxl.h8.oef1;

import java.util.ArrayList;
import java.util.Arrays;

public class Folder implements Uitvoerbaar {
    private String naam;
    private ArrayList<Bestand> bestanden = new ArrayList<>();

    public Folder(String naam) {
        this.naam = naam;
    }

    public void voegBestandenToe(Bestand[] objecten) {
        bestanden.addAll(Arrays.asList(objecten));
    }

    @Override
    public void voerUit() {
        System.out.println("Mijn Documenten:");
        for (Bestand bestand : bestanden) {
            System.out.println(bestand.toString() + "\n");
        }
    }
}

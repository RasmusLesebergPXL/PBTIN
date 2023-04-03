package be.pxl.h5.opdracht11;

import java.util.ArrayList;
import java.util.Objects;

public class FiguurApp {
    public static void main(String[] args) {
        ArrayList<GrafischElement> list = new ArrayList<>();
        Cirkel cirkel = new Cirkel(12,34,14);
        Cirkel cirkel2 = new Cirkel(12,34,12);
        Rechthoek rechthoek = new Rechthoek(9,5);
        Vierkant vierkant = new Vierkant(15);
        Driehoek driehoek = new Driehoek(12,34,5,8,10);
        list.add(cirkel);
        list.add(cirkel2);
        list.add(rechthoek);
        list.add(vierkant);
        list.add(driehoek);

        for (GrafischElement element : list) {
            System.out.printf("Omtrek: %10.0f Oppervlakte: %10.0f %10s \n", element.getOmtrek(), element.getOppervlakte(), element.getClass().getSimpleName());
        }
    }
}

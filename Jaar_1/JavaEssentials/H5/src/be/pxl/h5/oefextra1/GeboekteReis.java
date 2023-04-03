package be.pxl.h5.oefextra1;

import java.util.ArrayList;

public class GeboekteReis {
    private String naam;
    private ArrayList<String> reizen;

    public GeboekteReis(String naam, int aantal) {
        this.naam = naam;
        this.reizen = new ArrayList<>(aantal);
    }

    public void voegReisToe(String reis) {
        if (reizen.size() == 10)
        reizen.add(reis);

    }


}

package be.pxl.h5.oef2;

import be.pxl.h5.oef1.Persoon;

public class Sporter extends Persoon {
    private String omschrijving;
    private static int aantal;

    public Sporter(String naam, String voornaam) {
        super(naam, voornaam);
        this.omschrijving = "onbepaald";
        aantal++;
    }
    public Sporter(String naam, String voornaam, String omschrijving) {
        super(naam, voornaam);
        this.omschrijving = omschrijving;
        aantal++;
    }
    public static int getAantal() {
        return aantal;
    }

    public void wijzigSport(String wijziging) {
        setOmschrijving(wijziging);
    }
    public void print() {
        System.out.println(getVoornaam() + " " + getNaam());
        System.out.println(getOmschrijving());
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }


}


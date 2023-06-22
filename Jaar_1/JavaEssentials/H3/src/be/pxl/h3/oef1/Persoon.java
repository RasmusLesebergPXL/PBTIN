package be.pxl.h3.oef1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persoon {
    public static final double MAX_LENGTE = 2.40;

    private String naam;
    private String voornaam;
    private double lengte;
    private double gewicht;
    private LocalDate geboortedatum;

    public Persoon() {
        this("onbekend", "onbekend");
    }

    public Persoon(String naam, String voornaam) {
        this.naam = naam;
        this.voornaam = voornaam;
    }

    public Persoon(Persoon persoon) {
        this.voornaam = persoon.getVoornaam();
        this.naam = persoon.getNaam();
        this.lengte = persoon.getLengte();
        this.gewicht = persoon.getGewicht();
        this.geboortedatum = persoon.geboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public double getLengte() {
        return lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString() {
        String uiteindelijke_string = "";
        uiteindelijke_string += voornaam.toUpperCase() + " " + naam.toUpperCase();
        return uiteindelijke_string;
    }

    public double berekenBmi() {
        double bmi = gewicht / (lengte * lengte);
        return Math.round(bmi * 10) / 10.0;
    }

    public String geefOmschrijving() {
        if (berekenBmi() < 18) {
            return "ondergewicht";
        } else if (berekenBmi() < 25) {
            return "normaal";
        } else if (berekenBmi() < 30) {
            return "overgewicht";
        } else if (berekenBmi() < 40) {
            return "obesitas";
        } else {
            return "morbide obesitas";
        }
    }

    public void voegVoornamenToe(String[] voornamen) {
        for (String element : voornamen) {
            voornaam += " " + element;
        }
    }

    public int getLeeftijd() {
        return LocalDate.now().getYear() - geboortedatum.getYear();
    }

    public void setLengte(double lengte) {
        if (lengte > MAX_LENGTE) {
            lengte = MAX_LENGTE;
        }
        this.lengte = lengte;
    }

    public void groei() {
        lengte += 0.01;
        setLengte(lengte);
    }

    public void groei(double aantalcm) {
        lengte += aantalcm;
        setLengte(lengte);
    }

    public String geefNaamAfgekort() {
        String afgekorte_naam = "";
        char eersteLetter = getVoornaam().charAt(0);
        char tweedeLetter = Character.toUpperCase(getNaam().charAt(0));
        afgekorte_naam += eersteLetter + "." + tweedeLetter + getNaam().substring(1).toLowerCase();
        return afgekorte_naam;
    }

    public String encrypteerNaam(int getal) {
        char[] chars = geefNaamAfgekort().toCharArray();
        ArrayList<Integer> ascii_values = new ArrayList<>();
        for (Character element : chars) {
            ascii_values.add((int) element + getal);
        }
        StringBuilder encrypteer = new StringBuilder();
        for (int i : ascii_values) {
            encrypteer.append((char) i);
        }
        return encrypteer.toString();
    }

}

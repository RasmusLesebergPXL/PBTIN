package be.pxl.h4.opdracht;

public class Auteur {
    private String naam;
    private String voornaam;

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

    public Auteur(String voornaam, String naam) {
        this.naam = naam;
        this.voornaam = voornaam;
    }
    public String toString() {
        return "Auteur: " + getVoornaam() + " " + getNaam();
    }
}

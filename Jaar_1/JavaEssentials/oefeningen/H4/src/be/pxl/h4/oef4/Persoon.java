package be.pxl.h4.oef4;

import java.time.LocalDate;

public class Persoon {

    private String naam;
    private String voornaam;
    private LocalDate geboortedatum;
    private Adres adres;

    public Persoon(String naam, String voornaam, int dag, int maand, int jaar, String straat, String huisnummer, int postcode, String gemeenteNaam) {
        this(naam, voornaam, LocalDate.of(jaar, maand, dag), new Adres(straat, huisnummer, postcode, gemeenteNaam));
    }

    public Persoon(String naam, String voornaam, LocalDate geboortedatum, Adres adres) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s",voornaam, naam, adres);
    }
}

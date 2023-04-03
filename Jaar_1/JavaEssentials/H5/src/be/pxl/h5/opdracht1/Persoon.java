package be.pxl.h5.opdracht1;

public class Persoon {
    private static int aantal;
    private String naam;
    private String voornaam;

    public Persoon(String naam, String voornaam) {
        this.naam = naam;
        this.voornaam = voornaam;
        aantal ++;
    }

    public Persoon() {
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

    public void print() {
        System.out.println(voornaam + " " + naam);
    }
    public static int getAantal() {
        return aantal;
    }
}

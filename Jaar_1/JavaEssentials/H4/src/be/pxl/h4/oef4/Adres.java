package be.pxl.h4.oef4;

public class Adres {
    private String straat;
    private String huisnummer;
    private Gemeente gemeente;

    public Adres(String straat, String huisnummer, int postcode, String gemeenteNaam) {
        this.gemeente = new Gemeente(postcode, gemeenteNaam);
        this.straat = straat;
        this.huisnummer = huisnummer;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s",straat,huisnummer,gemeente);
    }
}

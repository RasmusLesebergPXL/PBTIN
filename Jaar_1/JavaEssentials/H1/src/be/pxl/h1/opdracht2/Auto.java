package be.pxl.h1.opdracht2;

public class Auto {
    // Constante (altijd hoofdletters)  = klassevariabelen
    public static final int AANTAL_WIELEN = 4;
    private static int teller = 0;
    //Eigenschappen of kenmerken = instantievariabelen
    private String merk;
    private String kleur;
    private int aantalDeuren;
    private int kilometerstand;
    private boolean automaat;

    //ConSTRUCTOREN
    public Auto (String merk, String kleur, int aantalDeuren, boolean automaat) {
        this.merk = merk;
        this.kleur = kleur;
        this.aantalDeuren = aantalDeuren;
        this.automaat = automaat;
        teller++;
    }
    public Auto() { //Default constructor
        teller++;
    }

    public Auto(String merk) {
        this.merk = merk;
        teller++;
    }
    public Auto(Auto andereAuto) {
        this(andereAuto.merk, andereAuto.kleur, andereAuto.aantalDeuren, andereAuto.automaat);
        this.kilometerstand = andereAuto.kilometerstand;
    }

    // methoden
    public void setMerk(String eenMerk) {
        merk = eenMerk;
    }

    public String getMerk() {
        return merk;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public int getAantalDeuren() {
        return aantalDeuren;
    }

    public void setAantalDeuren(int aantalDeuren) {
        this.aantalDeuren = aantalDeuren;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public void setAutomaat(boolean automaat) {
        this.automaat = automaat;
    }

    public boolean isAutomaat() {
        return automaat;
    }

    public void rijden(int afstand) {
        kilometerstand += afstand;
    }

    public void rijden(int uren, int snelheid) {
        kilometerstand += uren * snelheid;
    }

    public int getPrijs() {
        int prijs = 20000;
        if (aantalDeuren == 3) {
            prijs -= 500;
        } else if (aantalDeuren == 5) {
            prijs += 2000;
        }
        if (automaat) {
            prijs += 2000;
        } else {
            prijs = prijs - prijs * 2 / 100;
        }
        return prijs;
    }

    public static int getTeller() {
        return teller;
    }


}

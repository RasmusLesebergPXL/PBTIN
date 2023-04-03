package be.pxl.h3.oef2;



public class Munt {
    private String naam;
    private double koers;
    public static final int AFRONDING = 5;
    private static int aantal;

    public Munt() {
        this.naam = "euro";
        this.koers = 1;
    }


    public String getNaam() {
        return naam.toUpperCase();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getKoers() {
        return koers;
    }

    public void setKoers(double koers) {
        this.koers = koers;
    }

    public static int getAantal() {
        return aantal;
    }

    public static void setAantal(int aantal) {
        Munt.aantal = aantal;
    }


}

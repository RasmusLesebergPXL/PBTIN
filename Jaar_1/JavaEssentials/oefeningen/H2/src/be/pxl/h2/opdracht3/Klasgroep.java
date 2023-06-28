package be.pxl.h2.opdracht3;

public class Klasgroep {
    public static final int MAX_AANTAL = 40;
    private String naam;
    private int aantalStudenten;

    public Klasgroep() { //Default constructor
        this("TINx", 0);
    }
    public Klasgroep(String naam, int aantalStudenten) {
        this.naam = naam;
        setAantalStudenten(aantalStudenten);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public void setAantalStudenten(int aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
        if (aantalStudenten > MAX_AANTAL) {
            aantalStudenten = MAX_AANTAL;
        }
        this.aantalStudenten = aantalStudenten;
    }


}

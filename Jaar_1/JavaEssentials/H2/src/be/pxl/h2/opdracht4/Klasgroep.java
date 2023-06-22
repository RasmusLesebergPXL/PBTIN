package be.pxl.h2.opdracht4;

public class Klasgroep {
    public static final int MAX_AANTAL = 40;
    private String naam;
    private int aantalStudenten;
    private static int teller = 0;
    private static int totaalAantalStudenten = 0;

    public Klasgroep() { //Default constructor
        this("TINx", 0);
    }
    public Klasgroep(String naam, int aantalStudenten) {
        this.naam = naam;
        setAantalStudenten(aantalStudenten);
        teller++;
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
        if (aantalStudenten > MAX_AANTAL) {
            aantalStudenten = MAX_AANTAL;
        }
        totaalAantalStudenten -= this.aantalStudenten;
        this.aantalStudenten = aantalStudenten;
        totaalAantalStudenten += this.aantalStudenten;
    }
    public static int getTeller() {
        return teller;
    }
    public static int getTotaalAantalStudenten() {
        return totaalAantalStudenten;
    }
    public static double getGemiddeldAantalStudentenPerKlasgroep() {
        return totaalAantalStudenten / (double) teller;
    }
}

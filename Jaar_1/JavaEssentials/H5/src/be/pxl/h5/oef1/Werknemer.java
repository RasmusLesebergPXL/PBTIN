package be.pxl.h5.oef1;

public class Werknemer extends Persoon {
    private String functie;
    private double salaris;
    public static final double MIN_SALARIS = 1000;
    private static int aantal;

    public Werknemer(String naam, String voornaam) {
        super(naam, voornaam);
        this.functie = "algemeen bediende";
        this.salaris = 1800;
        aantal++;
    }

    public Werknemer(String naam, String voornaam, String functie, double salaris) {
        super(naam, voornaam);
        this.functie = functie;
        setSalaris(salaris);
        aantal++;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public double getSalaris() {
        return salaris;
    }

    public void setSalaris(double salaris) {
        if (salaris < MIN_SALARIS) {
            salaris = MIN_SALARIS;
        }
        this.salaris = salaris;
    }

    public static double getMinimumSalaris() {
        return MIN_SALARIS;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Functie: " + getFunctie());
        System.out.println("Salaris: " + getSalaris());
    }

    public static int getAantal() {
        return aantal;
    }
}

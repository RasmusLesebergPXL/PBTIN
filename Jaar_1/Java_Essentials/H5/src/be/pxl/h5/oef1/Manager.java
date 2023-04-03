package be.pxl.h5.oef1;

public class Manager extends Werknemer {
    private double bonus;
    private static int aantal;


    public Manager(String naam, String voornaam, String functie, double salaris) {
        super(naam, voornaam);
        this.bonus = 50;
        setSalaris(salaris);
        setFunctie(functie);
        aantal++;
    }

    public Manager(String naam, String voornaam, String functie, double salaris, double bonus) {
        super(naam, voornaam);
        setSalaris(salaris);
        setFunctie(functie);
        this.bonus = bonus;
        aantal++;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalaris() {
        return super.getSalaris() + bonus;
    }

    public static int getAantal() {
        return aantal;
    }

    public double getProcAandeelManagers() {
        return (double)Manager.getAantal() / Werknemer.getAantal() * 100;
    }
}

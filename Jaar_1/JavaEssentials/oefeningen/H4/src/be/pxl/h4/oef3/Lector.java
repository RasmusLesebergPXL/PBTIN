package be.pxl.h4.oef3;

public class Lector {
    private String naam;
    private String voornaam;
    private double aanstellingsPercentage;
    private Vak[] vakken;

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

    public double getAanstellingsPercentage() {
        return aanstellingsPercentage;
    }

    public void setAanstellingsPercentage(double aanstellingsPercentage) {
        if (aanstellingsPercentage > 100) {
            System.out.println("Het aanstellingspercentage is te hoog");
        } else if (aanstellingsPercentage < 0) {
            System.out.println("Het aanstellingspercentage mag niet kleiner zijn dan 0");
        }
        this.aanstellingsPercentage = Input.readDouble("Geef een correcte waarde voor de SP: ");
    }

    public Vak[] getVakken() {
        return vakken;
    }

    public void setVakken(Vak[] vakken) {
        this.vakken = vakken;
    }

    public Lector(String naam, String voornaam, double aanstellingsPercentage, Vak[] vakken) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.aanstellingsPercentage = aanstellingsPercentage;
        this.vakken = vakken;
    }

    public void print() {
        System.out.println("Leraar " + getNaam() + " " + getVoornaam() + " is aangesteld voor " + getAanstellingsPercentage() + "%\n");
        System.out.println("Volgende vakken behoren tot het takenpakket: ");
        for (Vak vak : vakken) {
            System.out.printf("%15s %25s %10d\n", vak.getVakCode(), vak.getVak(), vak.getStudiePunten());
        }
    }
}

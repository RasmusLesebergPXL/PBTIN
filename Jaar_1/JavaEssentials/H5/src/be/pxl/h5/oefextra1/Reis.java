package be.pxl.h5.oefextra1;

public class Reis {
    private String bestemming;
    private double prijs;
    private static final int MINIMUMPRIJS = 5;

    public Reis(String bestemming) {
        char char_1 = bestemming.charAt(0);
        if (Character.isDigit(char_1)) {
            this.bestemming = bestemming.substring(1);
        } else {
            this.bestemming = bestemming;
        }
        this.prijs = MINIMUMPRIJS;
    }

    public Reis(String bestemming, double prijs) {
        this(bestemming);
        if (prijs < 5) {
            this.prijs = MINIMUMPRIJS;
        } else {
            this.prijs = prijs;
        }
    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String toString() {
        return String.format("Reis met bestemming %s kost %.2f euro", getBestemming(), getPrijs());
    }
}

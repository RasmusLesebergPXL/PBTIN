package be.pxl.h5.oefextra1;


public class Vliegtuigreis extends Reis{
    private String vluchtnummer;
    private static final int MINIMUMPRIJS = 25;

    public Vliegtuigreis(String bestemming) {
        super(bestemming);
        String vluchtNaam = "";
        if (vluchtnummer.substring(0,1).equals(bestemming.substring(0,1)) || !vluchtnummer.substring(0,1).equals(bestemming.substring(0,1))) {
            vluchtNaam += bestemming.substring(0,1).toUpperCase();
            vluchtNaam += "999";
            this.vluchtnummer = vluchtNaam;
        }
    }

    public Vliegtuigreis(String bestemming, double prijs, String vluchtnummer) {
        super(bestemming, prijs);
        this.vluchtnummer = getVluchtnummer();
    }

    public String getVluchtnummer() {
        return vluchtnummer;
    }

    public void setVluchtnummer(String vluchtnummer) {
        this.vluchtnummer = vluchtnummer;
    }

    @Override
    public String toString() {
        return String.format("Reis met bestemming %s kost %.2f euro.\nVliegtuigreis (vluchtnr %s)", getBestemming(), getPrijs(), getVluchtnummer());
    }
}

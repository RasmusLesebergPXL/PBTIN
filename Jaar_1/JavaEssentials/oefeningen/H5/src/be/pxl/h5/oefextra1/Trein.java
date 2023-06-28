package be.pxl.h5.oefextra1;

import java.util.ArrayList;

public class Trein extends Reis{
    private boolean nationaal;
    private String specificatie;

    public Trein(String bestemming) {
        super(bestemming);
        this.specificatie = "IC";
        nationaal = true;
    }

    public Trein(String bestemming, double prijs,boolean nationaal, String specificatie) {
        super(bestemming, prijs);
        this.nationaal = nationaal;
        this.specificatie = specificatie;
    }

    public String getSpecificatie() {
        return specificatie;
    }

    public void setSpecificatie(String specificatie) {
        ArrayList<String> juisteWaarden = new ArrayList<>();
        juisteWaarden.add("IC");
        juisteWaarden.add("IR");
        juisteWaarden.add("L");
        juisteWaarden.add("P");
        if (juisteWaarden.contains(specificatie)) {
            nationaal = true;
        } else if (!juisteWaarden.contains(specificatie))
            nationaal = true;
            specificatie = "IC";
        if (nationaal) {
            String spec = "Nationale (";
            spec += specificatie + ")";
            this.specificatie = spec;
        } else {
            String spec2 = "Internationale (";
            spec2 += specificatie + ")";
            this.specificatie = spec2;
        }
    }

    @Override
    public String toString() {
        return String.format("Reis met bestemming %s kost %.2f euro\n%s", getBestemming(), getPrijs(), getSpecificatie());
    }
}

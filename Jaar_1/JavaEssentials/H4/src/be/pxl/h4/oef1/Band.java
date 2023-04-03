package be.pxl.h4.oef1;

public class Band {
    private String naam;
    private Muzikant[] leden = new Muzikant[10];

    public Band(String naam, Muzikant[] leden) {
        this.naam = naam;
        this.leden = leden;
    }

    public void speel(int lengte) {
        System.out.println("PXL-Digtal in concert!");
        for (Muzikant persoon : leden) {
            persoon.speel();
        }
    }

    public String toString() {
        System.out.println("PXL-Digital");
        StringBuilder band = new StringBuilder();
        for (Muzikant persoon : leden) {
            band.append(persoon.toString()+"\n");
        }
        return band.toString();
    }
}

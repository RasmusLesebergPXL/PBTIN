package be.pxl.h4.oef1;

public class BandApp {
    public static void main(String[] args) {
        Instrument sax = new Instrument("saxofoon", "toot");
        sax.speel();
        System.out.println(sax);
        Muzikant[] band = new Muzikant[5];

        band[0] = new Muzikant("Heidi", new Instrument("Drum", "Boenk baf boenk baf"));
        band[1] = new Muzikant("Ingrid", new Instrument("Bas","bowowowow"));
        band[2] = new Muzikant("Nele", new Instrument("Klarinet", "Pftoee"));
        band[3] = new Muzikant("Sam", new Instrument("Gitaar", "ploing"));
        band[4] = new Muzikant("Francis", new Instrument("Triangel", "kling"));

        Band nieuweBand = new Band("PXL Locos", band);

        nieuweBand.speel(20);
        System.out.println();
        System.out.println(nieuweBand);

    }
}

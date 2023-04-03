package be.pxl.h8.oef2;

public class Schip extends ZeeObject implements Beweegbaar{
    private int snelheid;

    public Schip(int x, int y, Alliantie alliantie, int levenspunten, int snelheid) {
        super(x, y, alliantie, levenspunten);
        this.snelheid = snelheid;
    }

    @Override
    public void beweegNaar(Punt punt) {
        if (getLevenspunten() > 0 && getLocatie().berekafstand(punt) <= this.snelheid) {
            setLocatie(punt);
        }
    }

    @Override
    public String toString() {
        return String.format("schip: %s", super.toString());
    }
}

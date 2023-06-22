package be.pxl.h8.opdracht;

public class Cirkel extends GrafischElement implements Schaalbaar {
    private int straal;

    public Cirkel (int x, int y, int r) {
        super(x, y);
        straal = r;
    }

    public double getOppervlakte() {
        return Math.pow(straal,2) * Math.PI;
    }
    public double getOmtrek() {
        return 2 * Math.PI * straal;
    }

    @Override
    public void herschaal(int factor) {
        straal *= (factor / 100.0);
    }
}

package be.pxl.h5.opdracht8;

public class Cirkel extends GrafischElement {
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
}

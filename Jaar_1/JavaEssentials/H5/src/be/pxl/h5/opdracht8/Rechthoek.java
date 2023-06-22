package be.pxl.h5.opdracht8;

public class Rechthoek extends GrafischElement{
    private int hoogte;
    private int breedte;
    public Rechthoek (int x, int y, int h, int w) {
        super(x, y);
        hoogte = h;
        breedte = w;
    }

    public double getOppervlakte() {
        return breedte * hoogte;
    }
    public double getOmtrek() {
        return 2 * (breedte + hoogte);
    }

}

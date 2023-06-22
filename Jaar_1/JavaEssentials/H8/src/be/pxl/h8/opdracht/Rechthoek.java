package be.pxl.h8.opdracht;

public class Rechthoek extends GrafischElement implements Schaalbaar {
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

    @Override
    public void herschaal(int factor) {
        breedte *= (factor / 100.0);
        hoogte *= (factor / 100.0);
    }
}

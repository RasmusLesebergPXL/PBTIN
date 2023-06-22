package be.pxl.h5.opdracht8;

public class Driehoek extends GrafischElement{
    private int hoogte;
    private int breedte;

    public Driehoek(int x, int y, int h, int w) {
        super(x, y);
        hoogte = h;
        breedte = w;
    }

    public double getOppervlakte() {
        return 0.5 * breedte * hoogte;
    }

    public double getOmtrek() {
        double diagonal = Math.sqrt((Math.pow(breedte, 2)) + Math.pow(hoogte, 2));
        return breedte + hoogte + diagonal;
    }
}

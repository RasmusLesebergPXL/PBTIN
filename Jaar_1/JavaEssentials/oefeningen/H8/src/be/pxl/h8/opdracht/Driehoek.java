package be.pxl.h8.opdracht;

public class Driehoek extends GrafischElement implements Schaalbaar{
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

    @Override
    public void herschaal(int factor) {
        breedte *= (factor / 100.0);
        hoogte *= (factor / 100.0);
    }
}

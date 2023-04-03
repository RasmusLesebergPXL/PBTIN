package be.pxl.h4.oefextra1;

public class RGBPixel {
    private int rood;
    private int groen;
    private int blauw;

    public RGBPixel(int rood, int groen, int blauw) {
        this.rood = rood;
        this.groen = groen;
        this.blauw = blauw;
    }

    public int getRood() {
        return rood;
    }

    public int getGroen() {
        return groen;
    }

    public int getBlauw() {
        return blauw;
    }

    public void naarGrijswaarde() {
        double finalWaarde = Math.round((rood + groen + blauw)/3);
        this.rood = (int) finalWaarde;
        this.blauw = (int) finalWaarde;
        this.groen = (int) finalWaarde;
    }

    public String toString() {
        return "(" + getRood() + ", " + getGroen() + ", " + getBlauw() + ")";
    }
}

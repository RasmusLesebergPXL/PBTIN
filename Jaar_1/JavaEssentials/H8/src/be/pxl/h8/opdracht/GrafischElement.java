package be.pxl.h8.opdracht;

public abstract class GrafischElement implements Schaalbaar {
    private int x;
    private int y;
    public GrafischElement (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setPositie (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public abstract double getOppervlakte();
    public abstract double getOmtrek();
}


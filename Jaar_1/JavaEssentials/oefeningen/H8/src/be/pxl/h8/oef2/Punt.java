package be.pxl.h8.oef2;

public class Punt {
    private int x;
    private int y;
    public static final int MAXIMUMGROOTTE = 99;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
        controleer();
    }

    public int berekafstand(Punt p2) {
        return (int) Math.sqrt(Math.pow((x - p2.x), 2) + Math.pow((y - p2.y), 2));
    }

    private void controleer() {
        this.x = Math.min(Math.max(0, x), MAXIMUMGROOTTE);
        this.y = Math.min(Math.max(0, y), MAXIMUMGROOTTE);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        controleer();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        controleer();
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}

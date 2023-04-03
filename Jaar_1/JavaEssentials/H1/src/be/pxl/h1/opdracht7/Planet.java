package be.pxl.h1.opdracht7;

public class Planet {
    private String name;
    private int diameter;
    private long distancefromsun;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public long getDistancefromsun() {
        return distancefromsun;
    }

    public void setDistancefromsun(long distancefromsun) {
        this.distancefromsun = distancefromsun;
    }

    public double getAE() {
        double AE = distancefromsun / 149600000.0;
        return AE;
    }

}

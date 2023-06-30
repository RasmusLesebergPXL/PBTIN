package be.pxl.car;

import java.util.Comparator;

public class Province implements Comparable<Province> {
    private final String name;
    private int population;
    private int landArea;

    public Province(String name, int population, int landArea) {
        this.name = name;
        this.population = population;
        this.landArea = landArea;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandArea() {
        return landArea;
    }

    public void setLandArea(int landArea) {
        this.landArea = landArea;
    }

    public double getDensity() {
        return (double) population / landArea;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landArea=" + landArea +
                ", density=" + getDensity() +
                '}';
    }

    @Override
    public int compareTo(Province o) {
        return Integer.compare(o.getPopulation(), this.getPopulation());
    }
}

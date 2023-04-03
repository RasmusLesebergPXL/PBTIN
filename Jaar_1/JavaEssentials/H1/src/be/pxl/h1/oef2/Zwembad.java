package be.pxl.h1.oef2;

public class Zwembad {
    private double lengte;
    private double breedte;
    private double diepte;

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getDiepte() {
        return diepte;
    }

    public void setDiepte(double diepte) {
        this.diepte = diepte;
    }

    public double getVolume() {
        return lengte * breedte * diepte;
    }

    public double getVolumeWater() {
        return (getVolume() - (getVolume() * 0.02)) * 1000;
    }

    public double getVolumeOntsmettingsmiddel() {
        return (getVolume() * 0.02) * 1000;
    }
}

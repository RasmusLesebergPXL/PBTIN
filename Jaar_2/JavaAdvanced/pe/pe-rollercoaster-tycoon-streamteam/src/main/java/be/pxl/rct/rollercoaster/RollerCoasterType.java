package be.pxl.rct.rollercoaster;


import java.io.Serializable;

public class RollerCoasterType implements Serializable {
    private double excitement;
    private double nausea;
    private String type;
    private int passengers;
    private double cost;
    private int id;
    private int runningTime;
    private RideGenre genre;
    private String excitementRating;
    private String nauseaRating;


    public double getExcitement() {
        return excitement;
    }

    public void setExcitement(double excitement) {
        this.excitement = excitement;
    }

    public double getNausea() {
        return nausea;
    }

    public void setNausea(double nausea) {
        this.nausea = nausea;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public RideGenre getGenre() {
        return genre;
    }

    public void setGenre(RideGenre genre) {
        this.genre = genre;
    }

    public String getExcitementRating() {
        return excitementRating;
    }

    public void setExcitementRating(String excitementRating) {
        this.excitementRating = excitementRating;
    }

    public String getNauseaRating() {
        return nauseaRating;
    }

    public void setNauseaRating(String nauseaRating) {
        this.nauseaRating = nauseaRating;
    }
}

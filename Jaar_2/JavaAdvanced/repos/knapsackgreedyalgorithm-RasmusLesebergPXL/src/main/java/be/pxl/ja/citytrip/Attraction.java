package be.pxl.ja.citytrip;


import be.pxl.ja.knapsack.Item;

public class Attraction implements Item, Comparable<Attraction> {

    private int rating;
    private double days;
    private String name;

    public Attraction(String place, double d, int r) {
        this.name = place;
        this.days = d;
        this.rating = r;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public double getWeight() {
        return days;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Attraction place) {
        return Double.compare(place.getRating(), this.rating);
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "rating=" + rating +
                ", days=" + days +
                ", name='" + name + '\'' +
                '}';
    }
}

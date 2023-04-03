package be.pxl.ja.robbery;

import be.pxl.ja.knapsack.Item;

public class Product implements Item, Comparable<Product> {

    private String name;
    private double weight;
    private double price;

    public Product(String description, double weight, double price) {
        this.name = description;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product product) {
        return Double.compare(product.getPrice(), this.getPrice());
    }

    @Override
    public String toString() {
        return "Product: " + this.name +
                " Weight: " + this.weight +
                " Price: " + this.price;
    }
}

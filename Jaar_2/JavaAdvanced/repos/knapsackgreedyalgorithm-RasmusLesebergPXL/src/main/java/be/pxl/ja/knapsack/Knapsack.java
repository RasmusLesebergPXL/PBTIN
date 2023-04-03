package be.pxl.ja.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Knapsack<T extends Item> {

    private double maximumCapacity;
    private final List<T> items;

    public Knapsack(double capacity) {
        this.maximumCapacity = capacity;
        this.items = new ArrayList<>();
    }

    public double getCurrentWeight() {
        double currentWeight = 0;
        for (T item: items) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }

    public void add(T item) throws KnapsackFullException {
        if (this.getCurrentWeight() + item.getWeight() > maximumCapacity) {
            throw new KnapsackFullException("Cannot add item [" + item.getName() + "]. Maximum capacity reached");
        }
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

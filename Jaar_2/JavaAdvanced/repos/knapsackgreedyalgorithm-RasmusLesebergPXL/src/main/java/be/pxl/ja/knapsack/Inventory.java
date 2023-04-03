package be.pxl.ja.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Inventory<E extends Item> {

    private final List<E> items = new ArrayList<>();

    public void add(E item) {
        items.add(item);
    }

    public List<E> getItems() {
        return items;
    }
}

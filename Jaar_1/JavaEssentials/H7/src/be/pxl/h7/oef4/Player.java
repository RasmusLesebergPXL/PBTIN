package be.pxl.h7.oef4;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> items = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int getTotalValue() {
        int value = 0;
        for (Item item : items) {
            value += item.getValue();
        }
        return value;
    }

    public boolean isTotalValueSufficient(int valueNeeded) {
        return getTotalValue() >= valueNeeded;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void replaceItem(Item itemOut, Item itemIn) {
        int index = items.indexOf(itemOut);
        if (index >= 0) {
            items.set(index, itemIn);
        } else {
            System.out.printf("Item '%s' not found...%n", itemOut);
        }
    }

    public void displayItems() {
        System.out.println("+++++++ ITEMS COLLECTED +++++++");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.printf("Total value: %d%n", getTotalValue());
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    public String getName() {
        return name;
    }
}

package be.pxl.ja.knapsack;

import java.util.Collections;
import java.util.List;

public class KnapsackUtil {

    public KnapsackUtil() {};

    public static <E extends Item & Comparable<E>> void fill(Knapsack sack, Inventory<E> inventory) {
        List<E> items = inventory.getItems();

        Collections.sort(items);

        for(E item: items) {
            try {
                sack.add(item);
            } catch (KnapsackFullException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}





package be.pxl.ja.robbery;

import be.pxl.ja.knapsack.Inventory;
import be.pxl.ja.knapsack.Knapsack;
import be.pxl.ja.knapsack.KnapsackUtil;

public class Robbery {
    public static void main(String[] args) {
        Knapsack<Product> knapsack = new Knapsack<>(35);
        Inventory<Product> inventory = new Inventory<>();

        inventory.add(new Product("stereo", 30, 3000));
        inventory.add(new Product("laptop", 20, 2000));
        inventory.add(new Product("guitar", 15, 1500));

        KnapsackUtil.fill(knapsack, inventory);

        System.out.println("\nList of products:");
        for (Product item : knapsack.getItems()) {
            System.out.println(item);
        }
    }
}
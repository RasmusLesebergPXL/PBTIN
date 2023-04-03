package be.pxl.h7.oef2;

import java.util.ArrayList;

public class Bingokaart {
    private String name;
    private ArrayList<Integer> numbers = new ArrayList<>();

    public Bingokaart(String name) {
        this.name = name;
    }

    public void addNumbers (int number) {
        numbers.add(number);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" (");
        for (Integer number : numbers) {
            builder.append(number);
            builder.append(", ");
        }
        int lastComma = builder.lastIndexOf(",");
        builder.deleteCharAt(lastComma);
        return builder.toString().trim() +")";
        }
}

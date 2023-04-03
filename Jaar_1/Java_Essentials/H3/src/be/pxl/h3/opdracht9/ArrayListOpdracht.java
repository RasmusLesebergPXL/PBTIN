package be.pxl.h3.opdracht9;

import java.util.ArrayList;

public class ArrayListOpdracht {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("voorbeeld1");
        list.add("voorbeeld2");
        list.add("voorbeeld3");
        list.add(1,"Tussendoor String");
        list.set(1,"voorbeeld4");
        System.out.println(list);
        list.remove(1);

        System.out.println(list);
        for (String elementen : list) {
            System.out.println(elementen);
        }
        System.out.println("voorbeeld2 is op index: " + list.indexOf("voorbeeld2"));
        list.clear();
        System.out.println(list);


    }
}

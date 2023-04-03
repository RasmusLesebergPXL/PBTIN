package be.pxl.h6.opdracht;

import java.util.ArrayList;
import java.util.Scanner;

public class DagApp {
    public static void main(String[] args) {

        for (Dag dagen : Dag.values() ) {
            System.out.println(dagen + " " + dagen.ordinal() + " " + dagen.getType());
        }
        Scanner vraag = new Scanner(System.in);
        System.out.println("Geef een dag: ");
        int dag = vraag.nextInt();
        vraag.nextLine();
//        ArrayList<Dag> dagenvandeweek() {
//
//        }
    }
}

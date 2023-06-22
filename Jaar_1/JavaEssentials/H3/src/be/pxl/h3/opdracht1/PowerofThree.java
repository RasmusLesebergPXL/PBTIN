package be.pxl.h3.opdracht1;


import java.util.Scanner;

public class PowerofThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef en geheel getal in: ");
        int getal = input.nextInt();
        input.nextLine();
        System.out.println(Math.pow(getal,3));
    }


}

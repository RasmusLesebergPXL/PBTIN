package be.pxl.h3.opdracht7;

import java.util.Scanner;

public class Artikelcode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de artikelcode in: ");
        String artikelcode = input.nextLine();

        char char_1 = artikelcode.charAt(0);
        char char_2 = artikelcode.charAt(1);
        char char_3 = artikelcode.charAt(2);
        char char_4 = artikelcode.charAt(3);

        if (Character.isLetter(char_1) && Character.isLetter(char_2) && Character.isDigit(char_3) && Character.isDigit(char_4) && artikelcode.length() < 5) {
            System.out.println("De artikelcode heeft de juiste syntax");
        }else {
            System.out.println("De artikelcode heeft niet de juiste syntax");
        }
        char letter_1 = Character.toUpperCase(char_1);
        System.out.println(letter_1+artikelcode.substring(1));
    }

}

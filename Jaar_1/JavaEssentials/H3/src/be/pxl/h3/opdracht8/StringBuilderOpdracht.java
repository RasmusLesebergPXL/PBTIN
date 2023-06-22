package be.pxl.h3.opdracht8;

import java.util.Scanner;

public class StringBuilderOpdracht {
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
        String uiteindelijke_string = "";

        char letter_1 = Character.toUpperCase(char_1);
        uiteindelijke_string += letter_1;
        char letter_2 = Character.toLowerCase(char_2);
        uiteindelijke_string += letter_2 + artikelcode.substring(2);

        System.out.println(uiteindelijke_string);

    }
}

package be.pxl.h2.oef4;

public class InputApp {
    public static void main(String[] args) {
        String naam = Input.readLine("Geef je naam");
        int leeftijd = Input.readInt("Geef je leeftijd in.");
        System.out.println("Welkom, " + naam);
        System.out.println("Wauw, al " + leeftijd + "?");

    }
}

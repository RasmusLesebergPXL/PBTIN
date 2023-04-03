package be.pxl.h4.opdracht;

public class BoekApp {
    public static void main(String[] args) {
        Auteur persoon_1 = new Auteur("Michael", "Mystery");
        Boek boek_1 = new Boek("012345", "The Adventures of Michael Mystery", 1000, persoon_1);
        boek_1.toonBoekGegevens();


    }
}

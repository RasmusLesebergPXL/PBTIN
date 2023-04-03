package be.pxl.h1.opdracht5;

public class StripboekApp {
    public static void main(String[] args) {
        Stripboek stripboek1 = new Stripboek();
        stripboek1.setReeks("Suske en Wiske");
        stripboek1.setAuteur("Willy Vandersteen");
        stripboek1.setAlbum(1);
        stripboek1.setTitel("Rikki en Wiske (in Chocowakije)");

        Stripboek stripboek2 = new Stripboek();
        stripboek2.setReeks("Kuifje");
        stripboek2.setAuteur("Herge");
        stripboek2.setAlbum(5);
        stripboek2.setTitel("Tintin, c'est l'aventure No 5");

        Stripboek stripboek3 = new Stripboek();
        stripboek3.setReeks("Lucky Luke");
        stripboek3.setAuteur("Morris");
        stripboek3.setAlbum(7);
        stripboek3.setTitel("Apache Canyon");

        System.out.println(stripboek1.getReeks());
        System.out.println(stripboek1.getAuteur());
        System.out.println(stripboek1.getAlbum() + ". " + stripboek1.getTitel() + "\n");
        System.out.println(stripboek2.getReeks());
        System.out.println(stripboek2.getAuteur());
        System.out.println(stripboek2.getAlbum() + ". " + stripboek2.getTitel() + "\n");
        System.out.println(stripboek3.getReeks());
        System.out.println(stripboek3.getAuteur());
        System.out.println(stripboek3.getAlbum() + ". " + stripboek3.getTitel());
    }
}

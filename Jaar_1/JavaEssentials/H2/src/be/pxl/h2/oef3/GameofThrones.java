package be.pxl.h2.oef3;

public class GameofThrones {
    public static void main(String[] args) {
        Character petyr = new Character("Petyr", "Baelish", "'Littlefinger'", "Baelish", "Aidan Gillen");

        Character thyrion = new Character("Tyrion", "Lannister", "'The Imp'", "Lannister", "Peter Dinklage");
        thyrion.addTitle("'Hand of the King'");
        thyrion.addTitle("'Warden of the West'");
        thyrion.addTitle("'Lord of the Caterly Rock'");
        thyrion.setData(1, 8, 67);

        Character catelyn = new Character("Catelyn", "Stark", "Tully", "Michelle Fairly");
        catelyn.setData(1, 3, 26);

        Character sam = new Character("Samwell", "Tarly", "'Sam'", "Tarly", "John Bradley");
        sam.addTitle("'Grand Maester'");
        sam.setData(1, 8, 48);

        Character marg = new Character("Margarey", "Tyrell", "Tyrell", "Nathalie Dormer");
        marg.addTitle("'Queen Consort'");
        marg.setData(2, 6, 26);

        System.out.println(petyr);
        System.out.println(thyrion);
        System.out.println(catelyn);
        System.out.println(sam);
        System.out.println(marg);
        System.out.println(Character.getCount() + " characters registered");


    }
}

package be.pxl.h5.oef2;

import java.util.ArrayList;

public class Voetballer extends Sporter { //inheritance voorbeeld
    private String club;                    //data hiding voorbeeld
    private String opstelling;
    private ArrayList<String> opstellingen = new ArrayList<>();

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getOpstelling() {
        return opstelling;
    }

    public void setOpstelling(String opstelling) {
        opstellingen.add("middenvelder");
        opstellingen.add("verdediger");
        opstellingen.add("aanvaller");
        opstellingen.add("onbepaald");
        if (opstellingen.contains(opstelling)) {
            this.opstelling = opstelling;
        } else {
            this.opstelling = "onbepaald";
        }
    }

    public Voetballer(String naam, String voornaam) {
        super(naam, voornaam); //constructor overloading?
        setClub("onbepaald");
        setOpstelling("onbepaald");
        setOmschrijving("voetbal");
    }

    public Voetballer(String naam, String voornaam, String club, String opstelling) {
        super(naam, voornaam);
        setClub(club);
        setOpstelling(opstelling);
        setOmschrijving("voetbal");
    }
    @Override  //method overriding
    public void print() {
        System.out.println(getVoornaam() + " " + getNaam());
        System.out.println(getOmschrijving());
        System.out.println("Club: "+ getClub() + " opstelling: " + getOpstelling());
    }

    public ArrayList<String> getOpstellingenArray() {
        return opstellingen;
    }
}

package be.pxl.h8.oef1;

public abstract class Bestand implements Uitvoerbaar {
    private String naam;
    private String inhoud;
    private int bestandsGrootte;

    public Bestand(String naam) {
        this.naam = naam;
    }

    public Bestand(String inhoud, int bestandsGrootte) {
        this.inhoud = inhoud;
        this.bestandsGrootte = bestandsGrootte;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getInhoud() {
        if (inhoud == null) {
            return null;
        } else {
            return inhoud;
        }
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public int getBestandsGrootte() {
        return bestandsGrootte;
    }

    public void setBestandsGrootte(int bestandsGrootte) {
        this.bestandsGrootte = bestandsGrootte;
    }

    @Override
    public String toString() {
        return String.format("%s %10d bytes", naam.toUpperCase(), bestandsGrootte );
    }
}

package be.pxl.opgave;
//Rasmus Leseberg TINK

import java.util.Objects;

public class Gerecht {
    private int aantal;
    private String naam;

    public Gerecht(int aantal, String naam) {
        this.aantal = aantal;
        this.naam = naam;
    }

    public int getAantal() {
        return aantal;
    }

    public String getNaam() {
        return naam;
    }

    public void voegToe(int extraAantal) {
        this.aantal += extraAantal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerecht gerecht = (Gerecht) o;
        return naam.equals(gerecht.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }

    @Override
    public String toString() {
        return String.format("%d x %s", aantal, naam);
    }
}

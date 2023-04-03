package be.pxl.h8.examenvoorbeeld;
/* naam: Rasmus Leseberg*/

public final class Speler extends Persoon {
    private Sport sport;

    public Speler(String id, String naam, Sport sport) {
        super(id, naam);
        this.sport = sport;
    }

    public Speler(String id) {
        super(id, "");
        this.sport = null;
    }

    public Sport getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", super.toString(), sport.toString());
    }
}


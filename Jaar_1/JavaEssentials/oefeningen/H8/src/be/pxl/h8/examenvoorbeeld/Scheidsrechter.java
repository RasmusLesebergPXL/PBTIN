package be.pxl.h8.examenvoorbeeld;
/* naam: Rasmus Leseberg*/

public final class Scheidsrechter extends Persoon {

    public Scheidsrechter(String id, String naam) {
        super(id, naam);
    }

    @Override
    public String toString() {
        return String.format("%s <ref>", super.toString());
    }
}


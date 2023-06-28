package be.pxl.h8.oef2;

public abstract class ZeeObject implements Vernietigbaar {
    private Punt locatie;
    private Alliantie alliantie;
    private int levenspunten;

    public ZeeObject(int x, int y, Alliantie alliantie, int levenspunten) {
        this.locatie = new Punt(x, y);
        this.alliantie = alliantie;
        this.levenspunten = levenspunten;
    }
    public void ontvangSchade(int schade) {
        this.levenspunten -= schade;
    }

    public Alliantie getAlliantie() {
        return alliantie;
    }

    public int getLevenspunten() {
        return levenspunten;
    }

    public Punt getLocatie() {
        return locatie;
    }

    public void setLocatie(Punt locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return String.format("%s # %d HP", locatie, levenspunten);
    }
}

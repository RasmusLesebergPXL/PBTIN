package be.pxl.h6.oef2;

public class Kaart {

    private Soort soort;
    private Ranking ranking;

    public Kaart(Soort soort, Ranking ranking) {
        this.soort = soort;
        this.ranking = ranking;
    }

    public Soort getSoort() {
        return soort;
    }

    public void setSoort(Soort soort) {
        this.soort = soort;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return this.soort.name() + " " + this.ranking.name();
    }
}

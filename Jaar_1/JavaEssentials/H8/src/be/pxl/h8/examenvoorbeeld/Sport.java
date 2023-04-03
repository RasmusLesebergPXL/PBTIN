package be.pxl.h8.examenvoorbeeld;

/* naam: Rasmus Leseberg*/
public enum Sport {
    VOETBAL(11),
    VOLLEYBAL(8),
    TENNIS(2);

    private int aantalSpelers;

    private Sport(int aantalSpelers) {
        this.aantalSpelers = aantalSpelers;
    }

    public int getAantalSpelers() {
        return aantalSpelers;
    }

    @Override
    public String toString() {
        return name().toLowerCase().substring(0, 3);
    }
}


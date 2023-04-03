package be.pxl.opgave;
//Rasmus Leseberg TINK

public final class Restaurant {
    private String naam;
    private TypeKeuken keuken;
    private Adres adres;

    public Restaurant(String naam, TypeKeuken keuken) {
        this.naam = naam;
        this.keuken = keuken;
    }

    public Restaurant(String naam) {
        this.naam = naam;
        this.keuken = TypeKeuken.FAST_FOOD;
    }

    public String getNaam() {
        return naam;
    }

    public TypeKeuken getKeuken() {
        return keuken;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String toString() {
        return naam;
    }
}

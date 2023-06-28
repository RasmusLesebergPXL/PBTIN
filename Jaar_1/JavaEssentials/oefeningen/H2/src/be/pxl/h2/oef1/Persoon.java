package be.pxl.h2.oef1;

public class Persoon {
    private String naam;
    private String voornaam;
    private double lengte;
    private double gewicht;
    private int geboortejaar;
    private int leeftijd;
    private static final double MAX_LENGTE = 2.40;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public double getLengte() {
        return lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }

    @Override
    public String toString() {
        return String.format("Deze persoon is: %s %s\ngewicht: %15.2f\nlengte: %15.2f\ngeboortejaar: %9d\n", getVoornaam(), getNaam(), getGewicht(), getLengte(), getGeboortejaar());
    }

    public double berekenBmi() {
        return getGewicht() / Math.pow(getLengte(), 2);
    }

    public void geefOmschrijving() {
        if (berekenBmi() < 18) {
            System.out.println("ondergewicht");
        } else if (berekenBmi() < 25) {
            System.out.println("normaal");
        } else if (berekenBmi() < 30) {
            System.out.println("overgewicht");
        } else if (berekenBmi() < 40) {
            System.out.println("obesitas");
        } else {
            System.out.println("morbide obesitas");
        }
    }

    public void voegVoornamentoe(String voornamen) {
        voornaam += voornamen;
        setVoornaam(voornaam);
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLengte(double lengte) {
        if (lengte > MAX_LENGTE) {
            lengte = MAX_LENGTE;
        }
        this.lengte = lengte;
    }

    public void groei() {
        lengte += 0.01;
        setLengte(lengte);
    }

    public void groei(double aantalcm) {
        lengte += aantalcm;
        setLengte(lengte);
    }

    public Persoon(String naam, String voornaam) {
        this.naam = naam;
        this.voornaam = voornaam;
    }

    public Persoon() {
        this("onbekend", "onbekend");
    }

    public Persoon(String naam, String voornaam, double lengte, double gewicht, int geboortejaar) {
        super();
        setNaam(naam);
        setVoornaam(voornaam);
        setLengte(lengte);
        setGewicht(gewicht);
        setGeboortejaar(geboortejaar);
    }
}




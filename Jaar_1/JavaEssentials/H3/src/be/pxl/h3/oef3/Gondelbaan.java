package be.pxl.h3.oef3;

public class Gondelbaan {
    private String naam;
    private String land;
    private int hoogteDalstation;
    private int hoogteBergstation;
    private double lengte;
    private int snelheid;
    private int passagiersPerGondel;
    private int aantalGondels;

    public String getNaam() {
        String uiteidelijkeNaam = "";
        String[] words = naam.split("\\s");
        for (String element : words) {
            char eersteLetter = Character.toUpperCase(element.charAt(0));
            String rest = element.substring(1).toLowerCase();
            uiteidelijkeNaam += eersteLetter + rest + " ";
        }
        return uiteidelijkeNaam.trim();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        switch (land) {
            case "Frankrijk" -> this.land = "Frankrijk";
            case "Oostenrijk" -> this.land = "Oostenrijk";
            case "Zwitserland" -> this.land = "Zwitserland";
            case "Italië" -> this.land = "Italië";
            default -> this.land = "Onbekend";
        }
    }

    public int getHoogteDalstation() {
        return hoogteDalstation;
    }

    public void setHoogte(int hoogteDalstation, int hoogteBergstation) {
        if (hoogteBergstation < hoogteDalstation) {
            this.hoogteDalstation = hoogteBergstation;
            this.hoogteBergstation = hoogteDalstation;
        } else {
            this.hoogteDalstation = hoogteDalstation;
            this.hoogteBergstation = hoogteBergstation;
        }
    }

    public int getHoogteVerschil() {
        return (getHoogteBergstation() - getHoogteDalstation());
    }

    public int getHoogteBergstation() {
        return hoogteBergstation;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        if (snelheid < 3) {
            this.snelheid = 3;
        } else this.snelheid = Math.min(snelheid, 8);
    }

    public int getPassagiersPerGondel() {
        return passagiersPerGondel;
    }

    public void setPassagiersPerGondel(int passagiersPerGondel) {
        this.passagiersPerGondel = passagiersPerGondel;
    }

    public int getAantalGondels() {
        return aantalGondels;
    }

    public void setAantalGondels(int aantalGondels) {
        this.aantalGondels = aantalGondels;
    }

    public Gondelbaan(String naam, String land, double lengte, int snelheid) {
        this.naam = naam;
        this.land = land;
        this.lengte = lengte;
        this.snelheid = snelheid;
    }

    public Gondelbaan(String naam, String land) {
        this.naam = naam;
        this.land = land;
        this.lengte = 2;
        this.snelheid = 6;
    }

    public double getDuur() {
        return (getLengte() * 1000 / getSnelheid()) / 60;
    }

    public int getVervoersCapaciteit() {
        return (int) ((60 * getAantalGondels() * getPassagiersPerGondel()) / getDuur());
    }

    public String toString() {
        return getNaam() + " [" + getHoogteVerschil() + "m]";
    }


}


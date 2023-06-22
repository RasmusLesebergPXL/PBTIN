package be.pxl.opgave;
//Rasmus Leseberg TINK

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Bestelling implements Leverbaar{
    private ArrayList<Gerecht> gerechten = new ArrayList<>();
    private Klant klant;
    private Restaurant restaurant;
    private Rider rider;
    private LocalDateTime gewensteLevertijd;
    private LocalDateTime levertijd;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public Bestelling(Klant klant, Restaurant restaurant) {
        this.klant = klant;
        this.restaurant = restaurant;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public void voegGerechtToe(Gerecht gerecht) {
        if (gerechten.size() == 0 || !gerechten.contains(gerecht)) {
            gerechten.add(gerecht);
        } else if (gerechten.contains(gerecht)) {
            gerecht.voegToe(1);
        }
    }

    public ArrayList<Gerecht> getGerechten() {
        return gerechten;
    }

    @Override
    public void setGewensteLevertijd(LocalDateTime gewensteLevertijd) {
        this.gewensteLevertijd = gewensteLevertijd;
    }

    @Override
    public void leveren(LocalDateTime levertijd) {
        this.levertijd = levertijd;
        if (levertijd != gewensteLevertijd) {
            rider.plusBedrag(berekenLeverkosten());
        } else {
            System.out.println("Deze levering is al geleverd");
        }
    }

    @Override
    public double berekenLeverkosten() {
        rider.plusBedrag(-rider.getBedrag());
        rider.plusBedrag(3.5);
        double afstand = Math.round(AfstandTool.getAfstand(klant.getAdres().getCoordinaten(), restaurant.getAdres().getCoordinaten()));
        long time = ChronoUnit.MINUTES.between(gewensteLevertijd, levertijd);
        if (rider.getVoertuig() instanceof Fiets) {
            rider.plusBedrag((0.25 * afstand));
        } else if (rider.getVoertuig() instanceof Scooter scooter) {
            rider.plusBedrag((0.15 * afstand));
        }
        if (time < 5) {
            rider.plusBedrag(0);
        } else if (time < 9 ) {
            rider.plusBedrag(-(rider.getBedrag())*0.02);
        } else if (time < 14 ) {
            rider.plusBedrag(-(rider.getBedrag())*0.04);
        } else if (time < 19 ) {
            rider.plusBedrag(-(rider.getBedrag()) * 0.06);
        } else {
            rider.plusBedrag(-(rider.getBedrag()) * (Math.round(time/5.0) * 0.02));
        }
        double leverkosten = rider.getBedrag();
        if (leverkosten <= 0) {
            return 0;
        }
        return leverkosten;
    }

    @Override
    public String getStatus() {
        if (levertijd != null) {
            return String.format("Bestelling geleverd om %s", levertijd.format(formatter));
        } else if (rider != null) {
            return String.format("Verwachtte levertijd %s", gewensteLevertijd.format(formatter));
        }
        return "Nog even geduld aub.";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(restaurant.toString() + "\n");
        builder.append(String.format("Gewenste levertijd: %s", gewensteLevertijd.format(formatter))).append("\n");
        builder.append(String.format("Klant: %s %s", klant.getVoornaam(), klant.getAchternaam()));
        if (klant.getMobiel()!= null) {
            builder.append(String.format("(%s)",klant.getMobiel())).append("\n");
        } else {
            builder.append("\n");
        }
        builder.append(klant.getAdres());
        for (Gerecht gerecht : getGerechten()) {
            builder.append(String.format("   %s",gerecht.toString())).append("\n");
        }
        return builder.toString();
    }
}

package be.pxl.h8.examenvoorbeeld;
/* naam: Rasmus Leseberg*/

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Toernooi {
    private Wedstrijd[] wedstrijden;
    private static final int MAX_AANTAL_WEDSTRIJDEN = 10;


    public Toernooi() {
        this.wedstrijden = new Wedstrijd[MAX_AANTAL_WEDSTRIJDEN];
    }

    public void voegWedstrijdToe(Wedstrijd wedstrijd) {
        int index = -1;
        for(int i = 0; i < wedstrijden.length; i++) {
            if(wedstrijden[i] == null) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("Geen ruimte meer voor wedstrijden");
            return;
        }
        wedstrijden[index] = wedstrijd;
    }

    public LocalDateTime zoekDatumVolgendeWedstrijdVan(String spelerId) {
        LocalDateTime datum = null;
        for (Wedstrijd wedstrijd: wedstrijden) {
            if(wedstrijd == null)
                continue;

            Team team1 = wedstrijd.team1;
            if(team1 != null) {
                for(Speler speler: team1.spelers) {
                    if(speler.getId().equals(spelerId)) {
                        datum = wedstrijd.getWedstrijdDatum();
                        break;
                    }
                }
            }
            Team team2 = wedstrijd.team2;
            if(team2 != null) {
                for(Speler speler: team2.spelers) {
                    if(speler.getId().equals(spelerId)) {
                        datum = wedstrijd.getWedstrijdDatum();
                        break;
                    }
                }
            }
        }
        return datum;
    }
}


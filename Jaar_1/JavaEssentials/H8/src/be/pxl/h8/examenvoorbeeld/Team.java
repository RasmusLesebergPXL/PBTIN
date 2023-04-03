package be.pxl.h8.examenvoorbeeld;
/* naam: Rasmus Leseberg */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    private Sport sport;
    public Speler[] spelers;

    public Team(Sport sport) {
        this.sport = sport;
        this.spelers = new Speler[sport.getAantalSpelers()];
    }

    private boolean spelerKomtVoor(Speler s) {
        return Arrays.stream(spelers).anyMatch(speler -> speler.equals(s));
    }

    public void voegSpelerToe(Speler speler) {
        if(!speler.getSport().equals(sport) || spelerIdKomtVoor(speler.getId()) || vindVrijePositie() == -1) {
            System.out.println("Foutieve ingave.");
            return;
        }
        spelers[vindVrijePositie()] = speler;
    }

    private int vindVrijePositie() {
        int index = -1;
        for (int i = 0; i < spelers.length; i++) {
            if(spelers[i] == null)
                index = i;
        }
        return index;
    }

    public boolean spelerIdKomtVoor(String spelerId) {
        return Arrays.stream(spelers).filter(speler -> speler != null)
                .anyMatch(speler -> speler.getId().equals(spelerId));
    }

    @Override
    public String toString() {
        if(vindVrijePositie() != -1) {
            return "Onvolledig team";
        }

        StringBuilder team = new StringBuilder();
        for (Speler speler: spelers) {
            team.append(speler.toString()).append("\n");
        }
        return team.toString();
    }

}


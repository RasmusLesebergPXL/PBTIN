package be.pxl.h8.examenvoorbeeld;
/* naam: Rasmus Leseberg*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Wedstrijd implements DatumVergelijkbaar {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    private LocalDateTime wedstrijdDatum;
    public Team team1;
    public Team team2;
    private Scheidsrechter scheidsrechter;
    private int scoreTeam1;
    private int scoreTeam2;

    public Wedstrijd(Team team1, Team team2, Scheidsrechter scheidsrechter, int dag, int maand, int jaar, int uur, int minuut) {
        this.team1 = team1;
        this.team2 = team2;
        this.scheidsrechter = scheidsrechter;
        this.wedstrijdDatum = LocalDateTime.of(jaar, maand, dag, uur, minuut);
    }

    public void setScore(int scoreTeam1, int scoreTeam2) {
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }


    public boolean spelerIdKomtVoor(String id) {
        return team1.spelerIdKomtVoor(id) || team2.spelerIdKomtVoor(id);
    }

    @Override
    public String toString() {
        return "TEAM1" + "\n" +
                team1.toString() + "\n" +
                "TEAM2" + "\n" +
                team2.toString() + "\n" +
                wedstrijdDatum.format(formatter) + "\n" +
                String.format("SCHEIDSRECHTER %s", scheidsrechter.toString()) + "\n" +
                String.format("SCORE %d %d", scoreTeam1, scoreTeam2);
    }

    @Override
    public long berekenAantalMinutenNa(LocalDateTime time) {
        return ChronoUnit.MINUTES.between(wedstrijdDatum, time);
    }

    public LocalDateTime getWedstrijdDatum() {
        return wedstrijdDatum;
    }
}


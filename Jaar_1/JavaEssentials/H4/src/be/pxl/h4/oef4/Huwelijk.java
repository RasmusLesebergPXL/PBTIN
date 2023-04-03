package be.pxl.h4.oef4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Huwelijk {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

    private Persoon partner1;
    private Persoon partner2;
    private LocalDate huwelijksdatum;

    public Huwelijk(Persoon partner1, Persoon partner2, int dag, int maand, int jaar) {
        this.partner1 = partner1;
        this.partner2 = partner2;
        this.huwelijksdatum = LocalDate.of(jaar, maand, dag);

        this.partner2.setAdres(this.partner1.getAdres());

        System.out.printf("%s %s en %s %s zijn gehuwd op %s. Proficiat!%n",
                this.partner1.getVoornaam(), this.partner1.getNaam(),
                this.partner2.getVoornaam(), this.partner2.getNaam(),
                formatter.format(this.huwelijksdatum));
    }

    public Persoon getPartner1() {
        return partner1;
    }

    public Persoon getPartner2() {
        return partner2;
    }

    public LocalDate getHuwelijksdatum() {
        return huwelijksdatum;
    }

    public void adresWijziging(String straat, String huisnummer, int postcode, String gemeenteNaam) {
        Adres nieuw = new Adres(straat, huisnummer, postcode, gemeenteNaam);
        partner1.setAdres(nieuw);
        partner2.setAdres(nieuw);
    }

    public void print() {
        System.out.printf("%s%n%n%s%n%nHet huwelijk vond plaats op %s%n",
                partner1, partner2, formatter.format(huwelijksdatum));
    }
}

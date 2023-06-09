package be.pxl.opgave;
//Rasmus Leseberg TINK

import java.time.LocalDate;

public class Rider extends Persoon {
    private LocalDate geboortedatum;
    private Voertuig voertuig;
    private double bedrag;

    public Rider(String voornaam, String achternaam, LocalDate geboortedatum) {
        super(voornaam, achternaam);
        this.geboortedatum = geboortedatum;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(Voertuig voertuig) {
        this.voertuig = voertuig;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void plusBedrag(double waarde) {
        this.bedrag = getBedrag() + waarde;
    }


}

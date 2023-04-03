package be.pxl.h3.oef4;

import java.time.LocalDate;

public class Activiteit {
    private LocalDate datum;
    private String activiteit;

    public LocalDate getDatum() {
        return datum;
    }

    public String getActiviteit() {
        return activiteit;
    }

    public Activiteit(String naamActiviteit, LocalDate datum){
        this.datum = datum;
        this.activiteit = naamActiviteit;
    }


    @Override
    public String toString() {
        return getDatum() + "   " + getActiviteit();

    }
}

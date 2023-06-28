package be.pxl.h8.oefextra1;

import java.time.LocalDate;

public interface Verkoopbaar {
    int minPrijsM2 = 83;
    void wijsEenNotairsToe(String naam, LocalDate date);
    void doeEenBod(double bod, LocalDate date);
}

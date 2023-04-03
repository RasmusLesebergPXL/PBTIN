package be.pxl.opgave;
//Rasmus Leseberg TINK

import java.time.LocalDateTime;

public interface Leverbaar {
    void setGewensteLevertijd(LocalDateTime gewensteLevertijd);
    void leveren(LocalDateTime levertijd);
    double berekenLeverkosten();
    String getStatus();
}

package be.pxl.h2.oefextra1;

public class Tijdstip {
    private int seconden;

    public Tijdstip(int u, int m, int s) {
        seconden = u * 3600 + m * 60 + s;
        controle();
    }

    public Tijdstip(int aantalSeconden) {
        seconden = aantalSeconden;
        controle();
    }

    public Tijdstip(Tijdstip ander) {
        this.seconden = ander.seconden;

    }
    private void controle() {
        seconden = seconden % 86400;
    }

    public void wijzigUren(int u) {
        seconden += 3600 * u - bepaalUren() * 3600;
        controle();
    }

    public void wijzigMinuten(int m) {
        seconden += 60 * m - bepaalMinuten() * 60  ;
        controle();
    }

    public void wijzigSeconden(int s) {
        seconden = bepaalUren() * 3600 + bepaalMinuten() * 60 + s;
        controle();
    }

    public int bepaalUren() {
        return seconden / 3600;
    }

    public int bepaalMinuten() {
        return seconden % 3600 / 60;

    }

    public int bepaalSeconden() {
        return seconden % 60;

    }


    // opdracht 6
    public void voegUrenToe(int aantalU) {
        seconden += aantalU * 3600;
        controle();
    }


    public void voegUrenToe() {
        voegUrenToe(1);
    }

    public void voegMinutenToe(int aantalM) {
        seconden += aantalM * 60;
        controle();
    }

    public void voegSecondenToe(int aantalS) {
        seconden = seconden + aantalS;
        controle();
    }

    // opdracht 7
    public String toStringTijd(boolean engels) {
        int uren = bepaalUren();
        int minuten = bepaalMinuten();

        if (!engels) {
            return String.format("%d:%02d u", uren, minuten);
        } else {
            if (minuten == 0) {
                if (uren == 0) {
                    return String.format("12:00 AM (midnight)");
                } else {
                    if (uren == 12) {
                        return String.format("12:00 PM (noon)");
                    }
                }
            }
            if (uren < 12) {
                return String.format("%02d:%02d AM", uren, minuten);
            } else {
                int hulpUur = uren - 12;
                return String.format("%02d:%02d PM", hulpUur, minuten);
            }
        }
    }


    // opdracht 8
    public String toStringTechnisch() {

        return String.format("%02d:%02d:%02d", bepaalUren(), bepaalMinuten(), bepaalSeconden());
    }
}


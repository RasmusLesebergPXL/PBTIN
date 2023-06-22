package be.pxl.h4.oef3;

public class Vak {
    private String vak;
    private String vakCode;
    private int studiePunten;

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    public String getVakCode() {
        return vakCode;
    }

    public void setVakCode(String vakCode) {
        this.vakCode = vakCode;
    }

    public int getStudiePunten() {
        return studiePunten;
    }

    public void setStudiePunten(int studiePunten) {
        if (studiePunten > 18) {
            System.out.println("Het aantal SP's is te hoog");
        } else if (studiePunten < 0) {
            System.out.println("Het aantal SP's mag niet lager zijn dan 0");
        }
        this.studiePunten = Input.readInt("Geef een correcte waarde voor de SP: ");
    }

    public Vak(String vak, String vakCode, int studiePunten) {
        this.vak = vak;
        this.vakCode = vakCode;
        this.studiePunten = studiePunten;
    }

}

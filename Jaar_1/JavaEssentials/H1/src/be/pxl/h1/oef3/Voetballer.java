package be.pxl.h1.oef3;

public class Voetballer {
    private int leeftijd;
    private int beoordelingscijfer;
    private String typespeler;
    private int doelpunten;


    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public double getBeoordelingscijfer() {
        return beoordelingscijfer;
    }

    public void setBeoordelingscijfer(int beoordelingscijfer) {
        this.beoordelingscijfer = beoordelingscijfer;
    }

    public String getTypespeler() {
        return typespeler;
    }

    public void setTypespeler(String typespeler) {
        this.typespeler = typespeler;
    }

    public int getDoelpunten() {
        return doelpunten;
    }

    public void setDoelpunten(int doelpunten) {
        this.doelpunten = doelpunten;
    }

    public double getPrijs() {
        int basisprijs;
        if (getTypespeler().equals("aanvaller") || getTypespeler().equals("Aanvaller")) {
            basisprijs = 30000;
        } else if (getTypespeler().equals("middenvelder") || getTypespeler().equals("Middenvelder")) {
            basisprijs = 28000;
        } else if (getTypespeler().equals("verdediger") || getTypespeler().equals("Verdediger")) {
            basisprijs = 29000;
        } else {
            basisprijs = 25000;
        }
        if (getLeeftijd() < 25) {
            basisprijs += basisprijs * 0.1;
        } else if (getLeeftijd() > 30) {
            basisprijs -= basisprijs * 0.05;
        }
        if (getTypespeler().equals("aanvaller") || getTypespeler().equals("Aanvaller")) {
            if (getDoelpunten() <= 5) {
                basisprijs += getDoelpunten() * 10000;
            } else {
                basisprijs += 50000 + ((getDoelpunten()-5) * 20000);
            }
        }
        else if (getTypespeler().equals("middenvelder") || getTypespeler().equals("Middenvelder")) {
            basisprijs = (int) (28000 + (10000 * getBeoordelingscijfer()));
        } else if (getTypespeler().equals("verdediger") || getTypespeler().equals("Verdediger")) {
            basisprijs = (int) (29000 + (10000 * getBeoordelingscijfer()));
        } else if (getTypespeler().equals("doelman") || getTypespeler().equals("Doelman")) {
            basisprijs = (int) (25000 + (10000 * getBeoordelingscijfer()));
            if (getDoelpunten() > 20) {
                basisprijs -= 9000;
            }
        }
        return basisprijs;
    }

    }


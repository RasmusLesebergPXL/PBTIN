package be.pxl.h1.oef8;

public class Lift {
    private int aantalVerdiepingen;
    private int welkeVerdieping;
    private int toegelatenPersonen;
    private int personen;
    private static final int MIN_PERS = 0;

    public void betreed(int aantalPersonen) {
        if ((personen + aantalPersonen) > getToegelatenPersonen()) {
            System.out.println("Het aantal personen is te veel");
        } else {
            personen += aantalPersonen;
            setPersonen(personen);
        }
    }

    public void verlaat(int personenVerlaten) {
        if ((personen-personenVerlaten) < MIN_PERS) {
            System.out.println("Zo veel personen kunnen niet uit de lift stappen");
        } else {
            personen -= personenVerlaten;
            setPersonen(personen);
        }
    }

    public void gaNaar(int verdieping) {
        if (verdieping > getAantalVerdiepingen()) {
            System.out.println("Die verdieping bestaat niet, geef opnieuw een verdieping in: ");
        } else {
            System.out.println("---");
            System.out.println("|" + getWelkeVerdieping() + "|");
            if (verdieping > getWelkeVerdieping()) {
                for (int i = 1; i <= verdieping; i++) {
                    System.out.println("---");
                    System.out.println("---");
                    System.out.println("|" + i + "|");
                }
                System.out.println("---");
            } else if (verdieping < getWelkeVerdieping()) {
                for (int i = getWelkeVerdieping() - 1; i >= verdieping; i--) {
                    System.out.println("---");
                    System.out.println("---");
                    System.out.println("|" + i + "|");
                }
                System.out.println("---");
            }
            setWelkeVerdieping(verdieping);
        }
    }

    public int getAantalVerdiepingen() {
        return aantalVerdiepingen;
    }

    public void setAantalVerdiepingen(int aantalVerdiepingen) {
        this.aantalVerdiepingen = aantalVerdiepingen;
    }

    public int getWelkeVerdieping() {
        return welkeVerdieping;
    }

    public void setWelkeVerdieping(int welkeVerdieping) {
        this.welkeVerdieping = welkeVerdieping;
    }

    public int getToegelatenPersonen() {
        return toegelatenPersonen;
    }

    public void setToegelatenPersonen(int toegelatenPersonen) {
        this.toegelatenPersonen = toegelatenPersonen;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }
}

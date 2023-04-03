package be.pxl.h2.oefextra1;

public class TijdstipApp {

    public static void main(String[] args) {
        Tijdstip tijd1 = new Tijdstip(25, 66, 61);
        System.out.println(tijd1.bepaalUren());
        System.out.println(tijd1.bepaalMinuten());
        System.out.println(tijd1.bepaalSeconden());
        tijd1.voegUrenToe();
        tijd1.voegMinutenToe(61);
        System.out.println(tijd1.toStringTechnisch());


        Tijdstip tijd2 = new Tijdstip(3672);
        tijd2.voegUrenToe(2);

        Tijdstip tijd3 = new Tijdstip(tijd2);

        Tijdstip tijd4 = new Tijdstip(0, 0, 0);
        Tijdstip tijd5 = new Tijdstip(tijd4);
        tijd5.wijzigUren(12);

        Tijdstip[] tabel = new Tijdstip[5];
        tabel[0] = tijd1;
        tabel[1] = tijd2;
        tabel[2] = tijd3;
        tabel[3] = tijd4;
        tabel[4] = tijd5;

        System.out.println("***tabel***");
        for (Tijdstip t : tabel) {
            System.out.println(t.toStringTijd(true));
            System.out.println(t.toStringTijd(false));
        }

    }

}

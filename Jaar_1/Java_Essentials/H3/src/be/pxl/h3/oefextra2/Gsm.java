package be.pxl.h3.oefextra2;

public class Gsm {
    // variabelen
    private int bouwjaar;
    private int krediet;
    private int meterBatterij;
    private String merk;
    private String gsmNummer;
    private String naamEigenaar;
    private String voornaamEigenaar;

    // klassevariabelen
    private static int aantalGsm;


    //constructor
    public Gsm() {
        this(null, "onbekend", 0);  // geen aantal++ nodig
    }

    public Gsm(String merk, String gsmNummer) {
        this(merk, gsmNummer, 0);
    }

    public Gsm(String merk, String gsmNummer, int meterbatterij) {
        setGsmNummer(gsmNummer);
        setMerk(merk);                          // this.merk = merk;  // ONDER setGsmNummer: prima om met setMerk te werken!! erboven uiteraard niet
        setMeterbatterij(meterbatterij);        //this.meterBatterij = meterbatterij;  //setMeterbatterij(meterbatterij) GAAT WEL
        aantalGsm++;
    }

    private String controle(String nummer) {
        // een nummer kan niet null zijn ==> alle drie de constructors vullen nummer op maar... als je setGsmNummer(null) zou uitvoeren in de main...
        if (nummer == null) {
            return "ongeldig";
        }

        if (nummer.equals("onbekend") || nummer.length() != 10 || nummer.charAt(0) != '0'){
            return "ongeldig";
        }

        // enkel nummers met lengte 10 en allemaal cijfers en met een 0 beginnend kunnen uit vorige if komen; voldoende om met 1 te beginnen voor i
        for (int i = 1; i < nummer.length(); i++){
            if (!Character.isDigit(nummer.charAt(i))) {
                return "ongeldig";
            }
        }
        return nummer;
    }

    public void setGsmNummer(String gsmNummer) {
        this.gsmNummer = controle(gsmNummer);
    }

    private boolean controleNummer(String nummer){
        if (nummer.equals("ongeldig") || nummer.equals("onbekend")){
            System.out.println("Geen geldig gsmnummer");
            return false;
        } else {
            return true;
        }
    }

    public void setBouwjaar(int bouwjaar) {
        if (controleNummer(gsmNummer)){
            this.bouwjaar = bouwjaar;
        }
    }

    public void setKrediet(int krediet) {
        if (controleNummer(gsmNummer)){
            this.krediet = krediet;
        }
    }

    public void setMeterbatterij(int meterbatterij) {
        if (controleNummer(gsmNummer)){
            this.meterBatterij = meterbatterij;
        }
    }

    public void setMerk(String merk) {
        if (controleNummer(gsmNummer)){
            this.merk = merk;
        }
    }

    public void setNaamEigenaar(String naamEigenaar) {
        if (controleNummer(gsmNummer)){
            this.naamEigenaar = naamEigenaar;
        }
    }

    public void setVoornaamEigenaar(String voornaamEigenaar) {
        if (controleNummer(gsmNummer)){
            this.voornaamEigenaar = voornaamEigenaar;
        }
    }

    public int toonBeltijd() {
        return krediet * 60;
    }

    public void tik() {
        meterBatterij = meterBatterij - 2;
        if (meterBatterij < 0){
            meterBatterij = 0;
        }
    }

    public void laadOp() {
        meterBatterij = 200;
    }

    public void toonGSM() {
        if (gsmNummer.equals("onbekend")) {
            System.out.println("Dit object is een leeg object en heeft geen waarden voor de eigenschappen");
        } else {
            System.out.println("Het gsmnummer " + gsmNummer + " van " + converteer(naamEigenaar )+ " " + converteer(voornaamEigenaar)
                    + " heeft de volgende kenmerken : ");
            System.out.println("Bouwjaar: " + bouwjaar);
            System.out.println("Merk:" + merk);
            System.out.println("Krediet: " + krediet);
            System.out.println("Meterbatterij: " + meterBatterij);
        }
    }

    private String converteer(String naam){
        if (naam == null){
            return null;
        } else{
            return Character.toUpperCase(naam.charAt(0)) +  naam.substring(1).toLowerCase();
        }
    }

    public String getGsmNummer() {
        return gsmNummer;
    }

    public String getEigenaar() {
        return voornaamEigenaar + " " + naamEigenaar;
    }

    public int getBouwjaar() {
        return bouwjaar;
    }

    public String getMerk() {
        return merk;
    }


    //klassemethode
    public static int getAantalGsm() {
        return aantalGsm;
    }
}

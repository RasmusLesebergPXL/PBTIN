//package be.pxl.h8.oefextra1;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class TeVerkopenBouwGrond extends BouwGrond {
//    private String notaris;
//    private LocalDate datumTeKoop;
//    private double hoogsteBod;
//    private LocalDate datumHoogsteBod;
//
//    public TeVerkopenBouwGrond(String perceelNummer, double perceelGrootte, String bouwVoorschrift) {
//        super(perceelNummer, perceelGrootte);
//        setBouwVoorschrift(bouwVoorschrift);
//    }
//
//    @Override
//    public void wijsEenNotairsToe(String naam, LocalDate date) {
//
//    }
//
//    @Override
//    public void doeEenBod(double bod, LocalDate date) {
//        if (getNotaris() != null
//                && datumHoogsteBod.isAfter(datumTeKoop.plusDays(10))
//                && hoogsteBod == getHoogsteBod()
//                && getHoogsteBod() / 8300 >= minPrijsM2) {
//            doeEenBod(bod, date);
//
//        } else {
//            System.out.println("Er is of geen notaris toegewezen of het bod is te weinig");
//        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
//        System.out.printf("Perceelnummer: %s", getPerceelNummer());
//        System.out.printf("Perceelgrootte: %f", getPerceelGrootte());
//        System.out.printf("Bouwvoorschrift: %s", getBouwVoorschrift());
//        System.out.println("Te koop gesteld op " + formatter.format(datumTeKoop) + " door notaris " + getNotaris());
//        if (teller != 0) {
//            System.out.println("Vorig bod");
//        }
//
//
//    }
//
//    public String getNotaris() {
//        return notaris;
//    }
//
//    public LocalDate getDatumTeKoop() {
//        return datumTeKoop;
//    }
//
//    public double getHoogsteBod() {
//        return hoogsteBod;
//    }
//
//    public LocalDate getDatumHoogsteBod() {
//        return datumHoogsteBod;
//    }
//}

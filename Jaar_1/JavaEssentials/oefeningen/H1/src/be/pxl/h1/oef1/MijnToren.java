package be.pxl.h1.oef1;

public class MijnToren {
    public static void main(String[] args) {
        Toren toren1 = new Toren();
        toren1.setNaam("Zuidertoren");
        toren1.setLocatie("Sint-Gillis, Brussel");
        toren1.setVoltooid(1967);
        toren1.setHoogte(150);
        toren1.setVerdiepingen(37);

        System.out.println(toren1.getNaam()+ " in "+ toren1.getLocatie());
        System.out.println("De toren werd in " + toren1.getVoltooid() + " voltooid, en is " + toren1.getHoogte() + " meter hoog");
        System.out.println("De toren heeft " + toren1.getVerdiepingen() + " verdiepingen");
    }
}

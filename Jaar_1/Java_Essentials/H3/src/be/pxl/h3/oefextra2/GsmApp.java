package be.pxl.h3.oefextra2;

public class GsmApp {
    public static void main(String[] args) {
        Gsm g1=new Gsm();
        Gsm g2= new Gsm("nokia","0477269851");
        Gsm g3 =  new Gsm("Samsung", "0471145890", 45);

        Gsm [] arrayGsm = {g1, g2, g3};

        g1.setBouwjaar(2010);
        g1.setGsmNummer("0495123568");
        g1.setNaamEigenaar("Hanssen");
        g1.setVoornaamEigenaar("Hans");
        g1.setMerk("Samsung");
        g1.setKrediet(50);
        g1.setMeterbatterij(20);
        g1.laadOp();
        g1.tik();

        g3.laadOp();

        for (Gsm gsm : arrayGsm){
            gsm.toonGSM();
        }

        System.out.println("Het aantal gsm's " +  Gsm.getAantalGsm());
    }

}

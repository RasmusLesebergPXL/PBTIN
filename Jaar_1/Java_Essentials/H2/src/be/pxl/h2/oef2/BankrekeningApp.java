package be.pxl.h2.oef2;

public class BankrekeningApp {
    public static void main(String[] args) {
        Bankrekening jeff = new Bankrekening("000-01574125-77", "Jeff Klak", 100, 0.012);
        System.out.printf("Bankrekening geopend met saldo %.2f euro\n", jeff.getSaldo());
        jeff.print();
        jeff.neemOp(50);
        jeff.doeVerrichting();
        jeff.print();
        jeff.stort(20);
        jeff.doeVerrichting();
        jeff.print();
        jeff.schrijfRenteBij();
        jeff.doeVerrichting();
        jeff.print();

        Bankrekening onbekend = new Bankrekening();
        onbekend.setSaldo(200);
        onbekend.neemOp(50);
        onbekend.print();


    }
}

package be.pxl.h4.oef3;

public class LectorApp {
    public static void main(String[] args) {
        Vak[] vakken = new Vak[5];
        vakken[0] = new Vak("Java Essentials", "41TIN1130", 6);
        vakken[1] = new Vak("IT Essentials", "41TIN1300", 6);
        vakken[2] = new Vak(".Net Advanced", "42TIn1240", 3);
        vakken[3] = new Vak("Java Advanced", "42TIN1230", 3);
        vakken[4] = new Vak("Programming Expert", "43AON3120", 3);
        Lector greta = new Lector("Daems", "Greta", 70, vakken );

        greta.print();



    }
}

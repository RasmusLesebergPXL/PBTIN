package be.pxl.h5.opdracht8;

public class FiguurApp {
    public static void main(String[] args) {
        Cirkel cirkel = new Cirkel(2,5,3);
        Cirkel cirkel2 = new Cirkel(3,6,4);
        Rechthoek rechthoek = new Rechthoek(1,4,2,3);
        Driehoek driehoek = new Driehoek(2,5,3,7);

        System.out.printf("Omtrek Cirkel: %.2f \n", cirkel.getOmtrek());
        System.out.printf("Oppervlakte Cirkel: %.2f \n", cirkel.getOppervlakte());
        System.out.printf("Omtrek Cirkel2: %.2f \n", cirkel2.getOmtrek());
        System.out.printf("Oppervlakte Cirkel2: %.2f \n", cirkel2.getOppervlakte());

        System.out.printf("Omtrek Rechthoek: %.2f \n", rechthoek.getOmtrek());
        System.out.printf("Oppervlakte Rechthoek: %.2f \n", rechthoek.getOppervlakte());

        System.out.printf("Omtrek Driehoek: %.2f \n", driehoek.getOmtrek());
        System.out.printf("Oppervlakte Driehoek: %.2f \n", driehoek.getOppervlakte());

    }
}

package be.pxl.h3.oef3;

public class GondelbaanApp {
    public static void main(String[] args) {
        Gondelbaan gondel1 = new Gondelbaan("AGuiLle du mIDI", "Zwitserland", 2654, 6);
        gondel1.setHoogte(1300, 2700);
        System.out.println(gondel1);
    }
}

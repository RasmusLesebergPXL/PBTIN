package be.pxl.h5.oef1;

public class WerknemerApp {
    public static void main(String[] args) {
        Werknemer persoon1 = new Werknemer("Leseberg", "Rasmus");
        Werknemer persoon2 = new Werknemer("vanDael", "Ruben", "IT-Manager", 2300);
        Werknemer persoon3 = new Werknemer("Raspen", "Rosa", "IT-Manager", 800);
        Werknemer persoon4 = new Werknemer("Roos", "Liesl", "IT-Manager", 8300);

        Manager persoon5 = new Manager("Perk", "Thomas", "Baas1", 2600);
        Manager persoon6 = new Manager("Royce", "Rolls", "Baas2", 3000, 2000);

        persoon1.print();
        System.out.println();
        persoon2.print();
        System.out.println();
        persoon3.print();
        System.out.println();
        persoon4.print();
        System.out.println();
        persoon5.print();
        System.out.println();
        persoon6.print();

        System.out.printf("Procentueel aantal managers: %.2f procent", persoon6.getProcAandeelManagers());
    }
}

package be.pxl.h5.opdracht1;

public class SchoolApp {
    public static void main(String[] args) {
        Persoon persoon = new Student();
        persoon.setNaam("Meneer");
        persoon.setVoornaam("Piet");
        if (persoon instanceof Student) {
            ((Student)persoon).setOpleiding("TINK");
            ((Student)persoon).setLeerkrediet(70);
        }
        System.out.println(persoon.getVoornaam());

        Lector lector = new Lector();
        lector.setNaam("Mevrouw");
        lector.setVoornaam("Laura");
        lector.setSalaris(50000);
        lector.setPercentage(18.56);
        lector.setDiploma("Master of Science in Everything");

        lector.print();




    }
}

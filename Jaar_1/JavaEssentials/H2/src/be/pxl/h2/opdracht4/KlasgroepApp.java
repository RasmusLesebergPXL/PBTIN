package be.pxl.h2.opdracht4;

public class KlasgroepApp {
    public static void main(String[] args) {
        Klasgroep[] groepen = new Klasgroep[10];

        groepen[0] = new Klasgroep("TINA", 12);
        groepen[1] = new Klasgroep("TINB", 30);
        groepen[2] = new Klasgroep("TINJ", 32);

        System.out.println("Het max aantal studenten is: " + Klasgroep.MAX_AANTAL);

        for (Klasgroep klasgroep: groepen) {
            if (klasgroep != null) {
                System.out.println(klasgroep.getNaam() + ":" + klasgroep.getAantalStudenten());
            }
        }
        System.out.println("Aantal klasgroep-objecten is: " + Klasgroep.getTeller());
        Klasgroep extraGroep = new Klasgroep();
        System.out.println("Aantal klasgroep-objecten is: " + Klasgroep.getTeller());
        System.out.println("Het totaal aantal studenten is: " + Klasgroep.getTotaalAantalStudenten());
        groepen[1].setAantalStudenten(22);
        System.out.println("Totaal aantal studenten: " + Klasgroep.getTotaalAantalStudenten());
        System.out.printf("Gemiddeld aantal studenten per klasgroep: %.2f", Klasgroep.getGemiddeldAantalStudentenPerKlasgroep());

    }
}

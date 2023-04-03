package be.pxl.h2.opdracht3;

public class KlasgroepApp {
    public static void main(String[] args) {
        Klasgroep klasse = new Klasgroep();
        Klasgroep klasse2 = new Klasgroep("TINA", 12);
        Klasgroep klasse3 = new Klasgroep("TINB", 30);
        Klasgroep klasse4 = new Klasgroep("TINJ", 32);

        System.out.println("Het max aantal studenten is: " + Klasgroep.MAX_AANTAL);


        Klasgroep [] klasgroepen = {klasse, klasse2, klasse3, klasse4}; //of Klasgroep [] = new Klasgroep[3]
        for (Klasgroep klasgroep: klasgroepen) {
            System.out.println(klasgroep.getNaam() + klasgroep.getAantalStudenten());
        }

    }
}

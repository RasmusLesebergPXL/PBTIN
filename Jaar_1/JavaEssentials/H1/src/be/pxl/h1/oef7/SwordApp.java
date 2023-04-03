package be.pxl.h1.oef7;

public class SwordApp {
    public static void main(String[] args) {
        Sword sword1 = new Sword("Stone", 150);
        Sword sword2 = new Sword("Wood", 100);
        Sword sword3 = new Sword("Granite", 250);
        Sword sword4 = new Sword("Carbon", 300);
        Sword sword5 = new Sword("Hardened Glass", 280);
        Sword sword6 = new Sword("Diamond", 400);

        Sword[] swords = {sword1, sword2, sword3, sword4, sword5, sword6};
        System.out.printf("|%15s|%15s|%n", "Material", "Durability");

        for (Sword aantal_swords : swords) {
            System.out.printf("|%15s|%15d|%n", aantal_swords.getMaterial(), aantal_swords.getDurability());
        }

        int max_value = 0;
        String material = "";
        for (Sword aantal_swords : swords) {
            if (aantal_swords.getDurability() > max_value) {
                max_value = aantal_swords.getDurability();
                material = aantal_swords.getMaterial();
            }
        }
        System.out.println("\n The hardest sword is made of: " + material);
    }

    }

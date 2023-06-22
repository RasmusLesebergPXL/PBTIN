package be.pxl.h5.oef3;

public class Warrior extends Human {

    public Warrior(String name) {
        super(name);
        setWeapon(new Sword(100));
    }


    public void setWeapon(Weapon weapon) {
        if (weapon instanceof Sword) {
            System.out.printf("%s: A fine blade!%n", getName());
            super.setWeapon(weapon);
        } else if (weapon instanceof Axe) {
            System.out.printf("%s: Aaah! A fine axe!%n", getName());
            super.setWeapon(weapon);
        } else {
            System.out.printf("%s: I know only how to swing swords and axes.. %n", getName());
        }
    }

    public void attack(Character opponent) {
        speak("Attacking " + opponent.getName() + " with my " + getWeapon());
        super.attack(opponent);
    }

}




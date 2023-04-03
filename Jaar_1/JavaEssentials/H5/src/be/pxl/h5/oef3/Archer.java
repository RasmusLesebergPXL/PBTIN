package be.pxl.h5.oef3;

public class Archer extends Human {

    public Archer(String name) {
        super(name);
        setWeapon(new Bow(10, 5));
    }

    @Override
    public void setWeapon(Weapon mainWeapon) {
        if (mainWeapon instanceof Bow) {
            super.setWeapon(mainWeapon);
        } else {
            speak("I only know how to shoot a bow");
        }
    }

    @Override
    public void attack(Character opponent) {
        speak("Attacking " + opponent.getName() + " with my bow!");
        super.attack(opponent);
    }

    public void findArrows() {
        ((Bow) getWeapon()).addArrows(1 + (int) Math.floor(Math.random() * 9));
    }

}

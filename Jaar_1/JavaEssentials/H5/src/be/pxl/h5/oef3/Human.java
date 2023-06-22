package be.pxl.h5.oef3;

import java.util.ArrayList;

public abstract class Human extends Character {
    private Weapon weapon;
    private ArrayList<Character> defeatedEnemies = new ArrayList<>();

    public Human(String name) {
        super(name, 100);
    }

    @Override
    public void attack(Character opponent) {
        opponent.decreaseHealth(weapon.doDamage());
        if (!opponent.alive()) {
            defeatedEnemies.add(opponent);
        }
    }

    public ArrayList<Character> getDefeatedEnemies() {
        return defeatedEnemies;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon mainweapon) {
        this.weapon = mainweapon;
    }

}



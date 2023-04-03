package be.pxl.h5.oef3;

public class Monster extends Character {
    private double attackPower;

    public Monster(String name, double attackPower) {
        super(name, 50);
        this.attackPower = attackPower;
    }

    @Override
    public void attack(Character opponent) {
        speak("attacking " + opponent.getName());
        opponent.decreaseHealth(attackPower);
    }

    @Override
    public String toString() {
        return getName();
    }
}

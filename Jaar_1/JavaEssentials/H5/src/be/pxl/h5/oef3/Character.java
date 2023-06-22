package be.pxl.h5.oef3;

public abstract class Character {
    private String name;
    private double health;

    public Character(String name, double health) {
        this.name = name;
        this.health = health;
    }
    public boolean alive() {
        return health > 0;
    }

    abstract void attack(Character opponent);

    public double decreaseHealth(double damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            System.out.println("<" + getName() + " is dead>");
        }
        return health;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void heal(double additionalHealth) {
        health += additionalHealth;
        if (getHealth() >= 100) {
            health = 100;
            speak("Feeling great!");
        }
    }

    public void speak(String tekst) {
        System.out.println(name + ": " + tekst);
    }





}

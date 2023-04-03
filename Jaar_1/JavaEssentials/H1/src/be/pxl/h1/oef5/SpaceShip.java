package be.pxl.h1.oef5;

public class SpaceShip {
    private String naam;
    private int hits;
    private boolean shieldOn;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public int getHits() {
        return hits;
    }

    public boolean isShieldOn() {
        return shieldOn;
    }

    public void setShieldOn(boolean shieldOn) {
        this.shieldOn = shieldOn;
        if (isShieldOn()) {
            System.out.println(getNaam() + " has shield on");
        } else {
            System.out.println(getNaam() + " has shield off");
        }
    }


    public void fire(SpaceShip otherSpaceship) {
        System.out.println(getNaam() + " fires at " + otherSpaceship.getNaam());
        if (otherSpaceship.isShieldOn()) {
            hits += 1;
        } else {
            otherSpaceship.hits += 1;
        }
    }


    public boolean isDestroyed() {
        return getHits() >= 5;
    }
}

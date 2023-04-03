package be.pxl.h1.oef5;

import java.util.concurrent.ThreadLocalRandom;


public class SpaceshipApp {
    public static void main(String[] args) {
        SpaceShip spaceship1 = new SpaceShip();
        SpaceShip spaceship2 = new SpaceShip();
        spaceship1.setNaam("BS Galactica");
        spaceship2.setNaam("STS Shade");

        spaceship1.fire(spaceship2);
        spaceship2.fire(spaceship1);

        int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        if (randomNum%2 == 0) {
            spaceship1.setShieldOn(true);
        } else {
            spaceship2.setShieldOn(true);
        }
        for (int i = 1; i <= 4; i++) {
            if (randomNum % 2 == 0) {
                spaceship1.fire(spaceship2);
            } else {
                spaceship2.fire(spaceship1);
            }
        }
        System.out.println(spaceship1.getNaam() + " is destroyed? " + spaceship1.isDestroyed());
        System.out.println(spaceship2.getNaam() + " is destroyed? " + spaceship2.isDestroyed());
    }
}

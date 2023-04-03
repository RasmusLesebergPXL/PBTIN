package be.pxl.h5.oef3;

public class Bow extends Weapon {
    private int numArrows;

    public Bow(int attackPower, int numArrows) {
        super(attackPower);
        this.numArrows = numArrows;
    }

    @Override
    public double doDamage() {

        if (getNumArrows() >= 1) {
            numArrows -= 1;
            return super.doDamage();
        } else {
            System.out.println("Out of arrows");
            return 0;
        }
    }

    public void addArrows(int numArrowsFound) {
        numArrows += numArrowsFound;
    }

    public int getNumArrows() {
        return numArrows;
    }
}



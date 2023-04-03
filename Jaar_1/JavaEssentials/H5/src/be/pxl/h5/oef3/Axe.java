package be.pxl.h5.oef3;

public class Axe extends Weapon {
    private double sharpness = MAX_SHARPNESS;
    public static final double MIN_SHARPNESS = 0.1;
    public static final double MAX_SHARPNESS = 0.8;


    public Axe(int attackPower) {
        super(attackPower);
    }

    @Override
    public double doDamage() {
        double damageDealth = sharpness * super.doDamage();
        sharpness -= 0.2;
        if (sharpness < MIN_SHARPNESS) {
            sharpness = MIN_SHARPNESS;
        }
        return damageDealth;
    }


}


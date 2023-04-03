package be.pxl.h5.oef3;

public class Sword extends Weapon{
    private double sharpness = MAX_SHARPNESS;
    public static final double MIN_SHARPNESS = 0.2;
    public static final double MAX_SHARPNESS = 1.0;

    public Sword(int attackPower) {
        super(attackPower);
    }

    @Override
    public double doDamage() {
        double damageDealth = sharpness * super.doDamage();
        sharpness -= 0.1;
        if (sharpness < MIN_SHARPNESS) {
            sharpness = MIN_SHARPNESS;
        }
        return damageDealth;
    }
}

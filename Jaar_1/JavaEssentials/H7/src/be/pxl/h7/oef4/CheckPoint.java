package be.pxl.h7.oef4;

public final class CheckPoint extends Room {
    private int valueNeeded;

    public CheckPoint(String name, int valueNeeded) {
        super(name);
        this.valueNeeded = valueNeeded;
    }

    public boolean checkPointControl(Player player) {
        return player.isTotalValueSufficient(valueNeeded);
    }
}

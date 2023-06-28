package be.pxl.h7.oef4;

public class TreasureRoom extends Room{
    private Item item;
    private boolean itemAvailable;


    public TreasureRoom(String name, Item item) {
        super(name);
        this.item = item;
        itemAvailable = true;
    }

    public void takeItem(Player player) {
        if (itemAvailable) {
            player.addItem(item);
            itemAvailable = false;
        }
    }

    @Override
    public String getInstructions() {
        StringBuilder builder = new StringBuilder(super.getInstructions());
        if (itemAvailable) {
            builder.append(String.format("TAKE %s", item));
        }
        return builder.toString();
    }


    @Override
    public String toString() {
        return super.toString() + (itemAvailable ? "*" : "");
    }

}

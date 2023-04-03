package be.pxl.h7.oef4;

public class Laboratory extends Room {
    private Item fromItem;
    private Item toItem;


    public Laboratory(String name, Item input, Item result) {
        super(name);
        fromItem = input;
        toItem = result;
    }

    @Override
    public String getInstructions() {
        StringBuilder builder = new StringBuilder(super.getInstructions());
        builder.append(String.format("TRANSFORM %s -> %s", fromItem, toItem));
        return builder.toString();
    }

    public void transform(Player player) {
        player.replaceItem(fromItem, toItem);
    }
}

package be.pxl.h1.oef7;

public class Sword {
    private String material;
    private int durability;

    public Sword(String material, int durability) {
        setMaterial(material);
        setDurability(durability);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }


}

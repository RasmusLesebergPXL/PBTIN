package be.pxl.rct.shop;

import java.io.Serializable;

public class Shop implements Serializable {

    private String shopName;
    private ShopType shopType;


    public Shop(ShopType type, String name){
        shopType = type;
        shopName = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ShopType getShopType() {
        return shopType;
    }

    public void setShopType(ShopType shopType) {
        this.shopType = shopType;
    }

    @Override
    public String toString() {
        return "* " + shopName + " [" + shopType + "]";
    }
}

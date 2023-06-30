package rct.shop;

import be.pxl.rct.shop.Shop;
import be.pxl.rct.shop.ShopType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {

    @Test
    void setShopNameTest(){
        Shop shop = new Shop(ShopType.PIZZA_STALL,"MyPizzaShop");
        shop.setShopName("NewName");
        Assertions.assertEquals(shop.getShopName(),"NewName");
    }
    @Test
    void setShopNameType(){
        Shop shop = new Shop(ShopType.PIZZA_STALL,"MyPizzaShop");
        shop.setShopType(ShopType.ICECREAM_STALL)   ;
        Assertions.assertEquals(shop.getShopType(),ShopType.ICECREAM_STALL);
    }

    @Test
    void getPricePerItem(){
        Shop shop = new Shop(ShopType.PIZZA_STALL,"MyPizzaShop");
        Shop shop2 = new Shop(ShopType.BALLOON_STALL,"MyBalloonStall");
        Assertions.assertEquals(shop.getShopType().getPricePerItem(),1.6 );
        Assertions.assertEquals(shop2.getShopType().getPricePerItem(),1 );
    }
    @Test
    void getProfitPerItem(){
        Shop shop = new Shop(ShopType.PIZZA_STALL,"MyPizzaShop");
        Shop shop2 = new Shop(ShopType.BALLOON_STALL,"MyBalloonStall");
        Assertions.assertEquals(shop.getShopType().getProfitPerItem(),1 );
        Assertions.assertEquals(shop2.getShopType().getProfitPerItem(),0.7);
    }
}

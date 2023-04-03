package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.shop.Shop;
import be.pxl.rct.shop.ShopType;
import be.pxl.rct.themepark.ThemePark;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;

public class AddShopCommand {

    public static void execute(ThemePark themePark, String[] commands) {
        try {
            if (commands.length == 1 || commands.length == 2) {
                throw new CommandNotFoundException("Enter the <shoptype> and <shopname> after 'add-shop'");
            }
            else if (!EnumUtils.isValidEnum(ShopType.class, commands[1].toUpperCase())) {
                throw new CommandNotFoundException("The entered <shoptype> is not a valid shoptype");
            }
            else {

                String[] nameArray = Arrays.copyOfRange(commands, 2, commands.length);
                String shopName = String.join(" ", nameArray);

                Shop newShop = new Shop(ShopType.valueOf(commands[1].toUpperCase()), shopName);
                themePark.addShop(newShop);
            }
        }
        catch (CommandNotFoundException commandNotFoundException) {
            System.out.println(commandNotFoundException.getMessage());
        }
    }
}

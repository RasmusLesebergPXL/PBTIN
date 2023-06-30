package be.pxl.rct.commands;

import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.shop.Shop;
import be.pxl.rct.themepark.ThemePark;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DescribeCommand  {

    public static void execute(ThemePark themePark) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(themePark.getName()).append("\n");
        builder.append("Cash: ").append(numberFormat.format(themePark.getCash())).append("\n");
        builder.append("Days open: ").append(themePark.getDaysOpen()).append("\n");
        builder.append("Number of rollercoasters: ").append(themePark.getRollerCoasters().size()).append("\n");

        List<RollerCoaster> sortedList = themePark.getRollerCoasters()
                .stream()
                .sorted(Comparator.comparing(RollerCoaster::getName))
                .collect(Collectors.toList());

        for (RollerCoaster rollerCoaster : sortedList) {
            builder.append("\t").append(rollerCoaster.toString()).append("\n");
        }
        builder.append("Number of shops: ").append(themePark.getShops().size()).append("\n");

        List<Shop> sortedShops = themePark.getShops()
                .stream()
                .sorted(Comparator.comparing(Shop::getShopName))
                .collect(Collectors.toList());

        for (Shop shop : sortedShops) {
            builder.append("\t").append(shop.toString()).append("\n");
        }
        System.out.println(builder);
    }
}

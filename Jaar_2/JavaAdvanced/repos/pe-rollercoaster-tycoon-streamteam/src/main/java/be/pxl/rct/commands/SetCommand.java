package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.themepark.ThemeParkProperties;
import be.pxl.rct.themepark.ThemePark;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;

public class SetCommand {

    private static String propertyAmount;

    public static void execute(ThemePark themePark, String[] commands) {
        try {
            if (commands.length == 1) {
                throw new CommandNotFoundException("Enter the name of the property to set");
            }
            else if (!EnumUtils.isValidEnum(ThemeParkProperties.class, commands[1].toUpperCase().replace("-", "_"))) {
                throw new CommandNotFoundException("The entered property is not a valid property");
            }
            else if (commands.length < 3) {
                throw new CommandNotFoundException("Enter a correct amount for the property to set");
            }
            else {
                String propertyName = commands[1].trim().toLowerCase();

                if (propertyName.equals("name")) {
                    String[] name = Arrays.copyOfRange(commands, 2, commands.length);
                    propertyAmount = String.join(" ", name);
                } else {
                    propertyAmount = commands[2].trim();
                }

                switch (propertyName.toLowerCase()) {
                    case "name" -> themePark.setName(propertyAmount);
                    case "entrance-fee" -> themePark.setEntranceFee(Double.parseDouble(propertyAmount));
                    case "daysopen" -> themePark.setDaysOpen(Integer.parseInt(propertyAmount));
                    case "cash" -> themePark.setCash(Double.parseDouble(propertyAmount));
                    case "day-duration" -> themePark.setDayTimeDuration(Double.parseDouble(propertyAmount));
                }
            }
        }
        catch (CommandNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println("Can't parse the given value");
        }
    }
}

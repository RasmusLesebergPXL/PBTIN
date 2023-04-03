package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.themepark.ThemePark;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCommand {

    public static ThemePark execute(ArrayList<RollerCoasterType> rides, List<String> properties, String[] commands)  {
        try {
            if (commands.length == 1) {
                throw new CommandNotFoundException("Enter a correct name for your new themepark after the create command");
            }
            String[] name = Arrays.copyOfRange(commands, 1, commands.length);
            String parkName = String.join(" ", name);

            ThemePark themePark = new ThemePark(parkName, rides);

            themePark.setCash(Double.parseDouble(properties.get(0)));
            themePark.setDayTimeDuration(Double.parseDouble(properties.get(1)));

            return themePark;
        }
        catch (CommandNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.themepark.ThemePark;
import java.util.Arrays;

public class AddRollerCoasterCommand {

    public static void execute(ThemePark themePark, String[] commands) throws CommandNotFoundException {
        try {
            if (commands.length == 1 || commands.length == 2) {
                throw new CommandNotFoundException("Enter the <RollercoasterID> and <rollercoasterName>");
            } else {
                String[] nameWithSpaces = Arrays.copyOfRange(commands, 2, commands.length);
                String rollerCoasterName = String.join(" ", nameWithSpaces);
                int id = Integer.parseInt(commands[1]);
                if (id > 12 || id < 0) {
                    throw new CommandNotFoundException("rollercoaster ID is not valid");
                }
                else {
                    RollerCoaster newRollerCoaster = new RollerCoaster(id, rollerCoasterName);
                    themePark.addRollercoaster(newRollerCoaster);
                }
            }
        } catch(CommandNotFoundException | NumberFormatException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.themepark.ThemePark;
import java.io.*;
import java.util.Arrays;

public class LoadCommand {

    public static ThemePark execute(String[] commands) {
        try {
            if (commands.length == 1) {
                throw new CommandNotFoundException("Enter a filename after 'load' to load");
            } else {
                String[] fileNameArray = Arrays.copyOfRange(commands, 1, commands.length);
                String themeParkName = String.join("_", fileNameArray);
                String fileName = "src/main/resources/themeparks/" + themeParkName + ".ser";

                FileInputStream file = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(file);

                return (ThemePark) in.readObject();
            }
        }
        catch (ClassNotFoundException | IOException | CommandNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

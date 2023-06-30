package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.themepark.ThemePark;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SaveCommand  {

    public static void execute(ThemePark themePark, String[] commands) {
        try {
            if (commands.length == 1) {
                throw new CommandNotFoundException("Enter a filename after 'save' to save");
            } else {
                String[] themeParkName = Arrays.copyOfRange(commands, 1, commands.length);
                String parkName = String.join("_", themeParkName);
                String fileName = "src/main/resources/themeparks/" + parkName + ".ser";

                FileOutputStream file = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(themePark);

                file.close();
                out.close();
            }
        } catch(CommandNotFoundException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}

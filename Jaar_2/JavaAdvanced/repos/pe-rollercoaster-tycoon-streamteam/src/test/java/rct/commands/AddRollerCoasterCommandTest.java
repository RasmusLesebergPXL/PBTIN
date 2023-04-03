package rct.commands;

import be.pxl.rct.commands.AddRollerCoasterCommand;
import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.rollercoaster.RollerCoasterReader;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.themepark.ThemePark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class AddRollerCoasterCommandTest {

    private ArrayList<RollerCoasterType> rollerCoasterTypes;
    private ThemePark themePark;

    @BeforeEach
    void init() {
        Path pathProperties = Path.of("src", "main", "resources", "rct.properties");
        ArrayList<String> properties = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(pathProperties);
            String line = reader.readLine();

            while (line != null) {
                String[] propertyLine = line.split("=");
                properties.add(propertyLine[1]);
                line = reader.readLine();
            }

            rollerCoasterTypes = RollerCoasterReader.loadRollerCoasterType(Path.of(String.valueOf(properties.get(2))));
            themePark = new ThemePark("testThemePark", rollerCoasterTypes);
            themePark.setCash(10000);
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Test
    void  RollerCoasterNameWithSpacesTest() throws CommandNotFoundException {
        String command = "add-rollercoaster 1 name with spaces";
        String[] commands = command.split(" ");

        AddRollerCoasterCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getRollerCoasters().get(0).getName(), "name with spaces");
    }

    @Test
    void  RollerCoasterNameWithSpecialCharsTest() throws CommandNotFoundException {
        String command = "add-rollercoaster 1 Th!sN@me 'is' $pecial";
        String[] commands = command.split(" ");

        AddRollerCoasterCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getRollerCoasters().get(0).getName(), "Th!sN@me 'is' $pecial");
    }

    @Test
    void  RollerCoasterWithInvalidIdNotAllowed() throws CommandNotFoundException {
        String command = "add-rollercoaster -4 abc";
        String[] commands = command.split(" ");

        AddRollerCoasterCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getRollerCoasters().size(), 0);
    }

    @Test
    void  RollerCoasterIdenticalNameNotAllowed() throws CommandNotFoundException {
        String command = "add-rollercoaster 4 abc";
        String[] commands = command.split(" ");
        AddRollerCoasterCommand.execute(themePark, commands);

        String secondCommand = "add-rollercoaster 4 abc";
        String[] secondCommands = secondCommand.split(" ");
        AddRollerCoasterCommand.execute(themePark, secondCommands);

        Assertions.assertEquals(themePark.getRollerCoasters().size(), 1);
    }
}

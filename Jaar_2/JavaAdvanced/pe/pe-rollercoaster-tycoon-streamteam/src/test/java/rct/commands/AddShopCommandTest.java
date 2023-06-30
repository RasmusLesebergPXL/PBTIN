package rct.commands;

import be.pxl.rct.commands.AddRollerCoasterCommand;
import be.pxl.rct.commands.AddShopCommand;
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

public class AddShopCommandTest {

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
    void  ShopNameNameWithSpacesTest() throws CommandNotFoundException {
        String command = "add-shop Burger_bar name with spaces";
        String[] commands = command.split(" ");

        AddShopCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getShops().get(0).getShopName(), "name with spaces");
    }

    @Test
    void  ShopNameWithSpecialCharsTest() throws CommandNotFoundException {
        String command = "add-shop Burger_bar Th!sN@me 'is' $pecial";
        String[] commands = command.split(" ");

        AddShopCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getShops().get(0).getShopName(), "Th!sN@me 'is' $pecial");
    }

    @Test
    void  AddShopWithInvalidShopTypeNotAllowed() throws CommandNotFoundException {
        String command = "add-shop burgers abc";
        String[] commands = command.split(" ");

        AddShopCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getShops().size(), 0);
    }

    @Test
    void  AddShopWithIdenticalNameNotAllowed() throws CommandNotFoundException {
        String command = "add-shop Burger_bar abc";
        String[] commands = command.split(" ");
        AddShopCommand.execute(themePark, commands);

        String secondCommand = "add-shop Burger_bar abc";
        String[] secondCommands = secondCommand.split(" ");
        AddShopCommand.execute(themePark, secondCommands);

        Assertions.assertEquals(themePark.getShops().size(), 1);
    }
}

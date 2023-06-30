package rct.commands;

import be.pxl.rct.commands.LoadCommand;
import be.pxl.rct.commands.SaveCommand;
import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.rollercoaster.RollerCoasterReader;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.shop.Shop;
import be.pxl.rct.shop.ShopType;
import be.pxl.rct.themepark.ThemePark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SaveAndLoadCommandTest {

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
    void SaveAndLoadFileReturnsCorrectThemePark() {
        //CREATE THEMEPARK
        themePark.addRollercoaster(new RollerCoaster(2, "my fun coaster"));
        themePark.addRollercoaster(new RollerCoaster(4, "the best coaster"));
        themePark.addShop(new Shop(ShopType.SOUVENIR_SHOP, "All the gifts"));
        themePark.addShop(new Shop(ShopType.DRINKS_STALL, "Ice cold Beer"));

        //SAVE THEMEPARK
        String[] saveCommand = "save the best park ever".split(" ");
        SaveCommand.execute(themePark, saveCommand);

        //LOAD THEMEPARK
        String[] loadCommand = "load the best park ever".split(" ");
        ThemePark loadedThemePark = LoadCommand.execute(loadCommand);

        if (loadedThemePark != null) {
            Assertions.assertEquals(loadedThemePark.getName(), "testThemePark");
            Assertions.assertEquals(loadedThemePark.getRollerCoasters().get(0).getName(), "my fun coaster");
            Assertions.assertEquals(loadedThemePark.getRollerCoasters().get(1).getName(), "the best coaster");
            Assertions.assertEquals(loadedThemePark.getShops().size(), 2);
        }
    }

    @Test
    void LoadWithOutNameReturnNull() {
        String[] command = "load".split(" ");
        ThemePark themePark = LoadCommand.execute(command);
        Assertions.assertNull(themePark);
    }
}

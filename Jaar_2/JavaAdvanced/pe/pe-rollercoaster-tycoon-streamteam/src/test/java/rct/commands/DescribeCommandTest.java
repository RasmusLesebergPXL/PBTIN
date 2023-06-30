package rct.commands;

import be.pxl.rct.commands.DescribeCommand;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DescribeCommandTest {

    private ThemePark themePark;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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

            ArrayList<RollerCoasterType> rollerCoasterTypes = RollerCoasterReader.loadRollerCoasterType(Path.of(String.valueOf(properties.get(2))));
            themePark = new ThemePark("testThemePark", rollerCoasterTypes);
            themePark.setCash(10000);
        }
        catch (IOException e) {
            e.getStackTrace();
        }
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void ShouldOutputCorrectInfo() {
        themePark.addRollercoaster(new RollerCoaster(4, "abc"));
        themePark.addRollercoaster(new RollerCoaster(4, "def"));
        themePark.addShop(new Shop(ShopType.BURGER_BAR, "myburgers"));

        String output = """ 
                Name: testThemePark
                Cash: 7060,00
                Days open: 0
                Number of rollercoasters: 2
                	* abc [Junior Roller Coaster, ROLLER_COASTER]
                	* def [Junior Roller Coaster, ROLLER_COASTER]
                Number of shops: 1
                	* myburgers [BURGER_BAR]""";

        DescribeCommand.execute(themePark);

        Assertions.assertEquals(output, outputStreamCaptor.toString().trim());
    }

    @Test
    void ShouldOutputInfoAlphabetically() {
        themePark.addRollercoaster(new RollerCoaster(4, "xyz"));
        themePark.addRollercoaster(new RollerCoaster(4, "def"));
        themePark.addShop(new Shop(ShopType.BURGER_BAR, "thebestburgers"));
        themePark.addShop(new Shop(ShopType.BURGER_BAR, "myburgers"));

        String output = """ 
                Name: testThemePark
                Cash: 6760,00
                Days open: 0
                Number of rollercoasters: 2
                	* def [Junior Roller Coaster, ROLLER_COASTER]
                	* xyz [Junior Roller Coaster, ROLLER_COASTER]
                Number of shops: 2
                	* myburgers [BURGER_BAR]
                	* thebestburgers [BURGER_BAR]""";

        DescribeCommand.execute(themePark);

        Assertions.assertEquals(output, outputStreamCaptor.toString().trim());
    }
}

package rct.commands;

import be.pxl.rct.commands.ShowTypeCommand;
import be.pxl.rct.rollercoaster.RideGenre;
import be.pxl.rct.rollercoaster.RollerCoasterReader;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.shop.ShopType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShowTypeCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ArrayList<RollerCoasterType> rides;


    @BeforeEach
    void init() {
        Path pathProperties = Path.of("src", "main", "resources", "rct.properties");
        try {
            ArrayList<String> properties = new ArrayList<>();
            this.rides = new ArrayList<>();

            BufferedReader reader = Files.newBufferedReader(pathProperties);
            String line = reader.readLine();

            while (line != null) {
                String[] propertyLine = line.split("=");
                properties.add(propertyLine[1]);
                line = reader.readLine();
            }
            rides = RollerCoasterReader.loadRollerCoasterType(Path.of(String.valueOf(properties.get(2))));
        } catch (IOException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
        }
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void ShowTypeShopShouldShowShops() {
        String[] commands = "show -type shop".split(" ");

        StringBuilder stringbuilder = new StringBuilder();
        for (ShopType type : ShopType.values()){
            stringbuilder.append(type.name()).append(" [").append(type.getItemType()).append("]\r\n");
        }

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(stringbuilder.toString().trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    void SettingWrongParametersShouldSetNothing() {
        String[] commands = "show -type rollercoaster -min-cost 1000 -max-cost 250".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.MIN_FILTER_AMOUNT, 1000);
        //DEFAULT VALUE
        Assertions.assertEquals(ShowTypeCommand.MAX_FILTER_AMOUNT, 100000);
    }

    @Test
    void SettingMinFilterShouldSetAmount() {
        String[] commands = "show -type rollercoaster -min-cost 500".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.MIN_FILTER_AMOUNT, 500);
    }

    @Test
    void SettingMaxFilterShouldSetAmount() {
        String[] commands = "show -type rollercoaster -max-cost 5000".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.MAX_FILTER_AMOUNT, 5000);
    }

    @Test
    void SettingRideGenreFilterShouldSetGenre() {
        String[] commands = "show -type rollercoaster -ride water_ride".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.GENRE, RideGenre.WATER_RIDE);
    }


    @Test
    void SettingAllFiltersShouldSetAll() {
        String[] commands = "show -type rollercoaster -ride Thrill_ride -min-cost 250 -max-cost 2500".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.MIN_FILTER_AMOUNT, 250);
        Assertions.assertEquals(ShowTypeCommand.MAX_FILTER_AMOUNT, 2500);
        Assertions.assertEquals(ShowTypeCommand.GENRE, RideGenre.THRILL_RIDE);
    }

    @Test
    void SettingWrongGenreShouldSetNothing() {
        String[] commands = "show -type rollercoaster -ride noRealGenre -min-cost 250 -max-cost 2500".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.MIN_FILTER_AMOUNT, 250);
        Assertions.assertEquals(ShowTypeCommand.MAX_FILTER_AMOUNT, 2500);
        Assertions.assertNull(ShowTypeCommand.GENRE);
    }

    @Test
    void SettingWrongParamsShouldSetNothing() {
        String[] commands = "show -type rollercoaster -ride noRealGenre -min-cost -10 -max-cost -200".split(" ");

        ShowTypeCommand.execute(commands, rides);
        Assertions.assertEquals(ShowTypeCommand.MIN_FILTER_AMOUNT, 0);
        //DEFAULT VALUE
        Assertions.assertEquals(ShowTypeCommand.MAX_FILTER_AMOUNT, 100000);
        Assertions.assertNull(ShowTypeCommand.GENRE);
    }

    @AfterEach
    void clearValues() {
        ShowTypeCommand.MAX_FILTER_AMOUNT = 100000;
        ShowTypeCommand.MIN_FILTER_AMOUNT = 0;
        ShowTypeCommand.GENRE = null;
    }

}

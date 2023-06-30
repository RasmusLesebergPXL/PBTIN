package rct.engine;

import be.pxl.rct.engine.SimulateDayThread;
import be.pxl.rct.rollercoaster.RollerCoasterReader;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.themepark.ThemePark;
import be.pxl.rct.visitor.Visitor;
import be.pxl.rct.visitor.VisitorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SimulateDayThreadTest {
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
    void DaysOpenIncreasesWhenThemeParkOpens(){
        SimulateDayThread simulateDayThread = new SimulateDayThread(themePark);
        simulateDayThread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(themePark.getDaysOpen() > 0);
    }
    @Test
    void DaysOpenIsNullWhenThemeParkDidNotOpen(){
        Assertions.assertEquals(0, themePark.getDaysOpen());
    }
}

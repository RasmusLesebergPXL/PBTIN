package rct.rollercoaster;

import be.pxl.rct.engine.WaitingLine;
import be.pxl.rct.rollercoaster.RollerCoaster;
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
import java.util.List;

public class RollerCoasterTest {
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
    void VisitorsHappinessIncreasesWhenEnteringARide(){
        int INITIAL_HAPPINESS = 100;
        VisitorFactory visitorFactory = new VisitorFactory(themePark);
        Visitor visitor = visitorFactory.createVisitor();
        visitor.setHappinessLevel(INITIAL_HAPPINESS);

        RollerCoaster rollerCoaster = new RollerCoaster(1,"name");
        themePark.addRollercoaster(rollerCoaster);

        rollerCoaster.enter(visitor);

        int happinessAfterRide = visitor.getHappinessLevel();

        Assertions.assertTrue(happinessAfterRide > INITIAL_HAPPINESS);

    }

    @Test
    void GetVisitorsInWaitingLine(){
        RollerCoaster rollerCoaster = new RollerCoaster(1,"name with spaces");
        themePark.addRollercoaster(rollerCoaster);
        WaitingLine<Visitor> waitingLine = new WaitingLine<>(rollerCoaster.getTime(),rollerCoaster);
        rollerCoaster.setWaitingLine(waitingLine);
        VisitorFactory visitorFactory = new VisitorFactory(themePark);
        List<Visitor> visitors = new ArrayList<>();
        for (int i = 0; i <= rollerCoaster.getAllowed(); i++) {
            Visitor visitor = visitorFactory.createVisitor();
            visitors.add(visitor);
            waitingLine.addVisitor(visitor);
        }

        Assertions.assertEquals(waitingLine.getVisitors(), visitors);
    }

    @Test
    void RollerCoasterNameWithSpaces(){
        RollerCoaster rollerCoaster = new RollerCoaster(1,"name with spaces");
        themePark.addRollercoaster(rollerCoaster);
        Assertions.assertEquals(rollerCoaster.getName(), "name with spaces");

    }
    @Test
    void RollerCoasterNameWithoutSpaces(){
        RollerCoaster rollerCoaster = new RollerCoaster(1,"name");
        themePark.addRollercoaster(rollerCoaster);
        Assertions.assertEquals(rollerCoaster.getName(), "name");
    }
    @Test
    void GetAllowedPassengersIsRight(){
        RollerCoaster rollerCoaster = new RollerCoaster(1,"name");
        themePark.addRollercoaster(rollerCoaster);
        Assertions.assertEquals(rollerCoaster.getAllowed(),16);
    }

    @Test
    void GetTimeIsRight(){
        RollerCoaster rollerCoaster = new RollerCoaster(1,"name");
        themePark.addRollercoaster(rollerCoaster);
        Assertions.assertEquals(rollerCoaster.getTime(),25);
    }

}

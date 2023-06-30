package rct.commands;

import be.pxl.rct.commands.CreateCommand;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.themepark.ThemePark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCommandTest {

    private List<String> properties;
    private ArrayList<RollerCoasterType> types;

    @BeforeEach
    void init() {
        this.types = new ArrayList<>();
        this.properties = new ArrayList<>();

        properties.add("10000");
        properties.add("10000");
    }
    @Test
    void createThemeParkReturnsNewThemePark() {
        String command = "create My Super Fun Theme Park";
        String[] commands = command.split(" ");

        ThemePark themePark = CreateCommand.execute(types, properties, commands);

        assert themePark != null;
        assertEquals(themePark.getCash(), 10000);
        assertEquals(themePark.getDayTimeDuration(), 10000);
    }

    @Test
    void createThemeParkWithSpecialCharsReturnsNewThemePark() {
        String command = "create !@$%#%^@#&&*#'''";
        String[] commands = command.split(" ");

        ThemePark themePark = CreateCommand.execute(types, properties, commands);

        assert themePark != null;
        assertEquals(themePark.getName(), "!@$%#%^@#&&*#'''");
    }

    @Test
    void createThemeParkWithNoNameMakesNoThemePark() {
        String command = "create";
        String[] commands = command.split(" ");

        ThemePark themePark = CreateCommand.execute(types, properties, commands);

        Assertions.assertNull(themePark);
    }

}
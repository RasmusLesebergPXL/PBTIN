package rct.commands;

import be.pxl.rct.commands.SetCommand;
import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.themepark.ThemePark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SetCommandTest {

    private ThemePark themePark;

    @BeforeEach
    void init() {
        this.themePark = new ThemePark("Fun Park", new ArrayList<>());
    }

    @Test
    void SetEntranceFeeShouldChangeEntranceFee() {
        String[] commands = "set entrance-fee 2.5".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getEntranceFee(), 2.5);
    }

    @Test
    void setCashShouldChangeCash() {
        String[] commands = "set cash 5000".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getCash(), 5000.0);
    }

    @Test
    void setNameShouldChangeName() {
        String[] commands = "set name Fun Park 2".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getName(), "Fun Park 2");
    }

    @Test
    void SetDaysOpenShouldChangeDaysOpen() {
        String[] commands = "set daysopen 4".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getDaysOpen(), 4);
    }

    @Test
    void SetDayDurationShouldChangeDayDuration() {
        String[] commands = "set day-duration 40000".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getDayTimeDuration(), 40000.0);
    }

    @Test
    void WrongPropertyNameShouldChangeNothing() {
        String[] commands = "set day-durdsion 40000".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getDayTimeDuration(), 0.0);
    }

    @Test
    void WrongParameterShouldChangeNothing() {
        String[] commands = "set cash abc".split(" ");
        SetCommand.execute(themePark, commands);
        Assertions.assertEquals(themePark.getCash(), 0.0);
    }
}


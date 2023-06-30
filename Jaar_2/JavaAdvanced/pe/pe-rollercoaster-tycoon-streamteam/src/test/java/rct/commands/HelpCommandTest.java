package rct.commands;

import be.pxl.rct.commands.HelpCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelpCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void ShouldOutputCorrectInfo() {
        String output = """
                        List of possible commands:
                        ==========================================================
                        
                        create <name>
                        save <filename>
                        load <filename>
                        set <property> <value>
                        show -type <type>
                        add-shop <type> <name>
                        add-rollercoaster <type> <name>
                        describe
                        open
                        quit""";

        HelpCommand.execute();

        Assertions.assertEquals(output, outputStreamCaptor.toString().trim());
    }
}

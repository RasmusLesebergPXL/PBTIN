package be.pxl.rct.commands;

public class HelpCommand {

    public static void execute() {
        System.out.println(
                """
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
                        quit
                        """);
    }
}

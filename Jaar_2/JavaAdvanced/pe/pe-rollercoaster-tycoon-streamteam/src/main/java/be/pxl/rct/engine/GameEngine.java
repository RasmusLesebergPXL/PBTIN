package be.pxl.rct.engine;

import be.pxl.rct.commands.*;
import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.rollercoaster.RollerCoasterReader;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.themepark.ThemePark;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private boolean running = true;
    private ArrayList<RollerCoasterType> rides;
    private List<String> properties;
    private ThemePark themePark;

    public void start() {
        System.out.println("""
                 .----------------.  .----------------.  .----------------.     .----------------.  .----------------.  .----------------.\s
                | .--------------. || .--------------. || .--------------. |   | .--------------. || .--------------. || .--------------. |
                | |   ______     | || |  ____  ____  | || |   _____      | |   | |  _______     | || |     ______   | || |  _________   | |
                | |  |_   __ \\   | || | |_  _||_  _| | || |  |_   _|     | |   | | |_   __ \\    | || |   .' ___  |  | || | |  _   _  |  | |
                | |    | |__) |  | || |   \\ \\  / /   | || |    | |       | |   | |   | |__) |   | || |  / .'   \\_|  | || | |_/ | | \\_|  | |
                | |    |  ___/   | || |    > `' <    | || |    | |   _   | |   | |   |  __ /    | || |  | |         | || |     | |      | |
                | |   _| |_      | || |  _/ /'`\\ \\_  | || |   _| |__/ |  | |   | |  _| |  \\ \\_  | || |  \\ `.___.'\\  | || |    _| |_     | |
                | |  |_____|     | || | |____||____| | || |  |________|  | |   | | |____| |___| | || |   `._____.'  | || |   |_____|    | |
                | |              | || |              | || |              | |   | |              | || |              | || |              | |
                | '--------------' || '--------------' || '--------------' |   | '--------------' || '--------------' || '--------------' |
                 '----------------'  '----------------'  '----------------'     '----------------'  '----------------'  '----------------'\s
                                
                Press '?' to get an overview of the usable commands
                """);
    }
    //PROPERTIES BESTAND INLEZEN
    public void init() {
        Path pathProperties = Path.of("src", "main", "resources", "rct.properties");
        this.properties = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(pathProperties);
            String line = reader.readLine();

            while (line != null) {
                String[] propertyLine = line.split("=");
                properties.add(propertyLine[1]);
                line = reader.readLine();
            }
            String logDirectoryPath = properties.get(3);
            String themeParkDirectoryPath = properties.get(4);

            //DIRS AANMAKEN
            new File(String.valueOf(Path.of(logDirectoryPath))).mkdir();
            new File(String.valueOf(Path.of(themeParkDirectoryPath))).mkdir();

            //ROLLERCOASTERS INLEZEN
            rides = RollerCoasterReader.loadRollerCoasterType(Path.of(String.valueOf(properties.get(2))));
        }
        catch (IOException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
        }
    }
    //COMMAND SECTION
    public void executeCommand(String command) {
        try {
            String[] commands = command.split(" ");
            String commandInput = commands[0].trim();
            //QUIT COMMAND------------------------------------------->
            if (commands[0].equals("quit")) {
                running = false;
            }
            //HELP COMMAND------------------------------------------->
            else if (commandInput.equals("?")) {
                HelpCommand.execute();
            }
            //CREATE COMMAND----------------------------------------->
            else if (commandInput.equalsIgnoreCase("create")) {
                themePark = CreateCommand.execute(rides, properties, commands);
            }
            //SET PROPERTY COMMAND----------------------------------->
            else if (commandInput.equalsIgnoreCase("set")) {
                if (themeParkExists()) {
                    SetCommand.execute(themePark, commands);
                }
            }
            //SHOW -TYPE COMMAND------------------------------------->
            else if (commandInput.toLowerCase().startsWith("show")) {
                ShowTypeCommand.execute(commands, rides);
            }
            //ADD SHOP & ROLLERCOASTER COMMAND----------------------->
            else if (commandInput.toLowerCase().startsWith("add")) {
                if (themeParkExists()) {
                    if (commandInput.equalsIgnoreCase("add-shop")) {
                        AddShopCommand.execute(themePark, commands);
                    } else if (commandInput.equalsIgnoreCase("add-rollercoaster")) {
                        AddRollerCoasterCommand.execute(themePark, commands);
                    } else {
                        throw new CommandNotFoundException("Enter either 'add-shop' or 'add-rollercoaster'");
                    }
                }
            }
            //DESCRIBE COMMAND--------------------------------------->
            else if (commandInput.equalsIgnoreCase("describe")) {
                if (themeParkExists()) {
                    DescribeCommand.execute(themePark);
                }
            }
            //SAVE COMMAND------------------------------------------->
            else if (commandInput.equalsIgnoreCase("save")) {
                if (themeParkExists()) {
                    SaveCommand.execute(themePark, commands);
                }
            }
            //LOAD COMMAND------------------------------------------->
            else if (commandInput.equalsIgnoreCase("load")) {
                ThemePark themePark = LoadCommand.execute(commands);
                ThemePark.setRollerCoasterTypes(rides);
                this.themePark = themePark;
            }
            //OPEN COMMAND------------------------------------------->
            else if (commandInput.equalsIgnoreCase("open")) {
                if (themeParkExists()) {
                    OpenCommand.execute(themePark);
                }
            } else {
                throw new CommandNotFoundException("Command not found");
            }
        } catch (CommandNotFoundException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public boolean themeParkExists() {
        try {
            if (this.themePark == null) {
                throw new CommandNotFoundException("Create a themepark before using this command");
            }
            return true;
        } catch (CommandNotFoundException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isRunning() {
        return running;
    }
}
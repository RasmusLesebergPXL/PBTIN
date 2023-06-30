package be.pxl.rct.commands;

import be.pxl.rct.engine.SimulateDayThread;
import be.pxl.rct.themepark.ThemePark;

public class OpenCommand {

    public static void execute(ThemePark themePark) {

        System.out.println("Themepark is open. Can not execute commands while open.");

        SimulateDayThread simulateDayThread = new SimulateDayThread(themePark);
        //Run zorgt voor beter cli output i.p.v start
        simulateDayThread.run();

    }
}

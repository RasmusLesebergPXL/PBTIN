package be.pxl.rct.engine;

import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.themepark.ThemePark;
import be.pxl.rct.visitor.Visitor;
import be.pxl.rct.visitor.VisitorFactory;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SimulateDayThread extends Thread {

    private ThemePark themePark;
    private VisitorFactory visitorFactory;
    private final Random RANDOM = new Random();

    public SimulateDayThread(ThemePark park) {
        this.themePark = park;
        visitorFactory = new VisitorFactory(themePark);
    }

    @Override
    public synchronized void run() {
        themePark.setDaysOpen(themePark.getDaysOpen() + 1);

        // Stap 1: bepaal de sluitingstijd van het themapark
        long startTime = System.currentTimeMillis();
        long endTime = (long) (startTime + themePark.getDayTimeDuration());

        //Stap 2: maak voor iedere Rollercoaster een WaitingLine aan en start de threads
        while(startTime < endTime) {
            for (RollerCoaster rollerCoaster: themePark.getRollerCoasters()) {
                WaitingLine<Visitor> waitingLine = new WaitingLine<>(rollerCoaster.getTime(), rollerCoaster);
                rollerCoaster.setWaitingLine(waitingLine);
                waitingLine.start();
            }

            //stap 3: maak op willekeurige tijdstippen bezoeker-threads aan (gebruik VisitoryFactory) en start deze op
            //Duur van Visitor bezoek wordt in de Visitorklasse geregeld bij Stap 4
            if (RANDOM.nextInt(50) == 0) {
                Visitor visitor = visitorFactory.createVisitor();
                visitor.start();
            }
            startTime = System.currentTimeMillis();
        }
        //Stap 4: als de dag is afgelopen, schrijf je een bestand (log/pretparknaam_dag.txt) aan met de volgende gegevens:
        writeLogFile();
    }

    private synchronized void writeLogFile() {
        try {
            int amountOfVisitors = themePark.getDailyVisitors().size();
            int totalAmountOfVisitors = themePark.getTotalVisitors().size();

            double averageHappiness =
                    themePark.getDailyVisitors()
                            .stream()
                            .mapToDouble(Visitor::getHappinessLevel)
                            .average()
                            .orElse(0);

            String nameHappiestVisitor =
                    themePark.getDailyVisitors()
                            .stream()
                            .max(Comparator.comparing(Visitor::getHappinessLevel))
                            .map(Visitor::getFirstname)
                            .orElse(null);

            double valueHappiestVisitor =
                    themePark.getDailyVisitors()
                            .stream()
                            .max(Comparator.comparing(Visitor::getHappinessLevel))
                            .map(Visitor::getHappinessLevel)
                            .orElse(0);

            String nameUnhappiestVisitor =
                    themePark.getDailyVisitors()
                            .stream()
                            .min(Comparator.comparing(Visitor::getHappinessLevel))
                            .map(Visitor::getFirstname)
                            .orElse(null);

            double valueUnhappiestVisitor =
                    themePark.getDailyVisitors()
                            .stream()
                            .min(Comparator.comparing(Visitor::getHappinessLevel))
                            .map(Visitor::getHappinessLevel)
                            .orElse(0);

            double averageRidesTaken =
                    themePark.getDailyVisitors()
                            .stream()
                            .mapToDouble(Visitor::getNumberOfRides)
                            .average()
                            .orElse(0);

            double totalAmountSpent =
                    themePark.getDailyVisitors()
                            .stream()
                            .mapToDouble(Visitor::getCashSpent)
                            .sum();

            double timeSpentInThemePark =
                    themePark.getDailyVisitors()
                            .stream()
                            .mapToDouble(Visitor::getTimeSpentInThemePark)
                            .average()
                            .orElse(0);

            String nameLongestVisitorStay =
                    themePark.getDailyVisitors()
                            .stream()
                            .max(Comparator.comparing(Visitor::getTimeSpentInThemePark))
                            .map(Visitor::getFirstname)
                            .orElse(null);

            double valueLongestStayVisitor =
                    themePark.getDailyVisitors()
                            .stream()
                            .max(Comparator.comparing(Visitor::getTimeSpentInThemePark))
                            .map(Visitor::getTimeSpentInThemePark)
                            .orElse(0.0);

            double totalCash = themePark.getCash();


            BufferedWriter writer = Files.newBufferedWriter((Paths.get("src/main/resources/logs/" + themePark.getName() + "_"+ themePark.getDaysOpen() + ".txt")));
            DecimalFormat numberFormat = new DecimalFormat("#.00");

            String fileInfo =
                            "        Cash: " + numberFormat.format(totalCash) + "€\n" +
                            "        Totaal aantal bezoekers: " + totalAmountOfVisitors + "\n" +
                            "        Aantal bezoekers vandaag: " + amountOfVisitors + "\n" +
                            "        Gemiddelde happiness: " + (int) (averageHappiness) + "\n" +
                            "        Gelukkigste bezoeker: " + nameHappiestVisitor + " " + (int) valueHappiestVisitor + "\n" +
                            "        Ongelukkigste bezoeker: " + nameUnhappiestVisitor + " " + (int) valueUnhappiestVisitor + "\n" +
                            "        Gemiddelde aantal ritjes/bezoeker: " + numberFormat.format(averageRidesTaken) + "\n" +
                            "        Totaal bedrag uitgegeven vandaag: " + numberFormat.format(totalAmountSpent) + "€\n" +
                            "        Gemiddelde tijd: " + numberFormat.format(timeSpentInThemePark) + "\n" +
                            "        Langste bezoek: " + nameLongestVisitorStay + " " + valueLongestStayVisitor;

            ArrayList<Visitor> emptyList = new ArrayList<>();
            themePark.setDailyVisitors(emptyList);

            writer.write(fileInfo);
            writer.close();

        } catch(IOException e){
            e.getStackTrace();
            System.err.println(e.getMessage());
        }
    }
}

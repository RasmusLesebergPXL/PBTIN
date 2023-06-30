package be.pxl.car;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CollisionAppRunner {

    public static void main(String[] args) {

        CollisionApp collisionApp = new CollisionApp();
        System.out.println("** Number of collision records: " + collisionApp.getNumberOfCollisionRecords());
        System.out.println("** Number of collisions with rain in weekend: " + collisionApp.getNumberOfCollisionsWithRainInWeekend() );
        System.out.println("** Number of weather types: " + collisionApp.getNumberOfWeatherTypes());
        System.out.println("** Average number of cartypes involved: " + collisionApp.getAverageNumberOfCarTypesInvolved());
        System.out.println("** Different weathertypes: " + collisionApp.getDifferentWeatherTypesInMonth("augustus", "nacht"));
        System.out.println("** Month with most seriously injured: " + collisionApp.getMonthWithMostCollisionsWithSeriouslyInjured());

        Path[] paths = {
                Path.of("src", "main", "resources", "provincesSortedByName.txt"),
                Path.of("src", "main", "resources", "provincesSortedByDensity.txt"),
                Path.of("src", "main", "resources", "collisions_bedrijfswagens.txt"),
        };
        // TODO 1. schrijf provincesSortedByName.txt
        // TODO 2. schrijf provincesSortedByDensity.txt
        // TODO 3. schrijf collisions_bedrijfswagens.txt
        collisionApp.saveToFile(collisionApp.getAllProvinces()
                .stream()
                .sorted(Comparator.comparing(Province::getName))
                .collect(Collectors.toList()), paths[0]);

        collisionApp.saveToFile(collisionApp.getAllProvinces()
                .stream()
                .sorted(Comparator.comparing(Province::getDensity))
                .collect(Collectors.toList()), paths[1]);

        collisionApp.saveToFile(new ArrayList<>(collisionApp.getCollisionRecordsByOwnerType("Bedrijfswagen")), paths[2]);
    }
}

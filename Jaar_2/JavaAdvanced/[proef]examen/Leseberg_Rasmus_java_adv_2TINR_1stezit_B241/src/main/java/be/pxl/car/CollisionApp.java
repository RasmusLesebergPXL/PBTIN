package be.pxl.car;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CollisionApp {

    private List<CollisionRecord> collisionRecords;
    private final Map<String, Province> provinceMap = new HashMap<>();

    public CollisionApp() {
        provinceMap.put("Brussel-Hoofdstad", new Province("Brussel-Hoofdstad", 1222637, 161));
        provinceMap.put("Provincie Antwerpen", new Province("Provincie Antwerpen", 1886609, 2867));
        provinceMap.put("Provincie Henegouwen", new Province("Provincie Henegouwen", 1351127, 3786));
        provinceMap.put("Provincie Limburg", new Province("Provincie Limburg", 885951, 2422));
        provinceMap.put("Provincie Luik", new Province("Provincie Luik", 1110989, 3862));
        provinceMap.put("Provincie Luxemburg", new Province("Provincie Luxemburg", 291143, 4505));
        provinceMap.put("Provincie Namen", new Province("Provincie Namen", 499454, 3600));
        provinceMap.put("Provincie Oost-Vlaanderen", new Province("Provincie Oost-Vlaanderen", 1543865, 2982));
        provinceMap.put("Provincie Vlaams-Brabant", new Province("Provincie Vlaams-Brabant", 1173440, 2106));
        provinceMap.put("Provincie Waals-Brabant", new Province("Provincie Waals-Brabant", 409782, 1091));
        provinceMap.put("Provincie West-Vlaanderen", new Province("Provincie West-Vlaanderen", 1209011, 3144));

        // TODO: lees het bestand TF_VEHICLES_COLLISION_2021.csv in de resources folder
        //  met behulp van de CollisionReader ken de ingelezen records toe aan de variabele collisionRecords
        try {
            Path path = Path.of("src", "main", "resources", "TF_VEHICLES_COLLISION_2021.csv");
            collisionRecords = CollisionReader.loadCollisionRecords(path, provinceMap);
        }
        catch (CollisionException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
        }
    }

    // TODO 1. het aantal collision-records in de lijst (geen stream!)
    public int getNumberOfCollisionRecords() {
        return collisionRecords.size();
    }

    // TODO 2. aantal ongevallen in het weekend met regen (weather is “Regenval”)?
    public long getNumberOfCollisionsWithRainInWeekend() {
        return collisionRecords
                .stream()
                .filter(v -> v.getWeather().equals("Regenval"))
                .filter(CollisionRecord::isWeekend)
                .count();
    }

    // TODO 3. aantal unieke weer types
    public long getNumberOfWeatherTypes() {
        return collisionRecords
                .stream()
                .map(CollisionRecord::getWeather)
                .distinct()
                .count();
    }

    // TODO 4. gemiddelde aantal car types betrokken bij een ongeval
    public double getAverageNumberOfCarTypesInvolved() {
        int totalTypes = 0;
        for(CollisionRecord record : collisionRecords) {
            totalTypes += record.getCarTypes().size();
        }
        return (double) totalTypes /

                collisionRecords
                .stream()
                .map(CollisionRecord::getCarTypes).count();
    }

    // TODO 5. CollisionRecords met het opgegeven ownerType
    public List<CollisionRecord> getCollisionRecordsByOwnerType(String ownerType) {
        return collisionRecords
                .stream()
                .filter(v -> v.getOwnerType().equals(ownerType))
                .collect(Collectors.toList());
    }

    // TODO 6. maand met het meeste ongevallen met zwaargewonden en het aantal ongevallen
    public String getMonthWithMostCollisionsWithSeriouslyInjured() {
        return collisionRecords
                .stream()
                .filter(v -> v.getAccidentClass().equals("met zwaargewonden"))
                .collect(Collectors.groupingBy(CollisionRecord::getMonth, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null) + ": " +

                collisionRecords
                        .stream()
                        .filter(v -> v.getAccidentClass().equals("met zwaargewonden"))
                        .filter(v -> v.getMonth().equals("oktober"))
                        .count();
    }

    // TODO 7. verschillende weertypes voor de opgegeven maand en dagdeel
    public String getDifferentWeatherTypesInMonth(String month, String nightOrDay) {
        return collisionRecords
                .stream()
                .filter(v -> v.getMonth().equals(month))
                .filter(v -> v.getDayNight().equals(nightOrDay))
                .map(CollisionRecord::getWeather)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    // TODO 8. lijst met alle provincies (uit provinceMap, geen stream)
    public List<Province> getAllProvinces() {
        List<Province> provinceList = new ArrayList<>();
        for (Map.Entry<String, Province> entry : provinceMap.entrySet()) {
            provinceList.add(entry.getValue());
        }
        return  provinceList;
    }
    // TODO: implementeer generieke methode saveToFile
    public void saveToFile(List<Object> list, Path path) {
        //outsourced to FileSaver klasse
        FileSaver fileSaver = new FileSaver(list, path);
        fileSaver.start();
        try {
            fileSaver.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

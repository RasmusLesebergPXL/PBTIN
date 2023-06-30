package be.pxl.car;

import java.util.*;

public class CollisionRecordMapper {

    public static CollisionRecord mapToCollisionRecord(String record, Map<String, Province> provinceMap) throws UnknownProvinceException {
        String[] splitRecord = record.split(";");
        CollisionRecord collisionRecord = new CollisionRecord();
        collisionRecord.setMonth(splitRecord[0]);
        collisionRecord.setDayNight(splitRecord[1]);

        boolean flagWeekend;
        flagWeekend = Objects.equals(splitRecord[2], "Y");
        collisionRecord.setWeekend(flagWeekend);

        collisionRecord.setOwnerType(splitRecord[3]);

        // mapping car type flags naar list (code is volledig)
        int[] carTypes = Arrays.stream(splitRecord, 4, 13)
                .mapToInt(Integer::parseInt)
                .toArray();
        collisionRecord.setCarTypes(getCarTypes(carTypes));


//             TODO: zoek de Province met de opgegeven naam (splitRecord[13]) in de provinceMap
//             TODO: als deze Province niet bestaat gooi je een UnknownProvinceException
        if (provinceMap.get(splitRecord[13]) == null) {
            throw new UnknownProvinceException("Onbekende provincie: " + splitRecord[13]);
        }
        else {
            collisionRecord.setProvince(provinceMap.get(splitRecord[13]));
        }

        collisionRecord.setWeather(splitRecord[14]);
        collisionRecord.setLightCondition(splitRecord[15]);
        collisionRecord.setRoadType(splitRecord[16]);
        collisionRecord.setAccidentClass(splitRecord[17]);
        return collisionRecord;
    }

    public static List<CarType> getCarTypes(int[] values) {
        List<CarType> carTypes = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1) {
                switch (i) {
                    case 0 -> carTypes.add(CarType.VEHICLE);
                    case 1 -> carTypes.add(CarType.CITY_CAR);
                    case 2 -> carTypes.add(CarType.COMPACT_CAR);
                    case 3 -> carTypes.add(CarType.BERLINE);
                    case 4 -> carTypes.add(CarType.SUV);
                    case 5 -> carTypes.add(CarType.MONOSPACE);
                    case 6 -> carTypes.add(CarType.PICKUP);
                    case 7 -> carTypes.add(CarType.TRUCK_BUS);
                    case 8 -> carTypes.add(CarType.MOTO_CYCLO);
                    case 9 -> carTypes.add(CarType.SPORT);
                }
            }
        }
        return carTypes;
    }


}

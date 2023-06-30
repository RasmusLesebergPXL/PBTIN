package be.pxl.ja.opgave1;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ActivityMapper {
    public static Activity mapDataToActivity(Path activityFile, Path errorFile, String[] list, CustomerRepository customerRepository) {
        Activity activity = new Activity();
        String customerNumber = "";
        try {
            if (activityFile.toString().toLowerCase().contains("strava")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                customerNumber = list[0].split(" ")[2];
                activity.setActivityDate(LocalDate.parse(list[1], formatter));
            }
            else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                customerNumber = list[1];
                activity.setActivityDate(LocalDate.parse(list[0], formatter));
            }
            //ERROR HANDLING
            if (customerRepository.getByCustomerNumber(customerNumber) == null) {
                ErrorHandler.writeErrorLog(activityFile, errorFile, "UNKNOWN CUSTOMER:", String.join(";", list));
            }

            activity.setCustomerNumber(customerNumber);
            activity.setActivityType(ActivityType.valueOf(list[2].toUpperCase()));
            activity.setDistance(Double.parseDouble(list[3]));

            if (activity.getActivityType().equals(ActivityType.SWIMMING)) {
                customerRepository.getByCustomerNumber(customerNumber)
                        .addPoints((int) Math.floor((activity.getDistance() / 1000) * activity.getActivityType().getPointsPerKm()));
            }
            else {
                customerRepository.getByCustomerNumber(customerNumber)
                        .addPoints((int) Math.floor((activity.getDistance()) * activity.getActivityType().getPointsPerKm()));
            }
            return activity;
        }
        catch (Exception e) {
            ErrorHandler.writeErrorLog(activityFile, errorFile, e.getMessage(), "");
            return null;
        }
    }
}

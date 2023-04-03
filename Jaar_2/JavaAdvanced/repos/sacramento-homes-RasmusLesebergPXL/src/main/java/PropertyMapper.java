import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PropertyMapper {
    public static Property mapDataToProperty(String[] list) {
        Property property = new Property();

        try {
            //street,city,zip,state,beds,baths,sq__ft,type,sale_date,price,latitude,longitude
            property.setStreet(list[0]);
            property.setCity(list[1]);
            property.setZip(list[2]);
            property.setState(list[3]);
            property.setBeds(Integer.parseInt(list[4]));
            property.setBaths(Integer.parseInt(list[5]));
            property.setSqft(Integer.parseInt(list[6]));
            property.setType(list[7]);

            String pattern = "EEE MMM d HH:mm:ss z yyyy";
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(list[8], DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
            property.setDate(LocalDate.from(zonedDateTime));

            property.setPrice(Integer.parseInt(list[9]));
            property.setLatitude(Double.parseDouble(list[10]));
            property.setLongitude(Double.parseDouble(list[11]));

            return property;
        }
        catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }
}

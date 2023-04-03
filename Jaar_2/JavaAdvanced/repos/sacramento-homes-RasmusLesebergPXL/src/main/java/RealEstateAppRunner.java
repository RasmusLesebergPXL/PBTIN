import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;

public class RealEstateAppRunner {
    public static void main(String[] args) {
        RealEstateApp realEstateApp = new RealEstateApp();
        new File(String.valueOf(Path.of("src", "main", "files"))).mkdir();

        FileSaver[] fileSavers = {
                new FileSaver(realEstateApp.propertiesAbovePrice(100000),
                        Path.of("src", "main", "files", "priceFilter.txt")),
                new FileSaver(realEstateApp.propertiesForZIPCode("95827"),
                        Path.of("src", "main", "files", "zipcodeFilter.txt")),
                new FileSaver(realEstateApp.propertiesSoldAfter(LocalDate.of(2008, 5, 18)),
                        Path.of("src", "main", "files", "dateFilter.txt")),
                new FileSaver(realEstateApp.lastPropertiesSold(100),
                        Path.of("src", "main", "files", "lastSold.txt")),
        };

        for (FileSaver fs : fileSavers) {
            fs.start();
        }

        for (FileSaver value : fileSavers) {
            try {
                value.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("** Cheapest house: " + realEstateApp.findCheapest());
    }
}

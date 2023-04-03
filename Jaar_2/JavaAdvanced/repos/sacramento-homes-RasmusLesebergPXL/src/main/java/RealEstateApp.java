
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RealEstateApp {
    private ArrayList<Property> sacramentoHomes;

    public RealEstateApp() {
        Path homesPath = Path.of("src", "main", "resources", "sacramento_homes.csv");
        sacramentoHomes = PropertyReader.loadProperties(homesPath);
    }

    public List<Property> propertiesAbovePrice(int price) {
        return sacramentoHomes
                .stream()
                .filter(v -> v.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<Property> propertiesForZIPCode(String zip) {
        return sacramentoHomes
                .stream()
                .filter(v -> v.getZip().equals(zip))
                .collect(Collectors.toList());
    }

    public List<Property> propertiesSoldAfter(LocalDate date) {
        return sacramentoHomes
                .stream()
                .filter(v -> v.getDate().isAfter(date))
                .collect(Collectors.toList());
    }

    public List<Property> lastPropertiesSold(int amount) {
        return sacramentoHomes
                .stream()
                .sorted(Comparator.comparing(Property::getDate).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    public Property findCheapest() {
        return sacramentoHomes
                .stream()
                .filter(p -> p.getCity().equalsIgnoreCase("Sacramento"))
                .filter(q -> q.getBeds() >= 3)
                .filter(r -> r.getSqft() >= 1000)
                .min(Comparator.comparing(Property::getPrice))
                .orElse(null);
    }
}

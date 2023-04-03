import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PropertyReader {
    public static ArrayList<Property> loadProperties(Path path) {
        ArrayList<Property> properties = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null)
            {
                try {
                    String[] propertyInformation = line.split(",");
                    properties.add(PropertyMapper.mapDataToProperty(propertyInformation));
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return properties;
    }
}

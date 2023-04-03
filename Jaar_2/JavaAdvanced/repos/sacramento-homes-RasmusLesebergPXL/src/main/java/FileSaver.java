import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSaver extends Thread {

    private List<Property> properties;
    private Path path;
    public FileSaver(List<Property> propertyList, Path path) {
        this.properties = propertyList;
        this.path = path;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Property property : properties) {
                writer.write(property.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}

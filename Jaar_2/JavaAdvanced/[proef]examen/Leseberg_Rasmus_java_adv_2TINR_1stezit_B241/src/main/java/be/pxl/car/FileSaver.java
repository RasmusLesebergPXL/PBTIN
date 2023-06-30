package be.pxl.car;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSaver extends Thread {

    private List<Object> objects;
    private Path path;
    public FileSaver(List<Object> objectList, Path path) {
        this.objects = objectList;
        this.path = path;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Object obj  : objects) {
                writer.write(obj.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

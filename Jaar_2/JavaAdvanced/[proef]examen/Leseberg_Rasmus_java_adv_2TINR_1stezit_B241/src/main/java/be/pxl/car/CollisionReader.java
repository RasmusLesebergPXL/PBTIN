package be.pxl.car;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollisionReader {

    public static List<CollisionRecord> loadCollisionRecords(Path path, Map<String, Province> provinceMap) throws CollisionException {
        ArrayList<CollisionRecord> collisionRecords = new ArrayList<>();
        try {
            if (!Files.exists(path)) {
                throw new CollisionException("Invalid pathname");
            }
            BufferedReader reader = Files.newBufferedReader(path);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null)
            {
                try {
                    collisionRecords.add(CollisionRecordMapper.mapToCollisionRecord(line, provinceMap));
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
        }
        return collisionRecords;
    }
}

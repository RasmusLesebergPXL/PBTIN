package be.pxl.ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpotifyReader {

    public static List<SpotifyRecord> loadSpotifyRecords(Path path) {
        ArrayList<SpotifyRecord> records = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] recordInformation = line.split(";");
                if (recordInformation.length == 14) {
                    records.add(SpotifyRecordMapper.mapDataToSpotifyRecord(recordInformation));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return records;
    }
}

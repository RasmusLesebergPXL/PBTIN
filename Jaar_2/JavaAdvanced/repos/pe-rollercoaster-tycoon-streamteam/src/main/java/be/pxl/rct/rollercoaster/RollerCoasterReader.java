package be.pxl.rct.rollercoaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class RollerCoasterReader {

    public static ArrayList<RollerCoasterType> loadRollerCoasterType(Path path) {
        ArrayList<RollerCoasterType> rollerCoasterTypes = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null)
            {
                try {
                    String[] coasterInformation = line.split(";");
                    rollerCoasterTypes.add(RollerCoasterMapper.mapDataToRollerCoasterType(coasterInformation));
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return rollerCoasterTypes;
    }
}

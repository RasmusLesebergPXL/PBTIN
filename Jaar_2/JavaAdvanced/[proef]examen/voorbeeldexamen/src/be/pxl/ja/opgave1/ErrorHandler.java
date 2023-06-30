package be.pxl.ja.opgave1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class ErrorHandler {
    public static void writeErrorLog(Path activityFile, Path errorFile, String line1, String line2) {
        if (!errorFile.toFile().exists()) {
            try {
                errorFile.toFile().getParentFile().mkdirs();
                errorFile.toFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter bw = Files.newBufferedWriter(errorFile, StandardOpenOption.APPEND)) {
            bw.write(LocalDateTime.now() + " - " + activityFile + " - " + line1 + "-" + line2 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

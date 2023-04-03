package be.pxl.ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DeelnemerReader {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss");

	public static ArrayList<Deelnemer> readFile(Path path) {
		ArrayList<Deelnemer> properties = new ArrayList<>();
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			reader.readLine();
			String line;

			while ((line = reader.readLine()) != null)
			{
				try {
					properties.add(mapLineToDeelnemer(line));
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

	public static Deelnemer mapLineToDeelnemer(String line) {
		String[] split = line.split(";");
		Deelnemer deelnemer = new Deelnemer(split[0], Klassement.valueOf(split[9]));
		deelnemer.setLopen(parseDuration(split[2]));
		deelnemer.setMonkeyBars(Integer.parseInt(split[3]));
		deelnemer.setGolf(Integer.parseInt(split[4]));
		deelnemer.setRoeien(parseDuration(split[5]));
		deelnemer.setSchieten(Integer.parseInt(split[6]));
		deelnemer.setBenchpress(Integer.parseInt(split[7]));
		deelnemer.setFietsen(parseDuration(split[8]));
		return deelnemer;
	}

	private static Duration parseDuration(String duration) {
		duration = "PT" + duration.replace(":", "M") + "0S";
		return Duration.parse(duration);
	}

}

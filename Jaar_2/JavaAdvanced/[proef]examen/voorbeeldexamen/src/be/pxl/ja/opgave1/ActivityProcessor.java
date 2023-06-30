package be.pxl.ja.opgave1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityProcessor {

	private CustomerRepository customerRepository;
	
	public ActivityProcessor(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Activity> processActivities(Path activityFile, Path errorFile) {
		//WRITE ERROR LOG
		if (!activityFile.toString().toLowerCase().contains("strava") &&
				!activityFile.toString().toLowerCase().contains("endomodo")) {
			ErrorHandler.writeErrorLog(activityFile, errorFile, "INVALID FILENAME", "");
		}
		//ACTIVITY PROCESSING
		ArrayList<Activity> activities = new ArrayList<>();
		try {
			BufferedReader reader = Files.newBufferedReader(activityFile);
			reader.readLine();
			String line;
			while ((line = reader.readLine()) != null)
			{
				try {
					String[] activityInformation = line.split(";");
					activities.add(ActivityMapper.mapDataToActivity(activityFile, errorFile, activityInformation, customerRepository));
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
		return activities;
	}
}

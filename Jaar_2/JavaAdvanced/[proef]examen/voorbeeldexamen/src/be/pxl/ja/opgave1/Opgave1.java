package be.pxl.ja.opgave1;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Opgave1 {
	public static void main(String[] args) {
		CustomerRepository customerRepository = new CustomerRepository();
		List<Customer> customers = customerRepository.findAll();

		System.out.println("*** Klanten uit Louisville:");
		customers
				.stream()
				.filter(v -> v.getCity().equals("Louisville"))
				.forEach(System.out::println);

		System.out.println("\n");
		System.out.println("*** Jarige klanten: ");
		customers
				.stream()
				.filter(v -> v.getDateOfBirth().getDayOfYear() == (LocalDate.now().getDayOfYear()))
				.forEach(System.out::println);

		System.out.println("\n");
		System.out.println("*** 10 jongste klanten:");
		customers
				.stream()
				.sorted(Comparator.comparing(Customer::getDateOfBirth).reversed())
				.limit(10)
				.forEach(System.out::println);

		ActivityProcessor activityFileProcessor = new ActivityProcessor(customerRepository);
		List<Activity> allActivities = new ArrayList<>();

		List<Path> allPaths = new ArrayList<>();
		Path strava1 = Path.of("resources", "opgave1", "activities_from_strava.txt");
		Path strava2 = Path.of("resources", "opgave1", "strava_activities.txt");
		Path endomodo = Path.of("resources", "opgave1", "endomodo_activities.txt");
		Path runkeeper = Path.of("resources", "opgave1", "runkeeper_activities.txt");
		Path errorLogs = Path.of("resources", "opgave1", "log", "errors.log");
		allPaths.add(strava1);
		allPaths.add(strava2);
		allPaths.add(endomodo);
		allPaths.add(runkeeper);

		for (Path path : allPaths) {
			allActivities.addAll(activityFileProcessor.processActivities(path, errorLogs));
		}

		System.out.println("\n");
		System.out.println("*** Top 10 klanten");
		customers
				.stream()
				.sorted(Comparator.comparing(Customer::getPoints).reversed())
				.limit(10)
				.forEach(System.out::println);

		System.out.println("\n");
		System.out.println("** Alle activiteiten meest actieve klant (gesorteerd op datum):");
		//Niet helemaal juist
		Map<ActivityType, String> mostActiveMembers = new HashMap<>();
		for(Activity activity : allActivities) {
			if (activity != null) {
				mostActiveMembers.put(activity.getActivityType(), activity.getCustomerNumber());
			}
		}

		for (Map.Entry<ActivityType, String> entry : mostActiveMembers.entrySet()) {
			System.out.println(entry.getKey() + " " + customerRepository.getByCustomerNumber(entry.getValue()).toString());
		}
	}
}

package be.pxl.ja;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerCup {

	private static ArrayList<Deelnemer> deelnemers;
	public static void main(String[] args) {
		Path deelnemerPath = Path.of("src", "main", "resources", "containercup.csv");
		deelnemers = DeelnemerReader.readFile(deelnemerPath);

		System.out.println("Aantal deelnemers in klassement BV");
		System.out.println((deelnemers
				.stream()
				.filter(v -> v.getKlassement().equals(Klassement.BV))
				.count()));

		System.out.println("Klassement sportman (top 5)");
		deelnemers
				.stream()
				.filter(v -> v.getKlassement().equals(Klassement.M))
				.sorted(Comparator.comparing(Deelnemer::getEindtijd))
				.limit(5)
				.forEach(System.out::println);

		System.out.println("Maximum monkey bars");
		System.out.println(deelnemers
				.stream()
				.mapToInt(Deelnemer::getMonkeyBars).max()
				.orElse(0));
	}
}

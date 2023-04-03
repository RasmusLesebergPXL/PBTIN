package be.pxl.ja;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SpotifyAppRunner {

	public static void main(String[] args) {
		SpotifyApp spotifyApp = new SpotifyApp();
		System.out.println("** Number of spotify records: " + spotifyApp.getNumberOfSpotifyRecords());
		System.out.println("** Number of unique artists: " + spotifyApp.getNumberOfUniqueArtists());
		System.out.println("** Songs by Billie Eilish saved to file.");
		List<SpotifyRecord> records = spotifyApp.getSpotifyRecordsByArtist("Billie Eilish");

		Path path = Path.of("src", "main", "resources", "billie.txt");
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				spotifyApp.saveToFile(records, path);
			} catch (IOException e) {
				System.out.println("An error occurred while creating file " + path);
			}
		}

		System.out.println("** Top 5 artists: ");
		spotifyApp.getTop5ArtistsWithHighestPopularity().forEach(System.out::println);
		Genre mostPopularGenre = spotifyApp.getMostPopularGenre();
		System.out.println("** Most popular genre: " + mostPopularGenre);
		System.out.println("** Danceable genres: " + spotifyApp.getDanceableGenres());
		System.out.println("** Max length: " + spotifyApp.getMaxLength());
		System.out.println("** Most danceable: ");
		SpotifyRecord mostDanceable = spotifyApp.getMostDanceableSpotifyRecord();
		System.out.println(mostDanceable);
	}
}

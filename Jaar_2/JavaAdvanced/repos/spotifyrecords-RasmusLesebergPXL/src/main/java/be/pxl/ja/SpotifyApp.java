package be.pxl.ja;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SpotifyApp {

	private List<SpotifyRecord> spotifyRecords;

	public SpotifyApp() {
		Path path = Path.of("src", "main", "resources", "top50spotify2019.csv");
		spotifyRecords = SpotifyReader.loadSpotifyRecords(path);
	}

	// 1. get the number of spotify records in the list (no stream!)
	public int getNumberOfSpotifyRecords() {
		return spotifyRecords.size();
	}

	// 2. get artist name of top 5 spotify records with highest popularity
	public List<String> getTop5ArtistsWithHighestPopularity() {
		return spotifyRecords.stream()
				.sorted(Comparator.comparing(SpotifyRecord::getPopularity).reversed())
				.limit(5)
				.map(SpotifyRecord::getArtistName)
				.collect(Collectors.toList());
	}

	// 3. get number of unique artists
	public long getNumberOfUniqueArtists() {
		return spotifyRecords
				.stream()
				.map(SpotifyRecord::getArtistName)
				.distinct()
				.count();
	}

	// 4. all spotify records by artist
	public List<SpotifyRecord> getSpotifyRecordsByArtist(String artistName) {
		return spotifyRecords
				.stream()
				.filter(r -> Objects.equals(r.getArtistName(), artistName))
				.collect(Collectors.toList());
	}

	// 5. get most danceable spotify record
	public SpotifyRecord getMostDanceableSpotifyRecord() {
		return spotifyRecords.stream()
				.max(Comparator.comparing(SpotifyRecord::getDanceability))
				.orElse(null);
	}

	// 6. return a string with the names of all genres with a spotify record with danceability > 80.
	// The names must be separated by a comma and doubles are not allowed.
	public String getDanceableGenres() {
		return spotifyRecords.stream()
				.filter(v -> v.getDanceability() > 80)
				.map(v -> v.getGenre().toString())
				.distinct()
				.sorted()
				.collect(Collectors.joining(","));
	}

	// 7. get max length of all spotify records
	public int getMaxLength() {
		return spotifyRecords
				.stream()
				.mapToInt(SpotifyRecord::getLength)
				.max()
				.orElse(0);
	}

//	 8. get most popular genre (the genre with the most spotify records)
	public Genre getMostPopularGenre() {
		return spotifyRecords
				.stream()
				.collect(Collectors.groupingBy(SpotifyRecord::getGenre, Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse(null);
	}


	public void saveToFile(List<SpotifyRecord> list, Path filename) {
		try (BufferedWriter writer = Files.newBufferedWriter(filename)) {
			for (SpotifyRecord spotifyRecord : list) {
				writer.write(spotifyRecord.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}
}

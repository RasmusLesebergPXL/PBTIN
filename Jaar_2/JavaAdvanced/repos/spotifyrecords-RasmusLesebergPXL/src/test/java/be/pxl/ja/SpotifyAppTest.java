package be.pxl.ja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpotifyAppTest {

	private SpotifyApp spotifyApp;

	@BeforeEach
	void setUp() {
		spotifyApp = new SpotifyApp();
	}

	@Test
	void getNumberOfSpotifyRecords() {
		assertEquals(50, spotifyApp.getNumberOfSpotifyRecords());
	}

	@Test
	void getTop5ArtistsWithHighestPopularity() {
		List<String> top5 = spotifyApp.getTop5ArtistsWithHighestPopularity();
		assertEquals("Billie Eilish", top5.get(0));
		assertEquals("Post Malone", top5.get(1));
		assertEquals("Bad Bunny", top5.get(2));
		assertEquals("Anuel AA", top5.get(3));
		assertEquals("Drake", top5.get(4));
	}

	@Test
	void getNumberOfUniqueArtists() {
		assertEquals(38, spotifyApp.getNumberOfUniqueArtists());
	}

	@Test
	void getSpotifyRecordsByArtist() {
		List<SpotifyRecord> records = spotifyApp.getSpotifyRecordsByArtist("Billie Eilish");
		assertEquals(2, records.size());
		List<String> names = records.stream().map(SpotifyRecord::getArtistName).distinct().collect(Collectors.toList());
		assertEquals(1, names.size());
		assertEquals("Billie Eilish", names.get(0));
	}

	@Test
	void getMostDanceableSpotifyRecord() {
		SpotifyRecord mostDanceable = spotifyApp.getMostDanceableSpotifyRecord();
		assertEquals(44, mostDanceable.getId());
	}

	@Test
	void getDanceableGenres() {
		String danceableGenres = spotifyApp.getDanceableGenres();
		assertTrue(danceableGenres.contains("AUSTRALIAN_POP"));
		assertTrue(danceableGenres.contains("BOY_BAND"));
		assertTrue(danceableGenres.contains("CANADIAN_HIP_HOP"));
		assertTrue(danceableGenres.contains("COUNTRY_RAP"));
		assertTrue(danceableGenres.contains("DANCE_POP"));
		assertTrue(danceableGenres.contains("REGGAETON_FLOW"));
		assertTrue(danceableGenres.contains("RNB_EN_ESPANOL"));
		assertTrue(danceableGenres.contains(","));
	}

	@Test
	void getMaxLength() {
		assertEquals(309, spotifyApp.getMaxLength());
	}

	@Test
	void getMostPopularGenre() {
		assertEquals(Genre.DANCE_POP, spotifyApp.getMostPopularGenre());
	}
}

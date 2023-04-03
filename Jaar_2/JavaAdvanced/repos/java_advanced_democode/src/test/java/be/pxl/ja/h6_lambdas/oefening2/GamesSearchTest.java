package be.pxl.ja.h6_lambdas.oefening2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamesSearchTest {

	@Test
	public void gamesWithSearchTermInName() {
		GameCollection collection = new GameCollection();
		collection.addGame(new VideoGame("abcd", 9.99, 3.0, new String[] { "Shooter", "Action" }));
		collection.addGame(new VideoGame("efgh", 0.0, 3.0, new String[] { "shooter" }));
		collection.addGame(new VideoGame("ijkl", 9.99, 3.0, new String[] { "simulation" }));
		collection.addGame(new VideoGame("mnop", 0.0, 3.0, new String[] { "ACTION", "ADVENTURE" }));
		collection.addGame(new VideoGame("cdef", 20.99, 3.0, new String[] { "action" }));
		GameBrowser browser = new GameBrowser(collection);

		assertEquals(2, browser.showGamesForSearch("cd").size());
	}

	@Test
	public void gamesWithSearchTermInNameNotCaseSensitive() {
		GameCollection collection = new GameCollection();
		collection.addGame(new VideoGame("abcd", 9.99, 3.0, new String[] { "Shooter", "Action" }));
		collection.addGame(new VideoGame("CDxy", 0.0, 3.0, new String[] { "shooter" }));
		collection.addGame(new VideoGame("ijkl", 9.99, 3.0, new String[] { "simulation" }));
		collection.addGame(new VideoGame("mnop", 0.0, 3.0, new String[] { "ACTION", "ADVENTURE" }));
		collection.addGame(new VideoGame("cDef", 20.99, 3.0, new String[] { "action" }));
		GameBrowser browser = new GameBrowser(collection);

		assertEquals(3, browser.showGamesForSearch("Cd").size());
	}
}

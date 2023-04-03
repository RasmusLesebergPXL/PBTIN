package be.pxl.ja.h6_lambdas.oefening2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamesGenreTest {

	@Test
	public void gamesWithGenreNotCaseSensitive() {
		GameCollection collection = new GameCollection();
		collection.addGame(new VideoGame("game1", 9.99, 3.0, new String[] { "Shooter", "Action" }));
		collection.addGame(new VideoGame("game2", 0.0, 3.0, new String[] { "shooter" }));
		collection.addGame(new VideoGame("game3", 9.99, 3.0, new String[] { "simulation" }));
		collection.addGame(new VideoGame("game4", 0.0, 3.0, new String[] { "ACTION", "ADVENTURE" }));
		collection.addGame(new VideoGame("game5", 20.99, 3.0, new String[] { "action" }));
		GameBrowser browser = new GameBrowser(collection);

		assertEquals(3, browser.showGamesInGenre("action").size());
	}
}

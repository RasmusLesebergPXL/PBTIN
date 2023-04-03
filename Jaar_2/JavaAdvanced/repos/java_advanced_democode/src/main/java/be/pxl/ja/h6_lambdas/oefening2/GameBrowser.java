package be.pxl.ja.h6_lambdas.oefening2;

import java.util.List;

public class GameBrowser {

	private GameCollection gameCollection;


	public GameBrowser(GameCollection gameCollection) {
		this.gameCollection = gameCollection;
	}

	public List<VideoGame> showFreeGames() {
		throw new UnsupportedOperationException("Implement this method");
	}

	public List<VideoGame> showGamesInGenre(String action) {
		throw new UnsupportedOperationException("Implement this method");
	}

	public List<VideoGame> showGamesForSearch(String cd) {
		throw new UnsupportedOperationException("Implement this method");
	}
}

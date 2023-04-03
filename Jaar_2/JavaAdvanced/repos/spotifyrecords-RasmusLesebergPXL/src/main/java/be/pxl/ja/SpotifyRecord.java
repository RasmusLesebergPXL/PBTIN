package be.pxl.ja;

public class SpotifyRecord implements Comparable<SpotifyRecord>{
	private int id;
	private String trackName;
	private String artistName;
	private Genre genre;
	private int bpm;
	private int energy;
	private int danceability;
	private int loudness;
	private int liveness;
	private int valence;
	private int length;
	private int acousticness;
	private int speechiness;
	private int popularity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getDanceability() {
		return danceability;
	}

	public void setDanceability(int danceability) {
		this.danceability = danceability;
	}

	public int getLoudness() {
		return loudness;
	}

	public void setLoudness(int loudness) {
		this.loudness = loudness;
	}

	public int getLiveness() {
		return liveness;
	}

	public void setLiveness(int liveness) {
		this.liveness = liveness;
	}

	public int getValence() {
		return valence;
	}

	public void setValence(int valence) {
		this.valence = valence;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getAcousticness() {
		return acousticness;
	}

	public void setAcousticness(int acousticness) {
		this.acousticness = acousticness;
	}

	public int getSpeechiness() {
		return speechiness;
	}

	public void setSpeechiness(int speechiness) {
		this.speechiness = speechiness;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	@Override
	public String toString() {
		return "SpotifyRecord{" +
				"ID=" + id +
				", trackName='" + trackName + '\'' +
				", artistName='" + artistName + '\'' +
				", popularity=" + popularity +
				'}';
	}

	@Override
	public int compareTo(SpotifyRecord o) {
		return Integer.compare(o.getPopularity(), this.getPopularity());
	}
}

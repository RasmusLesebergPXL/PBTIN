package be.pxl.ja.streamingservice.domain;

public abstract class Content {
	private String title;
	private Rating maturityRating;
	private String imageUrl;

	public Content(String title, Rating maturityRating) {
		this.title = title;
		this.maturityRating = maturityRating;
	}

	public Rating getMaturityRating() {
		return maturityRating;
	}

	public String getTitle() {
		return title;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String toString() {
		return title;
	}
}
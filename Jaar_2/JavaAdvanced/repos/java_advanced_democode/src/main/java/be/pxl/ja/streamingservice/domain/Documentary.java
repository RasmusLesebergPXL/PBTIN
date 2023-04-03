package be.pxl.ja.streamingservice.domain;

public class Documentary extends Movie {

	private String topic;

	public Documentary(String title, Rating maturityRating) {
		super(title, maturityRating);
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
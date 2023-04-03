package be.pxl.ja.streamingservice.domain;

public enum Rating {
	LITTLE_KIDS,
	OLDER_KIDS(7),
	TEENS(12),
	MATURE(16);

	private int minimumAge;

	Rating(int minimumAge) {
		this.minimumAge = minimumAge;
	}

	Rating() {
		this(0);
	}

	public int getMinimumAge() {
		return minimumAge;
	}
}
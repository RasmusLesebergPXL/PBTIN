package be.pxl.ja;

public enum Klassement {
	M("SPORTMAN"),
	V("SPORTVROUW"),
	BV("BV");

	private final String omschrijving;

	Klassement(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getOmschrijving() {
		return omschrijving;
	}
}

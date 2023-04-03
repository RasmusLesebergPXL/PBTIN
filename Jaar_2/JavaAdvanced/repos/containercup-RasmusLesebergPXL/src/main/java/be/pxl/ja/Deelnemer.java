package be.pxl.ja;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deelnemer {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss.SS");

	private String naam;
	private Klassement klassement;

	private Duration totaalTijd;

	private Duration lopen;// tijd 1500m lopen
	private Duration roeien; // tijd 1000m roeien
	private Duration fietsen; // tijd 3000m fietsen
	private int monkeyBars; // aantal monkey bars
	private int golf; // afstand in m
	private int schieten; // aantal targets geraakt
	private int benchpress; // aantal kilo's op benchpress

	public Deelnemer(String naam, Klassement klassement) {
		this.naam = naam;
		this.klassement = klassement;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Klassement getKlassement() {
		return klassement;
	}

	public void setKlassement(Klassement klassement) {
		this.klassement = klassement;
	}

	public Duration getLopen() {
		return lopen;
	}

	public void setLopen(Duration lopen) {
		this.lopen = lopen;
	}

	public Duration getRoeien() {
		return roeien;
	}

	public void setRoeien(Duration roeien) {
		this.roeien = roeien;
	}

	public Duration getFietsen() {
		return fietsen;
	}

	public void setFietsen(Duration fietsen) {
		this.fietsen = fietsen;
	}

	public int getMonkeyBars() {
		return monkeyBars;
	}

	public void setMonkeyBars(int monkeyBars) {
		this.monkeyBars = monkeyBars;
	}

	public int getGolf() {
		return golf;
	}

	public void setGolf(int golf) {
		this.golf = golf;
	}

	public int getSchieten() {
		return schieten;
	}

	public void setSchieten(int schieten) {
		this.schieten = schieten;
	}

	public int getBenchpress() {
		return benchpress;
	}

	public void setBenchpress(int benchpress) {
		this.benchpress = benchpress;
	}

	public Duration getEindtijd() {
		DurationCalculator durationCalculator = new DurationCalculator();
		durationCalculator.plus(lopen);
		durationCalculator.plus(fietsen);
		durationCalculator.plus(roeien);
		durationCalculator.minus(monkeyBars, Duration::ofSeconds);
		durationCalculator.minus(golf, x -> Duration.ofSeconds(x / 3));
		durationCalculator.minus(schieten, x -> Duration.ofSeconds(x * 10));
		durationCalculator.minus(benchpress, x -> Duration.ofSeconds(x / 2));
		return durationCalculator.getResult();
	}

	public String getEindtijdAsString() {
		return LocalTime.MIDNIGHT.plus(getEindtijd()).format(FORMATTER);
	}
	@Override
	public String toString() {
		return getEindtijdAsString() + " " + getNaam();
	}
}

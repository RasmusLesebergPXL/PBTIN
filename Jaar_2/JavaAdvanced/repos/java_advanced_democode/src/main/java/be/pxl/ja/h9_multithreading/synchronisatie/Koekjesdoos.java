package be.pxl.ja.h9_multithreading.synchronisatie;

import java.util.concurrent.atomic.AtomicInteger;

public class Koekjesdoos {

	private AtomicInteger aantalKoekjes;

	public Koekjesdoos(int aantalKoekjes) {
		this.aantalKoekjes = new AtomicInteger(aantalKoekjes);
	}

	public boolean neemKoekje() {
		return aantalKoekjes.decrementAndGet() > 0;
	}
}

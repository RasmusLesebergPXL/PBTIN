package be.pxl.h5.oef2;


import be.pxl.h5.oef1.Persoon;
import org.junit.Test;


import static org.junit.Assert.*;

public class SporterTest {
    @Test
    public void testConstructorMet1Parameter() {
        Sporter sporter = new Sporter("Janssen", "Kurt");
        assertTrue("Kurt".equalsIgnoreCase(sporter.getVoornaam()));
        assertTrue("Janssen".equalsIgnoreCase(sporter.getNaam()));
        assertEquals("onbepaald", sporter.getOmschrijving());
    }

    @Test
    public void testConstructorMet3Parameters() {
        Sporter sporter = new Sporter("Janssen", "Kurt", "Basketbal");
        assertTrue("Kurt".equalsIgnoreCase(sporter.getVoornaam()));
        assertTrue("Janssen".equalsIgnoreCase(sporter.getNaam()));
        assertTrue("Basketbal".equalsIgnoreCase(sporter.getOmschrijving()));
    }

    @Test
    public void testCountSporterObjecten() {
        int before = Sporter.getAantal();
        new Sporter("", "");
        new Sporter("", "");
        new Persoon("", "");
        int later = Sporter.getAantal();
        assertEquals("Fout bij opvragen aantal Werknemers", 2, later - before);
    }
}

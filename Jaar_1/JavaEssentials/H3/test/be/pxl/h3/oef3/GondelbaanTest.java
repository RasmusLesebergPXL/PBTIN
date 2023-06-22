package be.pxl.h3.oef3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GondelbaanTest {

    public static final String NAAM = "Gondelbaantje Frank";
    public static final String LAND = "Italië";
    public static final String ANDER_LAND = "Oostenrijk";
    public static final double LENGTE = 1.2;
    public static final int SNELHEID = 5;
    public static final int DALSTATION = 1000;
    public static final int BERGSTATION = 2000;
    public static final int MIN_SNELHEID = 3;
    public static final int MAX_SNELHEID = 8;
    public static final int AANTAL_GONDELS = 20;
    public static final int PASSAGIERS_PER_GONDEL = 8;

    private Gondelbaan gondelbaan;

    @Before
    public void init() {
        gondelbaan = new Gondelbaan(NAAM, LAND);
    }

    @Test
    public void testConstructorMet4Parameters() {
        Gondelbaan g = new Gondelbaan(NAAM, LAND, LENGTE, SNELHEID);

        assertEquals(NAAM, g.getNaam());
        assertEquals(LAND, g.getLand());
        assertEquals(LENGTE, g.getLengte(), 0.01);
        assertEquals(SNELHEID, g.getSnelheid());
    }

    @Test
    public void testConstructorMet2Parameters() {
        assertEquals(NAAM, gondelbaan.getNaam());
        assertEquals(LAND, gondelbaan.getLand());
        assertEquals(2, gondelbaan.getLengte(), 0.01);
        assertEquals(6, gondelbaan.getSnelheid());
    }

    @Test
    public void testSetters() {
        gondelbaan.setNaam(NAAM+"x");
        assertEquals(NAAM+"x", gondelbaan.getNaam());

        gondelbaan.setLand(ANDER_LAND);
        assertEquals(ANDER_LAND, gondelbaan.getLand());

        gondelbaan.setLengte(LENGTE);
        assertEquals(LENGTE, gondelbaan.getLengte(), 0.01);

        gondelbaan.setSnelheid(SNELHEID);
        assertEquals(SNELHEID, gondelbaan.getSnelheid());

        gondelbaan.setAantalGondels(AANTAL_GONDELS);
        assertEquals(AANTAL_GONDELS, gondelbaan.getAantalGondels());

        gondelbaan.setPassagiersPerGondel(PASSAGIERS_PER_GONDEL);
        assertEquals(PASSAGIERS_PER_GONDEL, gondelbaan.getPassagiersPerGondel());
    }

    @Test
    public void testSetHoogteKleinsteEerst() {
        gondelbaan.setHoogte(DALSTATION, BERGSTATION);
        assertEquals(DALSTATION, gondelbaan.getHoogteDalstation());
        assertEquals(BERGSTATION, gondelbaan.getHoogteBergstation());
    }

    @Test
    public void testSetHoogteGrootsteEerst() {
        gondelbaan.setHoogte(BERGSTATION, DALSTATION);
        assertEquals(DALSTATION, gondelbaan.getHoogteDalstation());
        assertEquals(BERGSTATION, gondelbaan.getHoogteBergstation());
    }

    @Test
    public void testGetHoogteVerschil() {
        gondelbaan.setHoogte(BERGSTATION, DALSTATION);
        assertEquals(BERGSTATION-DALSTATION, gondelbaan.getHoogteVerschil());
    }

    @Test
    public void testSetLandAlleGeldigeWaarden() {
        ArrayList<String> geldig = new ArrayList<>(Arrays.asList("Italië", "Oostenrijk", "Zwitserland", "Frankrijk"));
        for(String geldigLand:geldig) {
            gondelbaan.setLand(geldigLand);
            assertEquals(geldigLand, gondelbaan.getLand());
        }
    }

    @Test
    public void testSetLandVerkeerdeWaarde() {
        gondelbaan.setLand("Aardappel");
        assertEquals("Onbekend", gondelbaan.getLand());
    }

    @Test
    public void testSetSnelheidTeLageWaarde() {
        gondelbaan.setSnelheid(MIN_SNELHEID-1);
        assertEquals(MIN_SNELHEID, gondelbaan.getSnelheid());
    }

    @Test
    public void testSetSnelheidTeHogeWaarde() {
        gondelbaan.setSnelheid(MAX_SNELHEID+1);
        assertEquals(MAX_SNELHEID, gondelbaan.getSnelheid());
    }

    @Test
    public void testSetSnelheidGrenzenInclusief() {
        gondelbaan.setSnelheid(MIN_SNELHEID);
        assertEquals(MIN_SNELHEID, gondelbaan.getSnelheid());

        gondelbaan.setSnelheid(MAX_SNELHEID);
        assertEquals(MAX_SNELHEID, gondelbaan.getSnelheid());
    }

    @Test
    public void testSetNaamEersteLettersHoofdletter() {
        gondelbaan.setNaam("gondelbaantje frank");
        assertEquals("Gondelbaantje Frank", gondelbaan.getNaam());
    }

    @Test
    public void testSetNaamAndereLettersKleineLetter() {
        gondelbaan.setNaam("gondeLbAantje frANK");
        assertEquals("Gondelbaantje Frank", gondelbaan.getNaam());
    }

    @Test
    public void testGetDuur() {
        gondelbaan.setSnelheid(SNELHEID);
        gondelbaan.setLengte(LENGTE);

        assertEquals((LENGTE*1000/SNELHEID)/60, gondelbaan.getDuur(), 0.01);
    }

    @Test
    public void testGetVervoersCapaciteit() {
        gondelbaan.setSnelheid(SNELHEID);
        gondelbaan.setLengte(LENGTE);
        gondelbaan.setAantalGondels(AANTAL_GONDELS);
        gondelbaan.setPassagiersPerGondel(PASSAGIERS_PER_GONDEL);

        assertEquals(
                (int) ((60*AANTAL_GONDELS*PASSAGIERS_PER_GONDEL)/ gondelbaan.getDuur()),
                gondelbaan.getVervoersCapaciteit()
        );
    }

    @Test
    public void testToString() {
        gondelbaan.setHoogte(DALSTATION, BERGSTATION);
        assertEquals(NAAM + " [" + (BERGSTATION-DALSTATION) + "m]", gondelbaan.toString());
    }
}

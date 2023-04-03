package be.pxl.h3.oef1;

import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PersoonTest {

    public static final String VOORNAAM = "Franky";
    public static final String NAAM = "Van der Elst";
    public static final double LENGTE = 1.84;
    public static final double GEWICHT = 71.6;
    public static final LocalDate GEBOORTEDATUM = LocalDate.of(1961, 4, 30);

    Persoon persoon;

    @Before
    public void init() {
        persoon = new Persoon(NAAM, VOORNAAM);
    }

    @Test
    public void testDefaultConstructor() {
        Persoon p = new Persoon();

        assertEquals("onbekend", p.getNaam());
        assertEquals("onbekend", p.getVoornaam());
    }

    @Test
    public void testWaardenNaConstructor() {
        assertEquals(VOORNAAM, persoon.getVoornaam());
        assertEquals(NAAM, persoon.getNaam());
    }

    @Test
    public void testCopyConstructor() {
        persoon.setGewicht(GEWICHT);
        persoon.setLengte(LENGTE);
        persoon.setGeboortedatum(GEBOORTEDATUM);

        Persoon p2 = new Persoon(persoon);

        assertEquals(persoon.getVoornaam(), p2.getVoornaam());
        assertEquals(persoon.getNaam(), p2.getNaam());
        assertEquals(persoon.getLengte(), p2.getLengte(), 0.01);
        assertEquals(persoon.getGewicht(), p2.getGewicht(), 0.01);
        assertEquals(persoon.getGeboortedatum(), p2.getGeboortedatum());
    }

    @Test
    public void testSetters() {
        persoon.setVoornaam(VOORNAAM+VOORNAAM);
        assertEquals(VOORNAAM+VOORNAAM, persoon.getVoornaam());

        persoon.setNaam(NAAM +NAAM);
        assertEquals(NAAM+NAAM, persoon.getNaam());
    }

    @Test
    public void testSetLengteBijCorrecteWaarde() {
        persoon.setLengte(LENGTE);
        assertEquals(LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    public void testSetLengteBijTeGroteWaarde() {
        persoon.setLengte(Persoon.MAX_LENGTE+0.01);
        assertEquals(Persoon.MAX_LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    public void testGroeiZonderParameter() {
        persoon.setLengte(LENGTE);
        persoon.groei();
        assertEquals(LENGTE+0.01, persoon.getLengte(), 0.01);
    }

    @Test
    public void testGroeiZonderParameterBijTeHoogResultaat() {
        persoon.setLengte(Persoon.MAX_LENGTE);
        persoon.groei();
        assertEquals(Persoon.MAX_LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    public void testGroeiMetParameter() {
        persoon.setLengte(LENGTE);
        persoon.groei(0.03);
        assertEquals(LENGTE+0.03, persoon.getLengte(), 0.01);
    }

    @Test
    public void testGroeiMetParameterBijTeHoogResultaat() {
        persoon.setLengte(Persoon.MAX_LENGTE);
        persoon.groei(0.03);
        assertEquals(Persoon.MAX_LENGTE, persoon.getLengte(), 0.01);
    }

    @Test
    public void testSetGewicht() {
        persoon.setGewicht(GEWICHT);
        assertEquals(GEWICHT, persoon.getGewicht(), 0.01);
    }

    @Test
    public void testSetGeboortedatum() {
        persoon.setGeboortedatum(GEBOORTEDATUM);
        assertEquals(GEBOORTEDATUM, persoon.getGeboortedatum());
    }

    @Test
    public void testGetLeeftijd() {
        persoon.setGeboortedatum(GEBOORTEDATUM);
        assertEquals(LocalDate.now().getYear()-GEBOORTEDATUM.getYear(), persoon.getLeeftijd());
    }

    @Test
    public void testBerekenBmiMetJuisteAfronding() {
        persoon.setLengte(LENGTE);
        persoon.setGewicht(GEWICHT);

        assertEquals(Math.round((GEWICHT/(LENGTE*LENGTE))*10)/10.0, persoon.berekenBmi(), 0.01);
    }

    @Test
    public void testBmiOmschrijvingen() {
        persoon.setLengte(1);
        persoon.setGewicht(17);
        assertEquals("ondergewicht", persoon.geefOmschrijving());
        persoon.setGewicht(18);
        assertEquals("normaal", persoon.geefOmschrijving());
        persoon.setGewicht(25);
        assertEquals("overgewicht", persoon.geefOmschrijving());
        persoon.setGewicht(30);
        assertEquals("obesitas", persoon.geefOmschrijving());
        persoon.setGewicht(40);
        assertEquals("morbide obesitas", persoon.geefOmschrijving());
    }

    @Test
    public void testVoegVoornamenToe() {
        persoon.voegVoornamenToe(new String[]{"Bert", "Sam"});
        assertEquals(VOORNAAM + " Bert Sam", persoon.getVoornaam());
    }

    @Test
    public void testAfgekorteNaam() {
        assertEquals("F.Van der elst", persoon.geefNaamAfgekort());
    }

    @Test
    public void testEncrypteerNaam() {
        assertEquals("G/Wbo!efs!fmtu", persoon.encrypteerNaam(1));
        assertEquals("O7_jw)mn{)nu|}", persoon.encrypteerNaam(9));
        assertEquals("Q/Mbohlpvt", new Persoon("Langkous", "Pipi").encrypteerNaam(1));
    }
}

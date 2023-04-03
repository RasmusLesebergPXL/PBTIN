package be.pxl.h4.oef2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokemonTest {
    public static final String NAME = "Pikachu";
    public static final String TYPE = "Electrical";

    private Pokemon pokemon;

    @Before
    public void init() {
        pokemon = new Pokemon(NAME, TYPE);
    }

    @Test
    public void testGetNaam() {
        assertEquals(NAME, pokemon.getNaam());
    }

    @Test
    public void testGetType() {
        assertEquals(TYPE, pokemon.getType());
    }

    @Test
    public void testToString() {
        assertEquals(String.format("%s (%s)", NAME, TYPE), pokemon.toString());
    }
}

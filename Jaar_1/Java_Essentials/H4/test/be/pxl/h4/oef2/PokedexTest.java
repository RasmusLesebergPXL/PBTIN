package be.pxl.h4.oef2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokedexTest {
    public static final int SIZE = 8;

    private Pokemon pokemon = new Pokemon("Pikachu", "Electrical");
    private Pokemon pokemon2 = new Pokemon("Charmander", "Fire");
    private Pokedex pokedex;

    @Before
    public void init() {
        pokedex = new Pokedex(SIZE);
    }

    @Test
    public void testPokedexCreated() {
        assertNotNull(pokedex.getPokemon());
    }

    @Test
    public void testPokedexSize() {
        assertEquals(SIZE, pokedex.getPokemon().length);
    }

    @Test
    public void testVoegToeAddsOnFirstIndex() {
        pokedex.voegToe(pokemon);
        assertEquals(pokemon, pokedex.getPokemon()[0]);
    }

    @Test
    public void testBevatReturnsTrueWhenPokemonAvailable() {
        pokedex.voegToe(pokemon);
        assertTrue(pokedex.bevat(pokemon));
    }

    @Test
    public void testBevatReturnsFalseWhenNoPokemonAvailable() {
        assertFalse(pokedex.bevat(pokemon));
    }

    @Test
    public void testBevatReturnsFalseWhenPokemonNotAvailable() {
        pokedex.voegToe(pokemon);
        assertFalse(pokedex.bevat(pokemon2));
    }
}

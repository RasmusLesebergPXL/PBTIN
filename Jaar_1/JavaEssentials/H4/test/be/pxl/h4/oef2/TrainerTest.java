package be.pxl.h4.oef2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainerTest {
    public static final String NAME = "SAM";
    public static final int DEFAULT_POKEDEX_SIZE = 10;

    private Trainer trainer;
    private Pokemon pokemon = new Pokemon("Pikachu", "Electrical");

    @Before
    public void init() {
        trainer = new Trainer(NAME);
    }

    @Test
    public void testGetNaam() {
        assertEquals(NAME, trainer.getNaam());
    }

    @Test
    public void testPokedexCreatedWithCorrectDefaultSize() {
        assertNotNull(trainer.getPokedex());
        assertEquals(DEFAULT_POKEDEX_SIZE, trainer.getPokedex().getPokemon().length);
    }

    @Test
    public void testVangPokemonAddsPokemonIfNotAvailableYet() {
        trainer.vangPokemon(pokemon);
        assertNotNull(trainer.getPokedex().getPokemon()[0]);
    }

    @Test
    public void testVangPokemonDoesNotAddPokemonIfAlreadyAvailable() {
        trainer.vangPokemon(pokemon);
        trainer.vangPokemon(pokemon);
        assertNull(trainer.getPokedex().getPokemon()[1]);
    }

    @Test
    public void testToString() {
        assertEquals(NAME, trainer.toString());
    }
}

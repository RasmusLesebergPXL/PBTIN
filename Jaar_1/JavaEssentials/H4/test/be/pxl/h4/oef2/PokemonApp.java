package be.pxl.h4.oef2;

import java.util.Random;

public class PokemonApp {
    // Enkele Pokemon om in ons programma mee te werken.
    // Dit mag zeker aangevuld worden.
    public static Pokemon[] list = {
            new Pokemon("Pikachu", "Electrical"),
            new Pokemon("Bulbasaur", "Grass"),
            new Pokemon("Charmander", "Fire"),
            new Pokemon("Squirtle", "Water"),
            new Pokemon("Caterpie", "Bug"),
            new Pokemon("Rattata", "Normal"),
            new Pokemon("Ekans", "Poison"),
            new Pokemon("Sandshrew", "Ground"),
            new Pokemon("Jigglypuff", "Fairy"),
            new Pokemon("Oddish", "Grass"),
            new Pokemon("Diglett", "Ground")
    };

    public static void main(String[] args) {
        // Maak enkele trainers aan
        Trainer[] trainers = {
                new Trainer("Sam"),
                new Trainer("Ash"),
                new Trainer("Brock"),
                new Trainer("Misty")
        };

        Random random = new Random();
        // 5 rondes waarin elke trainer een willekeurige Pokemon zal vangen
        for(int i = 0; i < 5; i++) {
            // Elke trainer krijgt een kans in 1 beurt
            for(Trainer trainer : trainers) {
                // Selecteer een willekeurige Pokemon uit de lijst
                Pokemon pokemon = list[random.nextInt(list.length)];
                // Vang de Pokemon
                trainer.vangPokemon(pokemon);
            }
        }

        // Resultaten tonen
        for(Trainer trainer : trainers) {
            // Toon voor elke trainer de naam en de inhoud van de Pokedex
            System.out.println(trainer + " heeft volgende Pokemon gevangen:");
            System.out.println(trainer.getPokedex());
        }
    }
}

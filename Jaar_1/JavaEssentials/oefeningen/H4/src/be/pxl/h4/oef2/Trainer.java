package be.pxl.h4.oef2;

public class Trainer {
    private Pokedex pokedex;
    private String naam;


    public Trainer(String naam) {
        this.naam = naam;
        pokedex = new Pokedex(10);
    }

    @Override
    public String toString() {
        return naam;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public String getNaam() {
        return naam;
    }

    public void vangPokemon(Pokemon pokemon) {
        if (!pokedex.bevat(pokemon)) {
            pokedex.voegToe(pokemon);
        }
    }
}

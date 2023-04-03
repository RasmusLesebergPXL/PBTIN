package be.pxl.h4.oef2;

public class Pokedex {
    private Pokemon[] pokemon;

    public Pokedex(int grootte) {
        pokemon = new Pokemon[grootte];
    }

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public void voegToe(Pokemon nieuwePokemon) {
        int index = -1;
        for (int i = 0; i < pokemon.length && index == -1; i++) {
            if (pokemon[i] == null) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("geen plaats meer");
        } else {
            pokemon[index] = nieuwePokemon;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Pokemon p : pokemon) {
            if (p != null) {
                builder.append("- ").append(p.toString()).append("\n");
            }
        }
        return builder.toString();
    }

    public boolean bevat(Pokemon anderePokemon) {
        for (Pokemon p: pokemon) {
            if (p != null && anderePokemon.getNaam().equals(p.getNaam())) {
                return true;
            }
        }
        return false;
    }
}

package be.pxl.h8.oef1;

public class Afbeelding extends Bestand{
    private int[] dimensies;


    public Afbeelding(String naam, int[] dimensies) {
        super(naam);
        this.dimensies = dimensies;
    }

    @Override
    public void voerUit() {

    }
}

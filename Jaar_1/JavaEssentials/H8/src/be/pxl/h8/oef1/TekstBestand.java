package be.pxl.h8.oef1;

public class TekstBestand extends Bestand{


    public TekstBestand(String naam) {
        super(naam);
        setBestandsGrootte(naam.length());
    }

    @Override
    public void voerUit() {
        System.out.println(getNaam().toUpperCase());
        System.out.println(getInhoud());
    }
}

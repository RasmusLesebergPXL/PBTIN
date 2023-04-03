package be.pxl.h8.oef2;

public class GewapendeBoei extends ZeeObject{
    private int bereik;
    private int schade;

    public GewapendeBoei(int x, int y, Alliantie alliantie, int levenspunten, int bereik, int schade) {
        super(x, y, alliantie, levenspunten);
        this.bereik = bereik;
        this.schade = schade;
    }

    public void doeSchade(ZeeObject doelwit) {
        if (getLevenspunten() > 0
                && getAlliantie() != doelwit.getAlliantie()
                && getLocatie().berekafstand(doelwit.getLocatie()) <= bereik) {
            doelwit.ontvangSchade(this.schade);
        }
    }

    @Override
    public String toString() {
        return String.format("gewapende boei: %s", super.toString());
    }

}

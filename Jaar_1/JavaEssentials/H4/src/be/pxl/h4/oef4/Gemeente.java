package be.pxl.h4.oef4;

public class Gemeente {

    private int postcode;
    private String gemeenteNaam;

    public Gemeente(int postcode, String gemeenteNaam) {
        this.setPostcode(postcode);
        this.gemeenteNaam = gemeenteNaam;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        String addedZeroes = postcode+"0000";
        this.postcode = Integer.parseInt(addedZeroes.substring(0,4));
    }

    public String getGemeenteNaam() {
        return gemeenteNaam;
    }

    public void setGemeenteNaam(String gemeenteNaam) {
        this.gemeenteNaam = gemeenteNaam;
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.postcode, this.gemeenteNaam);
    }
}

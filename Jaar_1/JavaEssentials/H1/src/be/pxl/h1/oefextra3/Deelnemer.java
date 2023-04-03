package be.pxl.h1.oefextra3;

public class Deelnemer {
    private String naam;
    private int[] sfeerArray = new int[2];
    private int[] etenArray = new int[2];

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setSfeerArray(int sfeer) {
    }

    public void setEtenArray(int eten) {
    }

    public int[] getSfeerArray() {
        return sfeerArray;
    }

    public int[] getEtenArray() {
        return etenArray;
    }
}

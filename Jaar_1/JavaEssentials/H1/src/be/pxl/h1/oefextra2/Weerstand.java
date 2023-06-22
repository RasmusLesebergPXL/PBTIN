package be.pxl.h1.oefextra2;

import java.util.Arrays;


public class Weerstand {
    private char band1;
    private char band2;
    private char band3;

    public char getBand1() {
        return band1;
    }

    public void setBand1(char band1) {
        this.band1 = band1;
    }

    public char getBand2() {
        return band2;
    }

    public void setBand2(char band2) {
        this.band2 = band2;
    }

    public char getBand3() {
        return band3;
    }

    public void setBand3(char band3) {
        this.band3 = band3;
    }

    String[] kleuren = {"zwart", "bruin", "rood", "oranje", "geel", "groen", "blauw", "violet", "grijs", "wit"};
    Integer[] waardes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] letter = {"z", "b", "r", "o", "g", "G", "B", "V", "L", "W"};

    public double getWeerstandswaarde() {
        String band_1 = Character.toString(getBand1());
        String band_2 = Character.toString(getBand2());
        String band_3 = Character.toString(getBand3());

        int getIndex_band1 = Arrays.asList(letter).indexOf(band_1);
        int getIndex_band2 = Arrays.asList(letter).indexOf(band_2);
        int getIndex_band3 = Arrays.asList(letter).indexOf(band_3);

        int getal_1 = waardes[getIndex_band1];
        int getal_2 = waardes[getIndex_band2];
        int getal_3 = waardes[getIndex_band3];

        return (getal_1 + getal_2) * Math.pow(10, getal_3);
    }

    public String getKleur(char band) {
        String band_str = Character.toString(band);
        int getIndex_band = Arrays.asList(letter).indexOf(band_str);
        return kleuren[getIndex_band];
    }


}

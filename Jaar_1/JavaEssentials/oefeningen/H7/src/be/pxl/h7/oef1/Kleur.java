package be.pxl.h7.oef1;

import java.util.HexFormat;

public class Kleur {
    private int rood;
    private int groen;
    private int blauw;
    private String hex;

    public Kleur(String hex) {
        this.hex = hex;

    }

    public Kleur(int rood, int groen, int blauw) {
        this.rood = rood;
        this.groen = groen;
        this.blauw = blauw;
//        Integer.toHexString()

    }
}

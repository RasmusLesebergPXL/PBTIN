package be.pxl.h8.oef1;

import java.util.ArrayList;

public class FileSystem {
    public static void main(String[] args) {
        TekstBestand tekst1 = new TekstBestand("bestandje.txt");
        Folder foldertje = new Folder("foldertje");
        System.out.println(tekst1);
        tekst1.voerUit();

    }
}

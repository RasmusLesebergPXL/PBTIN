package be.pxl.h4.oefextra1;

public class Afbeelding {
    private RGBPixel[][] pixels;

    public Afbeelding(RGBPixel[][] pixels) {
        this.pixels = pixels;
    }

    public RGBPixel[][] getPixels() {
        return pixels;
    }

    public int getHoogte() {
        int nosRows = pixels.length;
        return nosRows;
    }

    public int getBreedte() {
        int nosCols = pixels[0].length;
        return nosCols;
    }

    public void grijswaarde() {
        for (RGBPixel[] rij : pixels) {
            for (RGBPixel pixel : rij) {
                pixel.naarGrijswaarde();
            }
        }
    }
}

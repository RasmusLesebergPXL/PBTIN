package be.pxl.h4.oefextra1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AfbeeldingTest {
    private static final int HOOGTE = 8;
    private static final int BREEDTE = 6;

    private Afbeelding afbeelding;
    private RGBPixel[][] pixels = new RGBPixel[HOOGTE][BREEDTE];

    @Before
    public void init() {
        Random random = new Random();
        for(int i=0;i<HOOGTE;i++) {
            for(int j=0;j<BREEDTE;j++) {
                pixels[i][j] = new RGBPixel(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
        }
        afbeelding = new Afbeelding(pixels);
    }

    @Test
    public void testGetHoogte() {
        assertEquals(HOOGTE, afbeelding.getHoogte());
    }

    @Test
    public void testGetBreedte() {
        assertEquals(BREEDTE, afbeelding.getBreedte());
    }

    @Test
    public void testGetPixels() {
        assertNotNull(afbeelding.getPixels());
        assertEquals(HOOGTE*BREEDTE, afbeelding.getPixels().length*afbeelding.getPixels()[0].length);
    }

    @Test
    public void testGrijswaarden() {
        afbeelding.grijswaarde();
        for(RGBPixel[] rij : afbeelding.getPixels()) {
            for(RGBPixel pixel : rij) {
                assertTrue(isGrijswaarde(pixel));
            }
        }
    }

    private boolean isGrijswaarde(RGBPixel pixel) {
        return pixel.getRood() == pixel.getGroen() && pixel.getGroen() == pixel.getBlauw();
    }
}

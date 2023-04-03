package be.pxl.h3.oefextra1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class BerekeningApp {
    public static void main(String[] args) {
        int x = Input.readInt("Geef de waarde van x in: ");

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        double y = ThreadLocalRandom.current().nextDouble(0, 6000);

        System.out.println(decimalFormat.format(2.71828 * Math.sqrt((Math.pow(x, 2)) + Math.pow(y, 3))));

    }
}

package be.pxl.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProvinceTest {

    private Province province;

    @BeforeEach
    void SetUp() {
        province = new Province("genericCountry", 15, 2);
    }
    @Test
    void density_should_return_correct_amount() {
        Assertions.assertEquals(7.5, province.getDensity() );
    }

    @Test
    void compareTo_should_return_correct_values() {
        Province secondProvince = new Province("countryB", 18, 2);
        Province thirdProvince = new Province("countryC", 13, 2);
        Province fourthProvince = new Province("countryC", 15, 2);

        Assertions.assertEquals(1, province.compareTo(secondProvince));
        Assertions.assertEquals(-1, province.compareTo(thirdProvince));
        Assertions.assertEquals(0, province.compareTo(fourthProvince));

    }
}

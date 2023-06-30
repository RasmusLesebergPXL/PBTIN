package be.pxl.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CollisionRecordMapperTest {
    private Map<String, Province> provinceMap;
    private Province brusselHoofdstad;

    @BeforeEach
    public void init() {
        brusselHoofdstad = new Province("Brussel-Hoofdstad", 1222637, 161);
        provinceMap = new HashMap<>();
        provinceMap.put("Brussel-Hoofdstad", brusselHoofdstad);
        provinceMap.put("Provincie Antwerpen", new Province("Provincie Antwerpen", 1886609, 2867));
    }

    @Test
    public void testMapRecord() {
        String validData = "januari;dag;N;Bedrijfswagen;0;0;1;0;0;0;1;0;0;Brussel-Hoofdstad;Regenval;Dageraad - schemering;autosnelweg;met lichtgewonden";
        // TODO: implement this test
    }

    @Test
    public void testUnknownProvinceExceptionIsThrown() {
        String invalidData = "januari;dag;N;Bedrijfswagen;0;0;1;0;0;0;1;0;0;Brussel;Regenval;Dag;autosnelweg;met lichtgewonden";
        // TODO: implement this test
    }

}

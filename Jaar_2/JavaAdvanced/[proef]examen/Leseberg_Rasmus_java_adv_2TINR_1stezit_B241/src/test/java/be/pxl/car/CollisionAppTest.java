package be.pxl.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollisionAppTest {

    private CollisionApp collisionApp;

    @BeforeEach
    void setUp() {
        collisionApp = new CollisionApp();
    }

    @Test
    void getNumberOfCollisionRecordsTest() {
        assertEquals(42788, collisionApp.getNumberOfCollisionRecords());
    }

    @Test
    public void getNumberOfCollisionsWithRainInWeekendTest() {
        assertEquals(1173, collisionApp.getNumberOfCollisionsWithRainInWeekend());
    }

    @Test
    public void getNumberOfWeatherTypesTest() {
        assertEquals(13, collisionApp.getNumberOfWeatherTypes());
    }

    @Test
    public void getAverageNumberOfCarTypesInvolvedTest() {
        assertEquals(3.00, collisionApp.getAverageNumberOfCarTypesInvolved(), 0.01);
    }

    @Test
    public void getCollisionRecordsByOwnerTypeTest() {
        List<CollisionRecord> result = collisionApp.getCollisionRecordsByOwnerType("Bedrijfswagen");
        assertEquals(11019, result.size());
        assertEquals("Bedrijfswagen", result.get(500).getOwnerType());
    }

    @Test
    public void getMonthWithMostCollisionsWithSeriouslyInjuredTest() {
         String result = collisionApp.getMonthWithMostCollisionsWithSeriouslyInjured();
         assertEquals("oktober: 354", result);
    }

    @Test
    public void getDifferentWeatherTypesInMonthTest() {
        String result = collisionApp.getDifferentWeatherTypesInMonth("augustus", "nacht");
        assertEquals("Mist (zichtbaarheid minder dan 100m), Normaal, Onbekend, Regenval", result);
    }

    @Test
    public void getAllProvincesTest() {
        List<Province> result = collisionApp.getAllProvinces();
        assertEquals(11, result.size());
    }
}

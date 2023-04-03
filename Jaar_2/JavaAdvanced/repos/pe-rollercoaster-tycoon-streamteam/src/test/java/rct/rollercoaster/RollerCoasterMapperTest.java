package rct.rollercoaster;

import be.pxl.rct.rollercoaster.RideGenre;
import be.pxl.rct.rollercoaster.RollerCoaster;
import be.pxl.rct.rollercoaster.RollerCoasterMapper;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RollerCoasterMapperTest {

    @Test
    public void it_should_map_data_to_rollercoaster_correctly() {
        RollerCoasterType rollerCoaster = new RollerCoasterType();
        String data = "1;Bobsleigh Coaster;roller coaster;5.49;High;4.86;Medium;2700;16;25";
        String[] testList = data.split(";");

        rollerCoaster.setId(1);
        rollerCoaster.setType("Bobsleigh Coaster");
        rollerCoaster.setGenre(RideGenre.valueOf("roller coaster".replace(" ", "_").toUpperCase()));
        rollerCoaster.setExcitement(5.49);
        rollerCoaster.setExcitementRating("High");
        rollerCoaster.setNausea(4.86);
        rollerCoaster.setNauseaRating("Medium");
        rollerCoaster.setCost(2700);
        rollerCoaster.setPassengers(16);
        rollerCoaster.setRunningTime(25);

        RollerCoasterType ride = RollerCoasterMapper.mapDataToRollerCoasterType(testList);

        assertEquals(rollerCoaster.getId(), ride.getId());
        assertEquals(rollerCoaster.getType(), ride.getType());
        assertEquals(rollerCoaster.getGenre(), ride.getGenre());
        assertEquals(rollerCoaster.getExcitement(), ride.getExcitement());
        assertEquals(rollerCoaster.getNausea(), ride.getNausea());
        assertEquals(rollerCoaster.getNauseaRating(), ride.getNauseaRating());
        assertEquals(rollerCoaster.getCost(), ride.getCost());
        assertEquals(rollerCoaster.getPassengers(), ride.getPassengers());
        assertEquals(rollerCoaster.getRunningTime(), ride.getRunningTime());
    }

    @Test
    public void wrong_data_exception_caught() {
        String data = "1;Bobsleigh Coaster;roller coaster;5.49;High;";
        String[] testList = data.split(";");

        assertDoesNotThrow(() -> {
            RollerCoasterMapper.mapDataToRollerCoasterType(testList);
        });
    }
}



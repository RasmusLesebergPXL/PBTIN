package be.pxl.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CollisionExceptionTest {

    @Test
    void throws_collision_exception_properly() {
        Path path = Path.of("abc", "def", "ghi");
        Map<String, Province> provinceMap = new HashMap<>();

        Assertions.assertThrows(CollisionException.class, () ->  CollisionReader.loadCollisionRecords(path, provinceMap));
    }
}

package be.pxl.mission5.test;

import be.pxl.mission5.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointTests {

    private Point point;
    private Point samePoint;
    private Point differentPoint;
    @BeforeEach
    void SetUp() {
        this.point = new Point(3, 2);
        this.samePoint = new Point(3, 2);
        this.differentPoint = new Point(5, 7);
    }
    @Test
    void toString_should_return_correctly() {
        Assertions.assertEquals("(3,2)", point.toString());
    }

    @Test
    void equals_returns_correctly() {
        Assertions.assertEquals(samePoint, point);
        Assertions.assertNotEquals(differentPoint, point);
    }

    @Test
    void compareTo_works_correctly () {
        Assertions.assertEquals(3, point.compareTo(samePoint));
        Assertions.assertEquals(-1, point.compareTo(differentPoint));

        Point pointWithLowerY = new Point(0,0);
        Assertions.assertEquals(1, point.compareTo(pointWithLowerY));
    }
}

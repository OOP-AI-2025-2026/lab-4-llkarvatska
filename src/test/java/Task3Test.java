import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.opnu.java.inheritance.point.Point3D;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    @DisplayName("Test default constructor")
    void test1() {
        Point3D p = new Point3D();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(0, p.getZ());
    }

    @Test
    @DisplayName("Test distance(Point3D p)")
    void test3() {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(5, 5, 6);
        double expected = 5.83095189;
        assertEquals(expected, p1.distance(p2), 0.0001);
    }

    @Test
    @DisplayName("Test overridden setLocation(int x, int y)")
    void test5() {
        Point3D p = new Point3D(10, 20, 30);
        p.setLocation(50, 60);
        assertEquals(50, p.getX());
        assertEquals(60, p.getY());
        assertEquals(0, p.getZ());
    }

    @Test
    @DisplayName("Test overridden distanceFromOrigin()")
    void test6() {
        Point3D p = new Point3D(3, 4, 12);
        double expected = 13.0;
        assertEquals(expected, p.distanceFromOrigin(), 0.0001);
    }
}
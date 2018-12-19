package learning.tests;

import learning.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PointTest {

    Point point1;
    Point point2;
    Point point3;
    Point point12;
    Point point31;

    @BeforeEach
    void setUp() {
        point1 = new Point(1,1,11);
        point2 = new Point(2,2,22);
        point3 = new Point(3,3,33);
        point12 = new Point(12, 1, 22);
        point31 = new Point(31, 3, 11);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isVisited() {
        assertFalse(point1.isVisited());
        assertFalse(point2.isVisited());
        assertFalse(point3.isVisited());
    }

    @Test
    void setVisited() {
        point1.setVisited(true);
        assertTrue(point1.isVisited());
        assertFalse(!point1.isVisited());
        point1.setVisited(false);
        assertTrue(!point1.isVisited());
        assertFalse(point1.isVisited());
    }

    @Test
    void isNoise() {
        assertFalse(point1.isNoise());
        assertTrue(!point1.isNoise());
    }

    @Test
    void setNoise() {
        point1.setNoise(true);
        assertTrue(point1.isNoise());
    }

    @Test
    void isInAnyCluster() {
        assertFalse(point1.isInAnyCluster());
    }

    @Test
    void setInAnyCluster() {
        point1.setInAnyCluster(true);
        assertTrue(point1.isInAnyCluster());
    }

    @Test
    void getId() {
        assertEquals(1, point1.getId());
        assertNotEquals(2,point1.getId());
        assertEquals(2, point2.getId());
        assertEquals(3, point3.getId());
    }

    @Test
    void setId() {
        point1.setId(101);
        assertNotEquals(1, point1.getId());
        assertEquals(101, point1.getId());
    }

    @Test
    void getX() {
        assertEquals(1, point1.getX());
        assertEquals(2, point2.getX());
        assertEquals(3, point3.getX());
    }

    @Test
    void getY() {
        assertEquals(11, point1.getY());
        assertEquals(22, point2.getY());
        assertEquals(33, point3.getY());
    }

    @Test
    void setLocation() {
        point1.setLocation(1.11, 2.22);
        assertEquals(1.11, point1.getX());
        assertEquals(2.22, point1.getY());
    }

    @Test
    void getDistance() {
        assertEquals(11, point1.getDistance(point12.getX(), point12.getY()));
        assertEquals(11, point12.getDistance(point1.getX(), point1.getY()));
        assertEquals(2, point1.getDistance(point31.getX(), point31.getY()));
        assertEquals(2, point31.getDistance(point1.getX(), point1.getY()));
    }

    @Test
    void toStringTest() {
        assertEquals("Point{id=1, x=1.0, y=11.0}", point1.toString());
        assertEquals("Point{id=2, x=2.0, y=22.0}", point2.toString());
        assertEquals("Point{id=3, x=3.0, y=33.0}", point3.toString());
        assertEquals("Point{id=12, x=1.0, y=22.0}", point12.toString());
        assertEquals("Point{id=31, x=3.0, y=11.0}", point31.toString());
    }

    @Test
    void compareTo() {
        assertEquals(-1, point1.compareTo(point2));
        assertEquals(1, point2.compareTo(point1));
        assertEquals(-1, point1.compareTo(point3));
        assertEquals(-1, point1.compareTo(point12));
        assertEquals(-1, point1.compareTo(point31));
        assertEquals(0, point1.compareTo(point1));
        assertEquals(1, point31.compareTo(point12));
        assertEquals(1, point31.compareTo(point3));
        assertEquals(1, point31.compareTo(point2));
        assertEquals(1, point31.compareTo(point1));
    }
}
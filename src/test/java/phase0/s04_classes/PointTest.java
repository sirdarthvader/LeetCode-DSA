package phase0.s04_classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void constructorSetsBothFields() {
        Point p = new Point(3, 4);
        assertEquals(3, p.x);
        assertEquals(4, p.y);
        Point q = new Point(-2, 0);
        assertEquals(-2, q.x);
        assertEquals(0, q.y);
    }

    @Test
    void noArgumentsMeansTheOrigin() {
        Point o = new Point();
        assertEquals(0, o.x);
        assertEquals(0, o.y);
    }

    @Test
    void manhattanDistance() {
        assertEquals(7, new Point(1, 1).manhattanTo(new Point(4, 5)));
        assertEquals(0, new Point(2, 3).manhattanTo(new Point(2, 3)));
        assertEquals(5, new Point().manhattanTo(new Point(-2, 3)));
    }

    @Test
    void manhattanIsTheSameBothWays() {
        Point a = new Point(4, 5), b = new Point(1, 1);
        assertEquals(7, a.manhattanTo(b));
        assertEquals(7, b.manhattanTo(a));
    }

    @Test
    void movedGivesANewPoint() {
        Point p = new Point(1, 2);
        Point q = p.moved(3, -1);
        assertEquals(4, q.x);
        assertEquals(1, q.y);
        assertNotSame(p, q);
    }

    @Test
    void movedLeavesTheOriginalWhereItWas() {
        Point p = new Point(1, 2);
        p.moved(3, -1);
        assertEquals(1, p.x);
        assertEquals(2, p.y);
    }

    @Test
    void printsAsACoordinate() {
        assertEquals("(3, 4)", new Point(3, 4).toString());
        assertEquals("(-1, 0)", new Point(-1, 0).toString());
        assertEquals("(0, 0)", new Point().toString());
    }
}

package phase0.s04_classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CounterTest {

    @Test
    void startsAtZero() {
        assertEquals(0, new Counter("likes").value());
    }

    @Test
    void keepsItsLabel() {
        assertEquals("likes", new Counter("likes").label());
        assertEquals("", new Counter("").label());
    }

    @Test
    void incrementAddsOne() {
        Counter c = new Counter("clicks");
        c.increment();
        c.increment();
        c.increment();
        assertEquals(3, c.value());
    }

    @Test
    void addHandlesPositiveAndNegative() {
        Counter c = new Counter("score");
        c.add(3);
        c.add(4);
        assertEquals(7, c.value());
        c.add(-9);
        assertEquals(-2, c.value());
    }

    @Test
    void resetGoesBackToZeroAndKeepsTheLabel() {
        Counter c = new Counter("laps");
        c.add(10);
        c.reset();
        assertEquals(0, c.value());
        assertEquals("laps", c.label());
        c.increment();
        assertEquals(1, c.value());
    }

    @Test
    void twoCountersAreIndependent() {
        Counter likes = new Counter("likes");
        Counter views = new Counter("views");
        likes.increment();
        likes.increment();
        views.add(10);
        assertEquals(2, likes.value());
        assertEquals(10, views.value());
        assertEquals("likes", likes.label());
        assertEquals("views", views.label());
    }
}

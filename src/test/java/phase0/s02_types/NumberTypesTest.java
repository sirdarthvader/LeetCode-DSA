package phase0.s02_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberTypesTest {

    static final int MAX = Integer.MAX_VALUE;
    static final int MIN = Integer.MIN_VALUE;

    @Test
    void averageOfSmallNumbers() {
        assertEquals(3, NumberTypes.average(2, 4));
        assertEquals(3, NumberTypes.average(3, 4));
        assertEquals(0, NumberTypes.average(0, 0));
    }

    @Test
    void averageOfHugeNumbers() {
        assertEquals(MAX, NumberTypes.average(MAX, MAX));
        assertEquals(MAX - 1, NumberTypes.average(MAX - 1, MAX));
        assertEquals(1_073_741_823, NumberTypes.average(0, MAX));
    }

    @Test
    void fitsWhenSumIsSmall() {
        assertTrue(NumberTypes.fitsInInt(1, 2));
        assertTrue(NumberTypes.fitsInInt(-5, -7));
        assertTrue(NumberTypes.fitsInInt(MAX, 0));
        assertTrue(NumberTypes.fitsInInt(MAX, MIN));
    }

    @Test
    void doesNotFitPastTheTop() {
        assertFalse(NumberTypes.fitsInInt(MAX, 1));
        assertFalse(NumberTypes.fitsInInt(2_000_000_000, 2_000_000_000));
    }

    @Test
    void doesNotFitPastTheBottom() {
        assertFalse(NumberTypes.fitsInInt(MIN, -1));
        assertFalse(NumberTypes.fitsInInt(MIN, MIN));
    }

    @Test
    void factorialOfSmallNumbers() {
        assertEquals(1L, NumberTypes.factorial(0));
        assertEquals(1L, NumberTypes.factorial(1));
        assertEquals(120L, NumberTypes.factorial(5));
    }

    @Test
    void factorialPastIntRange() {
        assertEquals(6_227_020_800L, NumberTypes.factorial(13));
        assertEquals(2_432_902_008_176_640_000L, NumberTypes.factorial(20));
    }
}
